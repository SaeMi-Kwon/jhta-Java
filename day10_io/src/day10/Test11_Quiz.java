package day10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * FileInputStream/FileOutputStream을 이용해서 파일 복사하는 프로그램을 작성해 보세요.
 * 
 * 예)
 * 원본 파일명
 * test.dat
 * 복사될 파일명
 * copy.dat
 * 
 * -> test.dat파일과 똑같은 내용을 갖는 copy.dat 파일이 생성된다.
 * 
 */
public class Test11_Quiz {
	public static void main(String[] args) {
			Scanner scan=new Scanner(System.in);
			System.out.println("원본파일명");
			String orgFileName=scan.nextLine();  // c:\2407\a.dat (키보드로 입력할때 \\로 안써도된다)
			System.out.println("복사본 파일명");
			String copyFileName=scan.nextLine();  // c:\2407\copy.dat	
			
		try {	
			FileInputStream fis=new FileInputStream(orgFileName);
			FileOutputStream fos = new FileOutputStream(copyFileName);
			
//			//public FileInputStream(String name) throws FileNotFoundException
//			FileInputStream fis=new FileInputStream("test.dat");  //입력스트림
//			FileOutputStream fos = new FileOutputStream("copy.dat"); //출력스트림

			long len=0;
			byte[] b=new byte[100];
			
			while(true) {
				//public int read(byte[] b) throws IOException: 읽어올 데이터가 없으면 -1 리턴
				int n=fis.read(b);  
				len += n; //전체 파일크기
				if(n==-1) break;  
					
				//public void write(byte[] b,int off,int len) throws IOException
				fos.write(b,0,n);
			}    
	
			fos.close();
			fis.close();
			
			System.out.println(len + "bytes 크기의 파일 복사 완료!");
			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}
