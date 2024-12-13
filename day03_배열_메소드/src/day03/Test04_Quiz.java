package day03;

import java.util.Scanner;

/*
 * 학생답안 10개를 입력받아 학생의 점수 출력하기
 * 정답은 아래와 같다.
 * int[] dep={1,2,3,4,2,3,4,1,1,4};
 * 
 * 예)
 * 학생답입력
 * 1,1,2,4,2,3,4,1,1,4
 * 학생점수:80점
 * 
 */

public class Test04_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] dep = {1,2,3,4,2,3,4,1,1,4};
		int[] result = new int[10];
		char[] ox = new char[10];   // 정답 표시 문자
		
		int score=0;  //학생점수
		
		System.out.println("학생답입력:");
		for(int i=0;i<result.length;i++) {
			result[i]=scan.nextInt();
	
			if(result[i]==dep[i]) {
				score+=10;
				ox[i]='O';
			}else {
				ox[i]='X';
			}
		}
		
		System.out.println("<답안>");
		for(int i=0;i<dep.length;i++) {	
			System.out.print(dep[i] + " ");
		}
		System.out.println();
		
		System.out.println("<학생 답안>");
		for(int i=0;i<result.length;i++) {	
			System.out.print(result[i] + " ");
		}
		System.out.println();
		
		for(int i=0;i<ox.length;i++) {	
			System.out.print(ox[i] + " ");
		}
		System.out.println();
		
		
		System.out.println("학생점수:" + score);
		
	}
}
