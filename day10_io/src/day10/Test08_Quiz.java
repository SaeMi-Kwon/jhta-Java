package day10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//phone.txt파일을 모두 읽어와 화면에 출력해 보세요(FileReader)

public class Test08_Quiz {
	public static void main(String[] args) {
		
		FileReader pr=null;
		
		try {
			pr = new FileReader("c:\\2407\\phone.txt");
			
			while(true) {
				int ch=pr.read();  //char로 리턴하게 되면 -1로 리턴을 할수 없기에 int형으로 선언하는것
				if(ch==-1) break;  
				System.out.print((char)ch);
			}

		}catch(FileNotFoundException fe) {
			System.out.println("파일이 존재하지 않아요" + fe.getMessage());
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
			
		}finally {
			try {
				if(pr!=null) pr.close();   //pr이 null 아닐때만 close해라
			}catch(IOException e) {
				System.out.println("에러2==>" + e.getMessage());
			}
		}
	}
}
