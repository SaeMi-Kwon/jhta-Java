package day03;

import java.util.Scanner;

/*
 * 10명 학생점수를 입력받아 배열에 저장하고 전체 총점/평균 구하세요.
 * 1.점수가 80점 이상인 학생수를 구해서 출력하세요.
 * 2.가장 높은 점수를 구해서 출력해 보세요.
 */

public class Test03_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int[] score = new int[10];
		
		int sum=0;  //합계
		int count=0; //학생수
		
		for(int i=0;i<score.length;i++) {
			System.out.println((i+1)+"학생점수입력:");
			score[i] = scan.nextInt();
			sum += score[i];
			
		}
		
		System.out.println("<입력된 점수>");
		for(int i=0;i<score.length;i++) {	
			System.out.println(score[i]);
		}
		
	
	
		//1.
		System.out.println("<80점이상인 학생수>");
		for(int i=0;i<score.length;i++) {
			if(score[i]>=80) {
				count++;   //80점 이상이면 카운트
			}
		}
		
		
		
		//2.
		int max = score[0]; //가장 큰값을 score[0]로 초기화
		int min = score[0]; //가장 작은값을 score[0]로 초기화
		for(int i=0;i<score.length;i++) {
			if(score[i]>=max) {  //score[i]값이 크면 그값을 max에 덮어씌운다.
				max = score[i]; 
			}
			if(score[i]<min) {
				min=score[i];
			}
		}
		System.out.println("총점:" + sum);
		System.out.println("평균:" + (double)sum/10);
		System.out.println(count);
		System.out.println("가장 높은 점수:" + max);
		System.out.println("가장 낮은 점수:" + min);
	}
}
