package day01;

import java.util.Scanner;

public class Test17_equals {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String id="admin";
		String password="1234";
		
		System.out.println("아이디 입력:");
		String inputId=scan.next();
		
		System.out.println("비밀번호 입력");
		String inputPwd=scan.next();
		
		//문자열을 비교할때는 equals메소드를 사용한다.
		//"문자열".equals("비교문자열")
		if(id.equals(inputId) && password.equals(inputPwd)) {
			System.out.println("관리자님으로 로그인 되었습니다.");
		}else {
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다.");
		}
	}
}
