package quiz;

import java.util.Scanner;
/*
 * 
 	2) 다섯명 학생의 점수를 입력받아 전체 총점과 평균을 구해보세요.
	예)
	1번학생점수:100
	2번학생점수:60
		...
	5번학생점수:100
	--------------
	전체총점:xxx
	전체평균:xxx

 */
public class Test02 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		int sum=0;
		double avg=0;
		
		for(int i=1;i<=5;i++) {
			System.out.print( i +"번째 학생점수:");
			int score=scan.nextInt();
			sum+=score;
		}
		avg = sum/5.0;


		System.out.println("전체 총점:" + sum);
		System.out.println("전체 평균:" + avg);
	}
}
