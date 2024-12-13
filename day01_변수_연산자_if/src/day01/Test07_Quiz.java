package day01;

import java.util.Scanner;

public class Test07_Quiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("이름:");
		String name = scan.next();
		
		System.out.println("국어점수:");
		int kor = scan.nextInt();
		

		System.out.println("영어점수:");
		int eng = scan.nextInt();
	
		double sum = kor+eng;
		double avg = sum/2.0;
		
		System.out.println("이름:" + name);
		System.out.println("국어점수:" + kor);
		System.out.println("영어점수:" + eng);
		System.out.println("합계:" + sum);
		System.out.println("평균:" + avg);
	
		
		if(kor>=60 && eng>=60 && avg>=80) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
	}
}
