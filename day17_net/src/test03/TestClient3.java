package test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


class SendClient extends Thread{
	Socket socket;
	
	public SendClient(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {
		Scanner scan=new Scanner(System.in);
		try {
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			
			while(true) {
				//System.out.println("서버에게 메시지 보내기>>");
				String sendMsg=scan.nextLine();
				if(sendMsg.equals("exit")) {
					System.out.println("메시지전송을 끝내겠습니다");
					break;
				}
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

class RecClient extends Thread{
	Socket socket;
	
	public RecClient(Socket socket) {
		this.socket=socket;
	}
	
	@Override
	public void run() {	
		try {
			//서버가 보낸 문자열을 읽어오기 위한 스트림
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				String RecMsg=br.readLine();
				
				if(RecMsg==null) {
					System.out.println("상대방이 연결을 해제했습니다");
					break;
				}
			
				//메시지를 화면에 출력하기
				System.out.println("서버가 보낸 답장>>" + RecMsg);
			}
			
			br.close();
			socket.close();
			
		} catch (IOException ie) {
			System.out.println(ie);
		}
	}

}


public class TestClient3 {
	public static void main(String[] args) {
		
		try {
			Socket socket=new Socket("192.168.80.55",3002);
			System.out.println("서버에 접속 성공!");
			
			//데이터를 보내는 스레드 실행
			new SendClient(socket).start();
			//데이터를 수신하는 스레드 실행
			new RecClient(socket).start();
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
