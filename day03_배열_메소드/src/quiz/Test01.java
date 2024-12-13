package quiz;

import java.util.Scanner;

//1. 학생5명의 이름과 점수를 입력받아 배열에 저장하고
//가장 높은 점수와 학생이름,가장 낮은 점수와 학생이름을 구해서 출력해 보세요.

public class Test01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

   		String[] std=new String[5];
   		int[] score=new int[5];

 		for (int i=0;i<5;i++) {
       		System.out.print((i + 1) + "번째 학생이름 입력: ");
       		std[i] = scan.next();
       		System.out.print(std[i]+"의 점수입력: ");
       		score[i] = scan.nextInt();
   		}

   		int max=score[0];
   		int min=score[0];
   		String high=std[0];
   		String low=std[0];

   		for(int i=0;i<5;i++){
       		if(score[i]>=max) {
          			max=score[i];
           			high=std[i];
       		}
       		if(score[i]<=min) {
           			min = score[i];
           			low = std[i];
       			}
   		}
   		System.out.println("가장 높은 점수:" + max + "학생이름:" +high);
   		System.out.println("가장 낮은 점수:" + min + "학생이름:" +low);
	}

}


//선생님 코드	
class HW1{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[5];
		int i = 0;
		int total = 0;
		double ave = 0;
		String[] names=new String[5];

		while (i<5)	{
			System.out.println((i+1)+"번째 학생이름을 입력하세요");
			names[i]=sc.next();
			System.out.println("점수를 입력하세요");
			scores[i]=sc.nextInt();
			total+=scores[i];
			i++;
		}
		ave = total/5.0;
		i=1;
		int max=scores[0];
		int min=scores[0];
		String maxName=names[0];
		String minName=names[0];
		while(i<5){			
			if (scores[i]>max){
				max=scores[i];
				maxName=names[i];
			}
			if (scores[i]<min)	{
				min=scores[i];
				minName=names[i];
			}
			i++;			
		}
		System.out.println("전체총점 : " + total);
		System.out.println("전체평균 : " + ave);
		System.out.println("가장높은점수 : "+ max +",학생이름:"+ maxName);
		System.out.println("가장낮은점수 : " + min+",학생이름:" + minName);
	}
}
