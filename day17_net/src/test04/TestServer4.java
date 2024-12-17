package test04;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * < 서버 >
 * 1.제일먼저 클라이언트가 보낸온 파일명 읽어오기(DataInputStream 사용)
 * 2.클라이언트가 보내온 데이터를 읽어와서(DataInputStream)파일에 저장하기(FileOutputStream) - 루프돌기
 * 3.접속종료
 * 
 */
public class TestServer4 {
	public static void main(String[] args) {
		ServerSocket server=null; 
		try {
			server=new ServerSocket(3003);
			System.out.println("서버실행중.....");
			Socket socket =server.accept();
			System.out.println("클라이언트가 접속했습니다.");
			
			//클라이언트가 보내온 데이터를 읽어오기 위한 스트림
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			File f=new File("c:\\2407\\upload");
			if(!f.exists()) {  //클라이언트가 보내온 파일을 저장할 디렉토리가 존재하지 않으면
				f.mkdirs();  //디렉토리 생성하기
			}
			//클라이언트가 맨처음 보낸 파일명 읽어오기
			String fileName=dis.readUTF();
			//클라이언트가 전송할 파일을 복사하기(저장)위한 파일스트림 객체 생성
			FileOutputStream fos=new FileOutputStream(f.getAbsolutePath() + "\\" + fileName);
			
			byte[] b=new byte[100];
			while(true) {	
				//클라이언트가 보내온 데이터를 b배열에 저장,n에는 읽어온 바이트수 크기가 저장됨
				int n=dis.read(b);
				if(n==-1) {
					break;
				}
				//b배열의 0번째부터 n바이트수 크기만큼 <파일>로 저장 하기
				fos.write(b,0,n);
			}

			fos.close();
			dis.close();
			socket.close();
			System.out.println("전송된 파일 저장 완료!");
			server.close();
			

		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	}
}
