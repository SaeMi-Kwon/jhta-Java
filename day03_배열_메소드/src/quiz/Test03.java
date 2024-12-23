package quiz;

import java.util.Scanner;
/*
	3. 점수를 입력받아 분포도를 구해보세요.
	예)
	10개의 점수를 입력하세요
	100
	90
	99
	70
	8
	..

	[결과]
	1점대:1
	10점대:0
	..
	70점대:1
	80점대:0
	90점대:2
	100점대:1
*/

public class Test03 {
	public static void main(String[] args) {
   		Scanner scan = new Scanner(System.in);
   		int[][] scoreArray = new int[11][2];  //0~100까지 총 11개 범위 (0~9점대, 10~19점대, ..., 100점대까지)

        System.out.println("10개의 점수를 입력하세요");

        //점수 입력 받기
        for(int i=0;i<10;i++){
            int score=scan.nextInt();  //점수 입력받기
            int index=score/10;   //10점 단위로 점수대 계산
            if (index==10) {     //100점은 100점대에 포함되므로 예외 처리
                index=9;
            }
            scoreArray[index][1]++;  //해당 점수대에 카운트 추가
        }

        //점수대별 결과 출력
        for(int i=0;i<10;i++) {
            System.out.println(i*10 + "점대: " + scoreArray[i][1]);
        }
        //100점대 별도 출력
        System.out.println("100점대: " + scoreArray[9][1]);
    }
}
	
	
	
	
//선생님 코드	
class Hw3{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("10개의 점수 입력");
		int[] a = new int[10];
		int[] b = new int[10];
		for(int i = 0; i < a.length; i++){
			System.out.print(i+1 +"번째 입력: ");
			a[i] = scan.nextInt();
		}

		for(int i = 0; i < a.length; i++){
			int index = a[i]/10;
			b[index]++;
		}
		System.out.println("======================");
		System.out.println("1점대 : " + b[0]);
		for(int i = 1; i < b.length; i++){
			System.out.println(i*10 +"점대 : " + b[i]);
		}
	}

}
