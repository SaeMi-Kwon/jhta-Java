package day02;

import java.util.Scanner;

/*
 * [do~while문]
 * -형식
 * do{
 *    반복실행할 문장;
 *    ...
 * }while(조건식);
 * 
 * -조건식이 거짓일때까지 반복 수행
 * -while문이 조건절을 먼저 판단하고 실행되지만 do~while 문은 실행하고
 *  조건절을 판단한다.
 *  
 */

public class Test17_dowhile {
	public static void main(String[] args) {
		int sum=0;
		int i=1;
		
		do {
			sum += i;
			i++;
		}while(i<=100); 
		
		System.out.println("1부터100까지 합:" + sum);
		
			
		Scanner scan=new Scanner(System.in);
		
//		int dan=0;
//		while(true) {
//			System.out.println("단입력");
//			dan=scan.nextInt();
//			if(dan>=2 && dan<=9) {
//				break;
//			}
//		}		
		
		int dan=0;
		do {
			System.out.println("단입력(2에서 9사이의 수 입력)");
			dan=scan.nextInt();
		}while(!(dan>=2 && dan<=9));
		
		
		for(i=1;i<=9;i++) {
			System.out.println(dan + "*" + i + "=" + (dan*i));
		}
			
	}
}
