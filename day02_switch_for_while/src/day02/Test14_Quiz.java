package day02;

import java.util.Scanner;

/*
 * 문1.
 * 1부터 100까지 수중 3의 배수를 출력하고 3의 배수합 출력해 보세요.
 * 
 * 문2.
 * 단 입력받아 해당하는 구구단 출력해 보세요.
 * 
 * ->while 문 사용
 * 
 */

public class Test14_Quiz {
	public static void main(String[] args) {
		//문제1
		int i=1;
		int sum=0;
		
		while(i<=100) {
			if(i%3==0) {
				System.out.print(i + " ");
				sum+=i;				
			}
			i++;
		}
		System.out.println();
		System.out.println("3의 배수합:" + sum);
		
		
		//문제2
		Scanner scan = new Scanner(System.in);
		
		int j=1;
		System.out.println("단 입력: ");
		int num=scan.nextInt();
		
		while(j<=9) {
			System.out.println(num + "*" + j + "=" + (num*j));
			j++;
		}
		
		
	}
}
