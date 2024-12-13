package quiz;

import java.util.Scanner;

//5.학생이름 국어 영어점수를 입력받아 총점 평균을 구해서 출력해 보세요.(학생수는 5명)

public class Test05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] std=new String[5];
   		int[][] score=new int[5][4];

   		for (int i=0;i<5;i++) {
   			System.out.print((i + 1) + "번째 학생이름 입력: ");
   			std[i] = scan.next();
   			for(int j=0;j<2;j++){
   				System.out.print(std[i]+"의 국어,영어점수 입력: ");
   				score[i][j] = scan.nextInt();
   				score[i][2] +=score[i][j];
   			}
   			score[i][3]= score[i][2]/2;
   		}

   		for (int i=0;i<5;i++) {
   			System.out.println("국어 영어 합계 평균");
   			for(int j=0;j<4;j++){				
   				System.out.print(score[i][j] + " ");
   			}
   			System.out.println();
   		}

   		for(int i=0;i<5;i++) {
   			System.out.println(std[i] +"의 총점:" + score[i][2] + ", 평균:" + score[i][3]);
   		}
   		
	 }
}
