package day11_io;

import java.io.*;

public class Test01_PrintWriter {
	public static void main(String[] args) {
	
		try {
			//public PrintWriter(OutputStream out) -->생성자
			//OutputStream out=System.out;  //화면 출력
			OutputStream out=new FileOutputStream("hello.txt"); //파일 출력
			
			//OutputStream out=new FileWriter("hello.txt");  
			//에러-> 부모 자식간의 관계가 아니기때문에 OutputStream로 참조 못한다 
			
			//PrintWriter pw=new PrintWriter(out);
			
			//public PrintWriter(OutputStream out,boolean autoFlush) -->생성자
			PrintWriter pw=new PrintWriter(out,true);  //true -> 자동으로 flush하기
			pw.println("안녕하세요");
			pw.println("반갑습니다");
			//pw.flush();
			
			pw.close();
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
		
		
	}
}
