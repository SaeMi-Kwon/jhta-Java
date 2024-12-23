package quiz;

import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ServerRec extends Thread {
	Socket socket;
	
	public ServerRec(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {
				String msg = br.readLine();
				if (msg == null) {
					ServerFrame.model.addElement("클라이언트가 접속을 종료했습니다.");
					break;
				}
				ServerFrame.model.addElement("클라이언트: " + msg);
			}
			br.close();
			socket.close();
		} catch (IOException ioe) {
			System.out.println("여기입니다!");
		}
	}
}

class ServerFrame extends JFrame {
	static DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> chat = new JList<>(model);
	JPanel panel = new JPanel();
	JTextField txt = new JTextField(20);
	JButton sendBtn = new JButton("전송");
	JButton exitBtn = new JButton("종료");
	
	public ServerFrame() throws IOException, InterruptedException {
		super("서버");
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
		setLocation(500, 200);
		setVisible(true);
		ServerSocket server = new ServerSocket(5000);
		model.addElement("접속 대기중...");
		Socket socket = server.accept();
		model.addElement("클라이언트가 접속했습니다!");
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		sendBtn.addActionListener(e -> {
			String msg = txt.getText();
			pw.println(msg);
			pw.flush();
			model.addElement("서버: " + msg);
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
		ServerRec rec = new ServerRec(socket);
		rec.start();
		rec.join();
		pw.close();
	}
}

public class Server {
	public static void main(String[] args) {
		try {
			new ServerFrame();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		} catch (InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
