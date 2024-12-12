package day10;
/*
 * 학생번호,이름,전화번호를 키보드로 입력받아(Scanner) phone.txt파일에 저장(FileWriter)해 보세요.
 * 입력데이터는 3명
 * 
 * ### phone.txt
 * 
 * 1.홍길동,010-111-1111
 * 2.이길동,010-222-1111
 * 3.삼길동,010-333-1111
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test07_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		FileWriter pw=null;
		
		try {
			pw=new FileWriter("c:\\2407\\phone.txt",true);
			
			//System.out.println("학생번호,이름,전화번호 입력하세요.");
			for(int i=1;i<=3;i++) {
				System.out.println("학생번호 입력");
				int num=scan.nextInt();
				System.out.println("이름 입력");
				String name=scan.next();
				System.out.println("전화번호 입력");
				String phone=scan.next();
				
				//public void write(String str) throws IOException
				pw.write(num + "," + name + "," + phone + "\n");
			}

			System.out.println("파일로 저장 완료!!!");
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(pw!=null) pw.close();
			}catch(IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
