package day10;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//FileOutputStream : 파일에 데이터를 출력하는 1바이트 출력스트림 클래스

public class Test09_FileOutputStream {
	public static void main(String[] args) {
		try {
			//public FileOutputStream(File file) throws FileNotFoundException
			FileOutputStream fos = new FileOutputStream("test.dat");
			
			//public void write(byte[] b) throws IOException
			byte[] b= {65,66,67,68,69};
			fos.write(b);
			
			System.out.println("파일로 저장 완료!");
			fos.close();
			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
	
}
