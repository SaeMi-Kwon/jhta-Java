package day01;

import java.util.Scanner;
/*
 * 임의의 정수를 입력받아 짝수인지 홀수인지 출력해 보세요.
 * 삼항연산자를 사용해 보세요.
 */
public class Test09_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("숫자를 입력해주세요:");
		int num = scan.nextInt();
		
		String result = (num%2==0)?"짝수":"홀수";
		System.out.println(num + "는 " + result + "입니다.");
	}
}
