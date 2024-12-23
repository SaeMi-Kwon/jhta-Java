  package test01;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * [ 클라이언트 프로그램]
 * 
 * 1. 서버접속하기(Socket객체 사용 - 서버 ip주소/포트 지정)
 * 2. Socket객체를 사용해서 서버와 데이터 송수신하기(io스트림 사용)
 * 3. 접속해제
 * 
 */
public class TestClient1 {
	public static void main(String[] args) {
		try {
			//1. 서버접속하기
			Socket socket=new Socket("localhost", 3000);
			System.out.println("서버에 접속성공!");
			
			String msg="안녕하세요.권새미라고 합니다.";
			
			//상대방(서버)에 데이터를 보내기 위한 출력스트림객체 얻어오기
			OutputStream os=socket.getOutputStream();
			
			//OutputStream은 1바이트 처리스트림이므로 String을 byte배열로 바꾸기
			byte[] b=msg.getBytes();
			
			//서버에 문자열 전송하기
			os.write(b);
			
			//연결해제
			os.close();
			socket.close();
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
