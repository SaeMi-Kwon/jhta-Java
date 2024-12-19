package quiz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

class SerFrame extends JFrame {
	   JTextField txt = new JTextField(10);
	   JButton sendBtn = new JButton("보내기");
	   JButton exitBtn = new JButton("종료");
	   JPanel pan1 = new JPanel();


	   DefaultListModel<String> model = new DefaultListModel<>();
	   JList<String> list = new JList<>(model);




	   public SerFrame() {
	       super("서버프로그램");


	       pan1.add(new JLabel("보낼메시지"));
	       pan1.add(txt);
	       pan1.add(sendBtn);
	       pan1.add(exitBtn);


	       add(pan1, BorderLayout.SOUTH);
	       add(new JScrollPane(list), BorderLayout.CENTER);


	       setSize(600, 700);
	       setVisible(true);


	       try {
	           ServerSocket server = new ServerSocket(4000);
	           System.out.println("접속대기중....");


	           Socket socket = server.accept();
	           System.out.println("클라이언트가 접속했어요");


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


	class RecServer extends Thread{
	   Socket socket;


	   public RecServer(Socket socket) {
	       this.socket=socket;
	   }


	   @Override
	   public void run() {
	       try {
	           BufferedReader br=
	                   new BufferedReader(new InputStreamReader(socket.getInputStream()));


//	           while(true) {
//	               //model에서 데이터를 꺼내오기
//	        	   
//
//
//
//	               if(RecMsg==null) {
//	                   System.out.println("상대방이 접속을 해제했습니다.");
//	                   break;
//	               }
//	               //메시지를 화면에 출력하기
//	               System.out.println("클라이언트>> "+RecMsg);
//	           }
//	           br.close();
	           socket.close();


	       } catch (IOException ie) {
	           System.out.println(ie.getMessage());
	       }
	   }
	}

	
public class Server {
	public static void main(String[] args) {
		new SerFrame();
	}
}
