package quiz;

import java.util.Scanner;

//4.학생점수를 5개 입력받아 등수를 구해 보세요.

public class Test04 {
	public static void main(String[] args) {
   		Scanner scan = new Scanner(System.in);
   		int[] score=new int[5];  //5명의 점수를 저장할 배열
   		int[] rank=new int[5];	//각 학생의 등수를 저장할 배열

   		System.out.println("학생 점수 입력");
   		for(int i=0;i<5;i++){
       		score[i]=scan.nextInt();
       		rank[i]=1;  //초기 등수는 1등으로 설정
   			}

   		//등수 계산
        for(int i=0; i<5;i++){
            for(int j=0;j<5;j++){
                if (score[i]<score[j]) {  //다른 학생의 점수가 더 높으면
                    rank[i]++;  //자기 등수를 증가
                }
            }
        }

   		for(int i=0; i<5;i++) {
       		System.out.println("학생 " + (i+1) + "의 점수: " + score[i] + ", 등수: " + rank[i]);
   		}

	}
}


//선생님 코드	
class Hw4{	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int[] score = new int[5];
		int[] rank = {1,1,1,1,1};
		for(int i = 0; i < score.length; i++){
			System.out.print(i+1 + "번학생 점수 입력: ");
			score[i] = scan.nextInt();
		}
		
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score.length; j++){
				if(score[i] < score[j]){
					rank[i]++;
				}
			}
		}
		System.out.println("===========================");
		for(int i = 0; i < score.length; i++){
			System.out.println(score[i] +"점 : " + rank[i] + "등");
		}
	}
}