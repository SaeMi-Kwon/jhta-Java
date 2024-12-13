package day03;

import java.util.Scanner;

/*
 * 4명의 학생의 번호,국어,영어,수학점수를 입력받아 총점,(int형)평균을 구해서 배열에 저장하고
 * 출력해 보세요(2차원 배열 사용)
 */

public class Test10_Quiz {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[][] a = new int[4][6];
		String[] msg= {"번호","국어점수","영어점수","수학점수"};  
		
//		//점수입력
//		for(int i=0;i<a.length;i++) {
//			System.out.println("번호 국어 영어 수학순으로 입력하세요.");
//			for(int j=0;j<4;j++) {
//				a[i][j]=scan.nextInt();
//			}
//		}
//		
//		//총점,평균 구하기
//		for(int i=0;i<4;i++) {			
//			for(int j=1;j<4;j++) {
//				a[i][4] = a[i][4] + a[i][j];   //총점
//			}
//			a[i][5] = (a[i][4])/3;		//평균
//		}
		
		
		//점수입력 및 총점,평균 구하기
		for(int i=0;i<a.length;i++) {
			//System.out.println("번호 국어 영어 수학순으로 입력하세요.");
			for(int j=0;j<4;j++) {
				System.out.println(msg[j]+" 입력");
				a[i][j]=scan.nextInt();
				if(j!=0) {   //번호는 제외  
					a[i][4] += a[i][j];  //총점
				}
			}
			a[i][5] = (a[i][4])/3;	//평균
		}
		
		
		//출력
		System.out.println("번호 국어 영어 수학 총점 평균");
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
