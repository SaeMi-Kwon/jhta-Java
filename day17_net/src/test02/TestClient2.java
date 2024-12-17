package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient2 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		try {
			Socket socket=new Socket("192.168.80.14",3001);
			System.out.println("서버에 접속 성공!");

			//서버에 데이터를 보내기위한 스트림객체 생성하기
			OutputStream os=socket.getOutputStream();
			
			//1바이트 처리스트림을 2바이트 처리스트림으로 만들기(문자열을 편리하게 처리하기 위해)
			PrintWriter pw=new PrintWriter(os);
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			while(true) {
				System.out.println("서버에 보낼 메시지 입력");
				String msg=scan.nextLine();
				if(msg.equals("exit")) {
					System.out.println("메시지전송을 끝내요");
					break;
				}
	
				//서버에 문자열 보내기
				pw.println(msg);
				//버퍼가 다 차지 않아도 문자열을 서버에 보내라.
				pw.flush();
			
				//서버에서 보낸 메시지 출력
				String recMsg=br.readLine();
				if(recMsg==null) {
					System.out.println("상대방이 연결을 해제했습니다");
					break;
				}
				System.out.println("서버에서 보낸온 메시지>> " + recMsg);
				
			}
			//닫을때는 연결된 순서 역순으로 닫기
			br.close();
			pw.close();
			os.close();
			socket.close();
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
