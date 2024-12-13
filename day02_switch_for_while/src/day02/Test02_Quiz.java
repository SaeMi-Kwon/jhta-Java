package day02;

import java.util.Scanner;

/*
 * 두 정수와 사칙연산자(+,-,*,/) 중 하나를 입력받아 해당 연상이 수행되도록 코드를 작성해 보세요 - switch 사용
 * 
 * 예)
 * 첫번째 정수입력
 * 10
 * 두번째 정수입력
 * 20
 * 연산자 입력(+,-,*,/)
 * -
 * 결과 10-20=-10
 */

public class Test02_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("첫번째 정수입력");
		int num1=scan.nextInt();
		System.out.println("두번째 정수입력");
		int num2=scan.nextInt();
		
		System.out.println("연산자 입력(+,-,*,/)");
		String oper=scan.next();
		String result = num1 + oper + num2;
		
		switch(oper) {
			case "+":
				System.out.println(result + "=" + (num1+num2));
				break;
			case "-":
				System.out.println(result + "=" + (num1-num2));
				break;
			case "*":
				System.out.println(result + "=" + (num1*num2));
				break;
			case "/":
				System.out.println(result + "=" + ((double)num1/num2));
				break;
			default:
				System.out.println("연산자를 잘못입력했습니다.");
		}
		
	}
}
