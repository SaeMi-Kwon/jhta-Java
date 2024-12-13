package day01;

import java.util.Scanner;

public class Test04_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름을 입력하세요:");
		String name = scan.next();
		System.out.println("이름: " + name);
		
		System.out.println("국어점수를 입력하세요:");
		int kor = scan.nextInt();
		System.out.println("국어점수:" + kor);
		
		System.out.println("영어점수를 입력하세요:");
		int eng = scan.nextInt();
		System.out.println("영어점수:" + eng);
		
		double sum = kor+eng;
		System.out.println("총점:" + sum);
		
		double avg = sum/2;
		System.out.println("평균:" + avg);
		
	}
}
