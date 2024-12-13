package day03;
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
 * ---> 학생수가 1명인 경우
 * int[] score = new int[10];
 * 
 * ---> 학생수가 5명인 경우
 * int[][] score = new int[5][11]
 * 
 */

import java.util.Scanner;

public class Test12_Quiz {
	public static void main(String[] args) {
		int[] dep={1,2,3,4,2,3,4,1,1,4};
		int[][] score = new int[5][11];
	
		Scanner scan = new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			System.out.println((i+1) + "번째 학생의 답 입력");
			for(int j=0;j<10;j++) {
				score[i][j]=scan.nextInt();
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<10;j++) {
				if(score[i][j]==dep[j]) {
					score[i][10]+=10;
				}
			}
		}
		
		System.out.println("<답안>");
		for(int i=0;i<dep.length;i++) {
			System.out.print(dep[i] + " ");
		}
		System.out.println();
		
		System.out.println("<학생들 답안>");
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++) {
				System.out.print(score[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}
