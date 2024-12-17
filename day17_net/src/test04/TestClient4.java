package test04;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/*
 * < 클라이언트 >
 * 1.전송할 파일명을 입력받기(DataOutputStream 사용)
 * 2.제일먼저 파일명을 서버로 보내기
 * 3.파일에서 데이터 읽어와서(FileInputStream) 데이터를 보내기(DataOutputStream) - 루프돌기
 * 4.접속종료
 * 
 */

public class TestClient4 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		try {
			Socket socket=new Socket("localhost", 3003);
			System.out.println("서버에 접속성공!");
		
			System.out.println("파일명을 입력해주세요");
			String file=scan.nextLine();
			File f=new File(file);
			
			if(!f.exists()) {
				System.out.println("존재하지 않는 파일입니다..");
				socket.close();
				return;
			}
			
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			String fileName=f.getName();  //파일명만 꺼내오기
			dos.writeUTF(fileName);  //제일 먼저 파일명을 보내기
			
			//파일을 읽어오기 위한 스트림객체 생성
			FileInputStream fis= new FileInputStream(f);
			
			byte[] b=new byte[255];
			long fileSize=0;
			while(true) {
				int n=fis.read(b);  //파일에서 데이터 읽어와 b배열에 저장, n에는 파일에서 읽어온 바이트 수 크기가 저장
				fileSize += n;  //전송할 파일의 크기
				if(n==-1) {
					break;
				}		
				dos.write(b,0,n);  //b배열의 0번째 부터 읽어온 바이트수 크기만큼 서버로 데이터 보내기
			}
			
			fis.close();
			dos.close();
			socket.close();
			System.out.println(fileSize + "bytes 파일전송 완료!");
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
	
}
