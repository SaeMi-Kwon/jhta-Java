package day18_net;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


class ClientFrame extends JFrame {
	JPanel pan = new JPanel();

	JTextField txtMsg=new JTextField(20);
	JButton btnSend=new JButton("보내기");
	JButton btnExit=new JButton("종료");
	   
	Socket socket=null;
	PrintWriter pw=null;
	BufferedReader br=null;
	  
	DefaultListModel<String> model = new DefaultListModel<>(); //백터로 해도 무방하다
	JList<String> list = new JList<>(model);

	public ClientFrame() {
		super("채팅프로그램");
		setLayout(new BorderLayout());
		pan.add(new JLabel("보낼메시지"));
		pan.add(txtMsg);
		pan.add(btnSend);
		pan.add(btnExit);

		add(pan, BorderLayout.SOUTH);
		add(new JScrollPane(list), BorderLayout.CENTER);

		setSize(600, 600);
		setVisible(true);
		
		try {
			//1.서버에 접속하기
			socket=new Socket("127.0.0.1",3000);
			model.addElement("서버에 접속했습니다.");
			br=new BufferedReader(new BufferedReader(new InputStreamReader(socket.getInputStream())));
			pw=new PrintWriter(socket.getOutputStream());
			
			//닉네임 입력받기
			String nickName=JOptionPane.showInputDialog("사용할 대화명을 입력하세요");
			//제일 먼저 서버에 닉네임 보내기
			pw.println(nickName);
			pw.flush();
			
			//서버에서 보내온 데이터를 수신하는 스레드
			new Thread(()->{
				try {
					while(true) {
						String msg=br.readLine();
						if(msg==null) {
							model.addElement("서버와 연결이 끊겼습니다.");
							break;
						}
						//서버가 보내온 메시지를 모델객체에 추가하기
						model.addElement(msg);
					}
					br.close();
					pw.close();
					socket.close();
					
				}catch(IOException ie) {
					System.out.println(ie.getMessage());
				}
			}).start();
			
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		btnSend.addActionListener(e->{
			//텍스트필드에 입력된 메시지 읽어오기
			String msg=txtMsg.getText();
			//서버에 메시지 보내기
			pw.println(msg);
			pw.flush();
			//JList에 내가 보낸 메시지 추가하기
			model.addElement("나>>"+ msg);
			txtMsg.setText(""); //텍스트 필드 지우기
			txtMsg.requestFocus();
		});
		
		btnExit.addActionListener((e)->{
			try {
				if(pw!=null) pw.close();
				if(br!=null) br.close();
				if(socket!=null) socket.close();
				model.addElement("서버와 연결 해제되었습니다");
				
			}catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		});
		
	       
	}
}

public class Test04_ClientGUI {
	public static void main(String[] args) {
		new ClientFrame();
	}
}
