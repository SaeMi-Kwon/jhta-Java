package day11_io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

/*
 *  1.BufferedReader를 사용해서 키보드로 학생이름,국어,영어점수를 입력받아
 *  	PrintWriter를 사용해서 파일로 저장
 *  
 *  	입력데이터는 3명
 *  	- 저장형식은 아래와 같은 형태로 저장
 *  
 *  ## Student.txt
 *  홍길동,100,50
 *  김철수,50,50
 *  이영희,100,60
 *  
 */

public class Test05_Quiz {
	public static void main(String[] args) {
		
		try {
			//입력 스트림
			//public BufferedReader(Reader in)
			InputStream is = System.in; 
			Reader isr = new InputStreamReader(is);
			BufferedReader br= new BufferedReader(isr);
			//BufferedReader br= new BufferedReader(new InputStreamReader(System.in)); //한줄로 변경
			
			//출력 스트림
			//public PrintWriter(OutputStream out, boolean autoFlush)
			OutputStream out=new FileOutputStream("Student.txt");
			PrintWriter pw = new PrintWriter(out,true);
			
			/* 방식2,3
			PrintWriter pw =
					new PrintWriter(new FileOutputStream("Student.txt"));
			PrintWriter pw = 
					new PrintWriter(new FileWriter("Student.txt",true)); //true:파일끝에 추가
			*/
			
			//키보드로 입력
			for(int i=0;i<3;i++) {
				System.out.println("이름입력");
				String name=br.readLine();
				System.out.println("국어점수입력");
				String kor=br.readLine();
				System.out.println("영어점수입력");
				String eng=br.readLine();
				
				//파일로 출력
				pw.println(name + "," + kor + "," + eng);
			}
			
//			System.out.println("학생이름,국어,영어점수 입력하세요(q: 종료)");
//			while(true) {
//				String s=br.readLine();
//				if(s.equals("q")) break;
//				pw.println(s);
//			}

			pw.close();
			br.close();
			
			System.out.println("저장 완료!");
		
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		
	}
}
