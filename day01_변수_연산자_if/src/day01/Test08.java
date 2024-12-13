package day01;

import java.util.Scanner;

/*
 * <삼항연산자>
 * 
 * (조건식)? 결과값1:결과값2
 * 
 * -> 조건식이 참이면 결과값1, 조건이 거짓이면 결과값2가 수행됨
*/
public class Test08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		System.out.println("첫번째수");
//		int n1 = scan.nextInt();
//		
//		System.out.println("두번째수");
//		int n2 = scan.nextInt();
//		
//		int n3 = (n1>n2)?n1:n2;
//		System.out.println(n1 + "과" + n2 + " 중에서 큰 수는 " + n3 + " 입니다");
		
		
		System.out.println("첫번째수");
		int n1 = scan.nextInt();
		
		System.out.println("두번째수");
		int n2 = scan.nextInt();
		
		System.out.println("세번째수");
		int n3 = scan.nextInt();
		
		int max1 = (n1>n2)?n1:n2;
		int max2 = (max1>n3)? max1:n3;
		
		System.out.println("세 수 중에서 큰 값은 " + max2 + " 입니다");
	}
}
