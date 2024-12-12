package day11_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 * BufferedOutputStream 과 BufferedInputStream 클래스를 사용해서 파일복사하는 프로그램을 작성해 보세요.
 * 복사된 파일의 크기도 함께 출력해 보세요
 * 
 * 1.jpg -> copy.jpg
 * test.dat -> copy.dat
 * 
 */
public class Test04_Quiz {
	public static void main(String[] args) {

		try {
			
			//원본파일을 읽어오기 위한 스트림객체 생성  / 1024는 버퍼크기
			//public BufferedInputStream(InputStream out)
			BufferedInputStream fis = 
					new BufferedInputStream(new FileInputStream("test.dat"),1024);
			
			//복사본을 생성해서 출력할 스트림객체 생성  / 1024는 버퍼크기
			//public BufferedOutputStream(OutputStream out)
			BufferedOutputStream fos= 
					new BufferedOutputStream(new FileOutputStream("copy.dat"),1024);
			
//			while(true) {
//				//파일에서 1바이트 읽어와 n에 저장
//				int n=fis.read();
//				if(n==-1) break;
//				//n값을 파일로 출력(저장)
//				fos.write(n);
//			}
			
			byte[] b=new byte[100];
			long len=0;  
			while(true) {
				//파일(버퍼)에서 읽어와 b배열에 저장, n에는 읽어온 바이트수 크기 저장
				int n=fis.read(b);
				
				if(n==-1) break;
				
				len+=n;   //전체 바이트 수
				
				//b배열의 0번째부터 n개만큼 파일에 출력(저장)
				fos.write(b,0,n);
			}
			
			System.out.println("파일 복사 완료");
			System.out.println(len + "byte 크기만큼 파일 복사 완료");

			fos.close();
			fis.close();
			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		
		
	}
}
