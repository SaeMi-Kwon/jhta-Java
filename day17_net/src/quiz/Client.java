package quiz;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


class ClientRec extends Thread {
	Socket socket;
	
	public ClientRec(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					ClientFrame.model.addElement("서버가 연결을 종료했습니다.");
					break;
				}
				ClientFrame.model.addElement("서버: " + msg);
			}
			System.out.println("실행됩니다.");
			br.close();
			socket.close();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}

class ClientFrame extends JFrame {
	static DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> chat = new JList<>(model);
	JPanel panel = new JPanel();
	JTextField txt = new JTextField(20);
	JButton sendBtn = new JButton("전송");
	JButton exitBtn = new JButton("종료");
	
	public ClientFrame() throws IOException, InterruptedException {
		super("클라이언트");
		setLayout(new BorderLayout());
		add(new JScrollPane(chat), BorderLayout.CENTER);
		panel.add(new JLabel("메시지 입력"));
		panel.add(txt);
		panel.add(sendBtn);
		exitBtn.addActionListener(e -> System.exit(0));
		panel.add(exitBtn);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		add(panel, BorderLayout.SOUTH);
		setSize(500, 750);
		setLocation(1000, 200);
		setVisible(true);
		Socket socket = new Socket("localhost", 5000);
		model.addElement("서버에 접속했습니다!");
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		sendBtn.addActionListener(e -> {
			String msg = txt.getText();
			pw.println(msg);
			pw.flush();
			model.addElement("클라이언트: " + msg);
			txt.setText("");
		});
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String msg = txt.getText();
					pw.println(msg);
					pw.flush();
					model.addElement("서버: " + msg);
					txt.setText("");
				}
			}
		});
		ClientRec rec = new ClientRec(socket);
		rec.start();
		rec.join();
		pw.close();
	}
}

public class Client {
	public static void main(String[] args) {
		try {
			new ClientFrame();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
