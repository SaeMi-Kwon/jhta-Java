package test02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer2 {
	public static void main(String[] args) {
		ServerSocket server=null;
		
		try {
			server=new ServerSocket(3001);
			System.out.println("접속대기중....");
			
			Socket socket=server.accept();
			System.out.println("클라이언트가 접속했어요");
			
//			InputStream is=socket.getInputStream();
//			Reader reader=new InputStreamReader(is);
//			BufferedReader br=new BufferedReader(reader);
			
			Scanner scan=new Scanner(System.in);
			
			BufferedReader br=
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(socket.getOutputStream());
			
			while(true) {
				String msg=br.readLine();
				if(msg==null) {
					System.out.println("상대방이 접속을 해제했습니다.");
					break;
				}
				
				System.out.println("클라이언트가 보낸온 메시지>> " + msg);
		
				//서버에 답장메시지 보내고 클라이언트에서 출력해 보세요
				System.out.println("서버에서 답장 보내기>>");
				String sendMsg=scan.nextLine();
				if(sendMsg.equals("exit")) {
					System.out.println("메시지보내기를 종료합니다.");
					break;
				}
				pw.println(sendMsg);
				pw.flush();
			}
			//닫을때는 역순으로 닫기
			pw.close();
			br.close();
			socket.close();
			server.close();
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());

		}
	}
}
