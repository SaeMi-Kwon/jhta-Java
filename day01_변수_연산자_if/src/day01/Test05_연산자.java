package day01;

import java.util.Scanner;

/*
 * <자바의 연산자>
 * 1. 산술연산자
 *  +,-,*,/,%(나머지연산자)
 *  
 *  2.관계연산자
 *  >,>=,==(같다),<,<=,!=(같지않다)
 *  
 *  3.논리연산자
 *  ! (not): 어떠한 값이 참이면 거짓, 거짓이면 참인 결과값을 갖음
 *  && (and): 대응되는 두개의 값이 모두 참이면 결과가 참
 *  || (or): 대응되는 두개의 값이 모두 거짓이면 결과가 거짓
 *  
 *  <if문>
 *  if(조건식){
 *  조건이 참이면 수행할 문장;
 *  }else{
 *  조건이 거짓이면 수행할 문장;
 *  }
 */
public class Test05_연산자 {
	public static void main(String[] args) {
		int a=10%3;
		System.out.println("10을 3으로 나눈 나머지값: " + a);
	
		Scanner scan = new Scanner(System.in);
		System.out.println("임의의 정수 입력");
		int n = scan.nextInt();
		if(n%2==0) {
			System.out.println(n + "은 짝수");
		}else {
			System.out.println(n + "은 홀수");
		}
		
	}
}
