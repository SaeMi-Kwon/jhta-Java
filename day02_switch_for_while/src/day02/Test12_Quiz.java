package day02;

import java.util.Random;
import java.util.Scanner;

/*
 * 아래와 같은 덧셈 계산 프로그램을 작성해 보세요
 * 
 * 예)
 * 1+2=3
 * 3+4=_
 * ...
 * 
 * -> 덧셈연산할 두 수는 랜덤한 난수이고 사용자가 답을 입력해 맞춘다.
 * 문제는 10문제가 나오고 점수(한 문제당 10점)와 맞은 갯수를 출력하세요.
 * 
 */

public class Test12_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();
		
		int cnt=0;
		int tot=0;
		
		for(int i=1;i<=10;i++) {
			int n1=rnd.nextInt(10)+1; 
			int n2=rnd.nextInt(10)+1;
			
			System.out.print(n1+ "+" + n2 + "=");
			int inputNum=scan.nextInt();
			
			int result = n1+n2;
		
			if(result==inputNum) {
				tot+=10;
				cnt++;
				}
			}
		System.out.println("맞은 갯수:" + cnt);
		System.out.println("점수:" + tot);
		
	}
}
