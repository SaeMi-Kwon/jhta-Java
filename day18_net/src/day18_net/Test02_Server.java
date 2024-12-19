package day18_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

//클라이언트에서 메시지를 보내오면 이 메시지를 다른 클라이언트들에게 보내는 스레드
class EchoThread extends Thread{
	Socket socket; //클라이언트와 연결되어 있는 소켓(나 자신의 소켓)
	Vector<Socket> vector; //모든 클라이언트(나 포함)와 연결된 소켓을 담고 있는 Vector객체
	
	public EchoThread(Socket socket,Vector<Socket> vector) {
		this.socket=socket;
		this.vector=vector;
	}
	@Override
	public void run() {
		try {
			//클라이언트가 보내온 데이터 읽어오기
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			while(true) {
				//클라이언트가 보내온 메시지 읽어오기
				String msg=br.readLine();
				if(msg==null) {
					System.out.println("클라이언트가 접속을 해제했습니다.");
					vector.remove(socket);  //vector에서 클라이언트와 연결된 소켓 제거하기
					break;
				}
				//보내온 데이터를 다른 클라이언트들에게 보내기
				sendMsg(msg);
			}
			br.close();
			socket.close();
		
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
	//보내온 데이터를 다른 클라이언트들에게 보내는 메소드
	public void sendMsg(String msg) throws IOException {
		for(int i=0;i<vector.size();i++) {
			Socket s=vector.get(i);  //Vector의 타입은 Socket이므로 반환타입은 Socket으로 한다.
			if(s!=socket) { //메시지를 수신한 소켓은 제외하고 다른 클라이언트들에게 메시지 보내기
				PrintWriter pw=new PrintWriter(s.getOutputStream());
				pw.println(msg);
				pw.flush();
			}
			
		}
		
	}
}

public class Test02_Server {
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(3000);
			Vector<Socket> vector=new Vector<Socket>();
			
			while(true) {
				System.out.println("접속대기중...");
				Socket socket=server.accept();
				
				//클라이언트의 ip주소 정보를 갖는 InetAddress객체 얻어오기
				InetAddress ia=socket.getInetAddress();
				System.out.println("클라이언트가 접속[ip: " + ia.getHostAddress() +"]");
				
				vector.add(socket);
				//연결된 클라이언트의 메시지를 받아서 다른 클라이언트들에게 받은 메시지를 보내주는 스레드 실행
				new EchoThread(socket, vector).start();
			}
			
		
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
