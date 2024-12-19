package day18_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//서버가 보내온 메시지를 읽어오는 스레드
class RecThread extends Thread{
	Socket socket;
	public RecThread(Socket socket) {
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String msg=br.readLine();
				if(msg==null) {
					System.out.println("서버와 연결이 해제 되었습니다");
					break;
				}
				System.out.println("상대방>>" + msg);
			}
			br.close();
			socket.close();
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
//서버에 메시지를 보내는 스레드
class SendThread extends Thread{
	Socket socket;
	public SendThread(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		Scanner scan=new Scanner(System.in);
		try {
			//true: auto(자동) flush설정
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);  
			while(true) {
				//서버에 보낼 메시지 입력하기
				String msg=scan.nextLine();
				if(msg.equals("exit")) {
					System.out.println("채팅을 종료합니다.");
					break;
				}
				//서버에 메시지 보내기
				pw.println(msg);
				//pw.flush();
			}
			pw.close();
			scan.close();
			socket.close();
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}


public class Test03_Client {
	public static void main(String[] args) {
		try {
			Socket socket =new Socket("192.168.80.13",3000);
			System.out.println("서버접속 성공!");
			
			new RecThread(socket).start();
			new SendThread(socket).start();

		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
