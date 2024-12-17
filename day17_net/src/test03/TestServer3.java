package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

class SendServer extends Thread{
	Socket socket;
	
	public SendServer(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		
		Scanner scan=new Scanner(System.in);

			try {
				PrintWriter pw =new PrintWriter(socket.getOutputStream());
				while(true) {
					//키보드로 문자열 입력받기
					//System.out.println("클라이언트에게 메시지 보내기>>");
					String sendMsg=scan.nextLine();
					
					if(sendMsg.equals("exit")) {
						System.out.println("메시지전송을 끝내겠습니다");
						break;
					}
					
					//클라이언트에 문자열 보내기
					pw.println(sendMsg);
					pw.flush();
				}
				pw.close();
				scan.close();
				socket.close();
				System.exit(0);
		
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}

class RecServer extends Thread{
	Socket socket;
	
	public RecServer(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		//클라이언트가 보낸 메시지 읽어오기
		try {
			BufferedReader br=
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String RecMsg=br.readLine();
				if(RecMsg==null) {
					System.out.println("상대방이 접속을 해제했습니다.");
					break;
				}
				//메시지를 화면에 출력하기
				System.out.println("클라이언트가 보낸 답장>> "+RecMsg);
			}
			br.close();
			socket.close();
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}

public class TestServer3 {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(3002);
			System.out.println("접속대기중....");
			
			Socket socket = server.accept();
			System.out.println("클라이언트가 접속했어요");
			
			//데이터를 보내는 스레드 실행
			new SendServer(socket).start();
			//데이터를 수신하는 스레드 실행
			new RecServer(socket).start();
			
			server.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		
	}
}
