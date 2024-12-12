package quiz;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 	1.영어단어와 뜻을 키보드로 입력받아 PrintWriter를 사용해서 파일로 저장해 보세요.
 	## 파일 eng.txt
  	love,사랑하다
  	apple,사과
  	yellow,노랑

 	"0"입력하면 종료
 */
public class Test01 {
	public static void main(String[] args) {
		
		try {
			//public PrintWriter(OutputStream out)
			PrintWriter pw = new PrintWriter(new FileOutputStream("eng.txt"));
			
			while(true) {
				
				Scanner scan = new Scanner(System.in);
		
				System.out.println("영어단어입력('0': 종료)");
				String word=scan.next();
				
				if(word.equals("0")) break;

				System.out.println("뜻 입력");
				String mean=scan.next();
				
				pw.println(word + "," + mean);
			}
			
			pw.close();
			System.out.println("파일로 저장 완료");
			
		}catch(FileNotFoundException fe) {
			System.out.println(fe.getMessage());
		}
		
		
	}
}
