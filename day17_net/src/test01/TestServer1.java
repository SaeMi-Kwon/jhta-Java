package test01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * [ 서버프로그램 ]
 * 
 * 1. ServerSocket생성 (port번호 지정)
 * 2. accept메소드 실행(클라이언트접속대기 -> 허용 -> 클라이언트와 데이터를 송수신하기 위한 Socket객체 생성)
 * 3. Socket객체를 통해 데이터 주고 받기(io스트림 이용)
 * 4. 접속해제(close메소드)
 * 
 */
public class TestServer1 {
	public static void main(String[] args) {
		//1. ServerSocket생성 (port번호 지정)
		ServerSocket server=null; 
		
		try {
			server=new ServerSocket(3000);
			System.out.println("서버실행중.....");
			
			//2.accept메소드 실행
			Socket socket =server.accept();
			System.out.println("클라이언트가 접속했습니다");
			
			//클라이언트가 보내온 문자열을 읽어오기 위한 입력스트림 객체
			InputStream is=socket.getInputStream();
			byte[] b=new byte[100];
			//클라이언트가 보내온 데이터를 b배열에 저장,n에는 클라이언트가 보내온 데이터의 바이트수 크기가 저장
			int n=is.read(b);
			//b배열의 0번째부터 n바이트까지만 화면에 출력하기
			System.out.write(b,0,n);
			
			//연결해제
			is.close();
			socket.close();
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
			
		}finally {
			try {
				//4. 접속해제(close메소드)
				if(server!=null) server.close();
			}catch(IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
		
	}
}
