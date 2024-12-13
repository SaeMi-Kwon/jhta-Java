package day01;

import java.util.Scanner;

/*
 * [제어문]
 * - 조건문과 반복제어문이 있다.
 * 1.조건제어문
 * 	1)if문
 * 
 * 	  형식1)
 * 	  if(조건식){
 * 		조건이 참일때 수행할 문장;
 * 		..
 * 	  }
 * 	  형식2)
 * 	  if(조건식){
 * 		조건이 참일때 수행할 문장;
 * 		..
 * 	  }else{
 * 		조건이 거짓일때 수행할 문장;
 * 	  }
 * 
 * 	  형식3)
 *    if(조건식1){
 * 		조건식1이 참일때 수행할 문장;
 * 		..
 * 	  }else if(조건식2){
 * 		조건식2이 참일때 수행할 문장;
 *    }
 *    ..
 *    else{
 * 		조건이 모두 거짓일때 수행할 문장
 *    }
 * 
 */
public class Test14_if {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("임의의 정수 입력");
		int n = scan.nextInt();
		String result="짝수";
		if(n%2!=0) {
			result="홀수";
		}
		System.out.println(n + "은 " + result + "입니다.");
		
		//두 정수를 입력받아(두 수중 다른값) 두 수중 큰값을 구해서 출력해 보세요.(if문 사용하기)
		Scanner input = new Scanner(System.in);
		
		System.out.println("정수1 입력:");
		int n1 = input.nextInt();
		System.out.println("정수2 입력:");
		int n2 = input.nextInt();
		
		int max = n1;
		if(n1<n2) {
			max = n2; 
		}
		System.out.println(n1 + "과 " + n2 + "중에서 큰값은 " + max + "입니다." );

	}
}
