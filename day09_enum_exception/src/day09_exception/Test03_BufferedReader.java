package day09_exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * [Exception 종류]
 * - 자바에는 두가지 종류의 익셉션이 있다.
 * 
 * 1.CheckedException
 *  - RuntimeException을 상속받지 않은 예외클래스
 *  - 반드시 try~catch로 예외처리를 해야 하며 예외처리를 하지 않으면 컴파일시에 오류가 발생된다.
 * 	예) IOException,SQLException, ...
 * 
 * 2.UncheckedException
 *  - RuntimeException을 상속받은 예외클래스
 *  - try~catch로 예외처리를 하지 않아도 컴파일시에 오류가 발생되지 않으며 프로그래머가 필요시 선택저으로 예외처리를 한다.
 * 	예) ArithmeticException,NumberFormatException, ...
 * 
 */

public class Test03_BufferedReader {
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			System.out.println("한 줄 입력:");
			
			//public String readLine() throws IOException
			String s=br.readLine();
			System.out.println("입력된 한 줄:" + s);
			
		}catch(IOException ie) {
			System.out.println("오류발생==>" + ie.getMessage());
		}
		
		
	}
}
