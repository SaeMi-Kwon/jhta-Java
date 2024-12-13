package day02;

/*
 * 1. for문 사용해서 1부터 100까지 수중 짝수합과 홀수합을 각각 구해서 출력해 보세요
 * 
 * 2. 1부터 100까지 수중 3의 배수를 출력하고 3의 배수합도 구해서 출력해 보세요.
 */

public class Test05_Quiz {
	public static void main(String[] args) {
		//1.문제
		int odd=0;
		int even=0;
		for(int i=1;i<=100;i++) {
			if(i%2==1) {
				odd+=i;
			}else {
				even+=i;
			}
		}
		
		System.out.println("1부터 100까지 홀수의 합:" + odd);
		System.out.println("1부터 100까지 짝수의 합:" + even);
		
		//2.문제
		int sum=0;
		for(int i=1; i<=100;i++) {  //;i+=3)
			if(i%3==0) {
				System.out.print(i + " ");
				sum+=i;
			}
		}
		System.out.println();
		System.out.println("3의 배수의 합:" + sum);
	}
}
