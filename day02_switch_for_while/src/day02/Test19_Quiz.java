package day02;

import java.util.Scanner;

/*
 * 아이디와 비밀번호를 입력받아 일치하는지 검사해 보세요.
 * 입력할수 있는 기회를 3번만 준다.
 * ---> while문 사용해 보세요.
 */

public class Test19_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String id="admin";
		String pw="1234";
		
		int count=1;
		
		while(count<=3) {
			System.out.println("아이디를 입력하세요");
			String inputId=scan.next();
			System.out.println("비밀번호를 입력하세요");
			String inputPw=scan.next();
			
			if(id.equals(inputId) && pw.equals(inputPw)) {
				System.out.println( id +"님 환영합니다.");
				break;  
			}else {
				System.out.println("일치하지않습니다.(입력 기회 3번중 " + count + "번째 입니다.)");
			}
			
			count++;
		}
		
//		int cnt=0;  //틀린횟수
//		while(true) {
//			System.out.println("아이디를 입력하세요");
//			String inputId=scan.next();
//			System.out.println("비밀번호를 입력하세요");
//			String inputPw=scan.next();
//			if(id.equals(inputId) && pw.equals(inputPw)) {
//				System.out.println( id +"님 환영합니다.");
//				break;
//			}
//			System.out.println("아이디와 비밀번호가 맞지 않아요!");
//			cnt++;
//			if(cnt>=3) {
//				System.out.println("입력횟수 초과!");
//				System.exit(0);   //프로그램 종료
//			}
//		}
//		System.out.println("회원님........");
		
		
	}
}
