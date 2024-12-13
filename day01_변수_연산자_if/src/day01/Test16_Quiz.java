package day01;

import java.util.Scanner;

/*
 * 국어,영어점수를 입력받아 과목의 총점,평균,학점 구하기
 * 
 * 학점은 평균점수로 구한다.
 * 평균이 90이상이면 학점 A
 * 평균이 80이상이면 학점 B
 * 평균이 70이상이면 학점 C
 * 평균이 60이상이면 학점 D
 * 평균이 60미만이면 학점 F
 */
public class Test16_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("국어점수:");
		int kor = scan.nextInt();
		System.out.println("영어점수:");
		int eng = scan.nextInt();
		
		double sum = kor+eng;
		double avg= sum/2;
		
		char hak=' ';  //학점 저장할 변수
		if(avg>=90) {
			hak='A';
			//System.out.println("A학점");
		}else if(avg>=80) {    //else if(90>avg>=80) --->에러
			hak='B';
			//System.out.println("B학점");
		}else if(avg>=70) {
			hak='C';
			//System.out.println("C학점");
		}else if(avg>=60) {
			hak='D';
			//System.out.println("D학점");
		}else {
			hak='F';
			//System.out.println("F학점");
		}

		System.out.println("총합:" + sum);
		System.out.println("평균:" + avg);
		System.out.println("학점:" + hak);
		}
}
