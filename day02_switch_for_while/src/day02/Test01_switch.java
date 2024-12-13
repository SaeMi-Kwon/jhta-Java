package day02;

import java.util.Scanner;

/*
 * [switch]
 * - 일치되는 값을 찾아 선택적으로 문장을 수행
 * - 형식
 * switch(비교대상){
 * 	case 값1:실행문장;break;
 * 	case 값2:실행문장;break;
 * 	...
 * 	default:일치되는 값이 없을때 실행될 문장;
 * }
 * 	case 절에는 정수형상수/단일문자/문자열만 올수 있다(실수X,조건절X)
 * 
 */

public class Test01_switch {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("상품코드를 입력하세요");
		//블록지정 + ctrl + /
//		int n=scan.nextInt();
//		switch(n) {
//		case 1:
//			System.out.println("상품:TV");
//			break;
//		case 2:
//			System.out.println("상품:컴퓨터");
//			break;
//		case 3:
//			System.out.println("상품:스마트폰");
//			break;
//		default:
//			System.out.println("상품없음");
//		}
		
		
		String code=scan.next();
		switch(code) {
			case "a":   //break가 없으면 break를 만날때까지 코드를 수행함
			case "A":
				System.out.println("100만원 상품권 당첨!");
				break;
			case "b":
			case "B":
				System.out.println("50만원 상품권 당첨!");
				break;
			case "c":
			case "C":
				System.out.println("10만원 상품권 당첨!");
				break;
			default:
				System.out.println("상품권 없음!");
		}
		
		//위의 코드를 if문으로 바꿔서 작성해 보세요.	
		String code2=scan.next();
		if(code2.equals("a")||code2.equals("A")) {
			System.out.println("100만원 상품권 당첨!");
		}else if(code2.equals("b")||code2.equals("B")) {
			System.out.println("50만원 상품권 당첨!");
		}else if(code2.equals("c")||code2.equals("C")) {
			System.out.println("10만원 상품권 당첨!");
		}else {
			System.out.println("상품권 없음!");
		}
		
	}
}
