package day02;

import java.util.Scanner;

/*
 * 1.단을 입력받아 구구단을 출력해 보세요
 * 단입력 : 4
 * [4단]
 * 4*1=1
 * 4*2=8
 * ..
 * 4*9=36
 * 
 * 2. for문을 사용해서 알파벳을 출력해 보세요(ABCD...Z)
 * 
 * 3. 1부터 100까지 수를 모두 출력하시오. 단 한줄에 10개씩 출력하세요
 * 
 */

public class Test06_Quiz {
	public static void main(String[] args) {
		//1.문제
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단입력:");
		int num = scan.nextInt();
		
		System.out.println("[" + num +"]");
		for(int i=1;i<=9;i++) {
			System.out.println(num + "*" + i + "=" + (num*i));
		}
		
		//2.문제
		for(char i='A';i<='Z';i+=1) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		//3.문제
		for(int i=1;i<=100;i++) {
			System.out.print(i + " ");
			if(i%10==0) {
				System.out.println();
			}
		}
		
	}
}
