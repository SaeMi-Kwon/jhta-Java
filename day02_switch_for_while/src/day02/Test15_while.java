package day02;

import java.util.Scanner;

/*
 * [다중while문]
 * 
 * -형식
 * while(조건식){
 * 	   
 *     while(조건식){
 *     
 *     반복실행할 문장;
 *     
 *     }
 * }
 * 
 */

public class Test15_while {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("단 입력하세요 (0을 입력하면 종료):");
			int dan=scan.nextInt();
			
			if(dan==0) {
				break;
			}
			if(!(dan>=2 && dan<=9)) {
				System.out.println("2에서 9사이의 수를 입력하세요.");
				continue;   //조건절로 분기
			}
			
			System.out.println("<<" + dan + ">>");
		
			int i=1;
			while(i<=9) {
				System.out.println(dan + "*" + i + "=" + (dan*i));
				i++;
			}
		}
		
	}
}
