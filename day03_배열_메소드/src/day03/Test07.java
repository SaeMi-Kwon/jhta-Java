package day03;

import java.util.Scanner;

//2차원배열에 정수 입력받아 저장하기

public class Test07 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
//		int[][] a = new int[3][4];
//		
//		//데이터 입력
//		for(int i=0;i<3;i++) {
//			for(int j=0;j<4;j++) {
//				a[i][j] = scan.nextInt();
//			}
//		}
//		
//		//데이터 출력
//		System.out.println("배열에 저장된 데이터");
//		for(int i=0;i<a.length;i++) {
//			for(int j=0;j<a[i].length;j++) {
//				System.out.print(a[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
		//데이터 입력
		int[][] a= new int[3][4];
		for(int i=0;i<3;i++) {
			System.out.println("학생번호입력");
			a[i][0]=scan.nextInt();
			System.out.println("국어 영어 수학점수를 순서대로 입력");
			for(int j=1;j<4;j++) {
				a[i][j] = scan.nextInt();
			}
		}
		
		//데이터 출력
		System.out.println("번호 국어 영어 수학");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
