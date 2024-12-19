package day18_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

//InetAddress : ip주소와 관련된 정보를 갖는 클래스

public class Test01_InetAddress {
	public static void main(String[] args)  {
		
		try {
			//public static InetAddress getByName(String host) throws UnknownHostException
			InetAddress ia = InetAddress.getByName("www.naver.com");	
			
			//ip주소 얻어오기
			String ip=ia.getHostAddress();
			System.out.println("ip==>" + ip);
			
			InetAddress local=InetAddress.getLocalHost();
			String localIp=local.getHostAddress();
			System.out.println("내 pc ip: " + localIp);
			
		}catch(UnknownHostException ue) {
			System.out.println(ue.getMessage());
		}
	}
}
