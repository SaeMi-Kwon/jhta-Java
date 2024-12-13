package day01;

import java.util.Scanner;

public class Test06 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("국어점수");
		int kor = scan.nextInt();
		System.out.println("영어점수");
		int eng=scan.nextInt();
		
		double ave=(kor+eng)/2.0;
		if(kor>=80 && eng>=80 && ave>=85) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		
		// 한꺼번에 주석처리/해제 -> 블록처리 + / + ctrl 
//		if(kor>=80 && eng>=80) {
//			double ave= (kor + eng) / 2.0;
//			if(ave>=70) {
//				System.out.println("합격");
//			}else {
//				System.out.println("불합격");
//			}
//		}else {
//			System.out.println("불합격");
//		}
	}	
}
