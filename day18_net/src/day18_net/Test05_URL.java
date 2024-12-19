package day18_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

//URL : URL에 접속 및 데이터를 얻어올수 있는 기능의 클래스
public class Test05_URL {
	public static void main(String[] args) {
		
		try {
			String s="https://n.news.naver.com/article/029/0002924020";
			URL url=new URL(s); //접속할 url객체 생성
			InputStream is=url.openStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			
			while(true) {
				String text=br.readLine();
				if(text==null) break;
				System.out.println(text);
			}
			
		} catch (MalformedURLException me) {
			System.out.println(me.getMessage());
			
		} catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
