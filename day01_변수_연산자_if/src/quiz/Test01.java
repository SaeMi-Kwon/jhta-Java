package quiz;

import java.util.Scanner;

/*
 *  1. 임의의 정수를 입력받아 절대값을 구해보세요.(삼항연산자 사용)
 *  예)
 *  정수입력 : 10
 *  결과 10의 절대값 :10
 *	---------------------
 *	정수입력 :-10
 *  결과 -10의 절대값 :10
 */
public class Test01 {
	public static void main(String[] argos){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("정수입력:");
		int num=scan.nextInt();
		int result = (num>=0)? num:-num;
		System.out.println("결과" + num + "의 절대값:" + result); 
	}
}
