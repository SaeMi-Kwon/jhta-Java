package day03;

import java.util.Scanner;

public class Test02 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] a = new int[5];
		System.out.println("배열크기:" + a.length);
		
		int sum=0;  //총점
		
		for(int i=0;i<a.length;i++) {
			System.out.println((i+1) +"번째 학생점수 입력:");
			a[i]=scan.nextInt();
			sum += a[i];  //총점구하기
		}
		
		System.out.println("<<입력된 학생 점수>>");
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
		System.out.println("전체학생 총점:" + sum);
	}
}
