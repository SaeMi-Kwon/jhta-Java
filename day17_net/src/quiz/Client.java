package quiz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class RecFrame extends JFrame {
	JTextField txt = new JTextField(10);
	JButton sendBtn = new JButton("보내기");
	JButton exitBtn = new JButton("종료");
	JPanel pan1 = new JPanel();
	
	
	DefaultListModel<String> model = new DefaultListModel<>();
	JList<String> list = new JList<>(model);
	
	
	
	
	public RecFrame() {
		super("클라이언트프로그램");
	
	
		pan1.add(new JLabel("보낼메시지"));
		pan1.add(txt);
		pan1.add(sendBtn);
		pan1.add(exitBtn);
	
	
		add(pan1, BorderLayout.SOUTH);
		add(new JScrollPane(list), BorderLayout.CENTER);
	
	
		setSize(600, 700);
		setVisible(true);
	
	
		try {
			Socket socket=new Socket("localhost",4000);
			System.out.println("서버에 접속 성공!");
	
	
			new RecServer(socket).start();
	
	
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
	
	
		ActionListener sendAction=new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chat=txt.getText();

				model.addElement(chat);
				txt.setText("");
				txt.requestFocus();
			}
		};
		sendBtn.addActionListener(sendAction);
	
	
		       ActionListener exitAction=new ActionListener() {
		           @Override
		           public void actionPerformed(ActionEvent e) {
		               System.out.println("프로그램 종료");
		               System.exit(0);
		           }
		       };
		       exitBtn.addActionListener(exitAction);
		   }
		}



public class Client {
	public static void main(String[] args) {
		new Client();
	}
}
