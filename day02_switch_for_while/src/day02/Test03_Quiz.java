package day02;

import java.util.Scanner;

/*
 * 국어,영어점수를 입력받아 과목의 총점,평균,학점 구하기 - switch 사용
 * 
 * 학점은 평균점수로 구한다.
 * 평균이 90이상이면 학점 A
 * 평균이 80이상이면 학점 B
 * 평균이 70이상이면 학점 C
 * 평균이 60이상이면 학점 D
 * 평균이 60미만이면 학점 F
 * 
 */

public class Test03_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("국어점수 입력:");
		int kor=scan.nextInt();
		System.out.println("영어점수 입력:");
		int eng=scan.nextInt();
		
		double sum = kor+eng;
		double avg = sum/2.0;
		
		int result = ((int)avg/10);

		String hak="";
		
		switch(result) {
			case 10:
			case 9:
				hak="A";
				break;
			case 8:
				hak="B";
				break;
			case 7:
				hak="C";
				break;
			case 6:
				hak="D";
				break;
			default:
				hak="F";		
		}
		System.out.println("총점:" + sum);
		System.out.println("평균:" + avg);
		System.out.println("학점:" + hak);
	}
}
