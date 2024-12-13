package day02;

import java.util.Scanner;

/*
 * 아이디와 비밀번호를 입력받아 맞으면 회원님 환영합니다. 라고 출력한다.
 * 아이디와 비밀번호는 맞을때까지 입력한다.
 */

public class Test11_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String id="userId";
		String pw="1234";
		
		for(;;) {
			System.out.println("아이디를 입력하세요:");
			String inputId=scan.next();
			System.out.println("비밀번호를 입력하세요:");
			String inputPw=scan.next();
			
			if(id.equals(inputId) && pw.equals(inputPw)) {
				System.out.println( inputId + "회원님 환영합니다.");
				break;
			}else {
				System.out.println("아이디 또는 비밀번호가 맞지 않습니다. 다시 입력해주세요.");
			}
		}
		
		
	}
}
