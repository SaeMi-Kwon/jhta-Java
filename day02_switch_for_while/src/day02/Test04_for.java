package day02;

/*
 * [for문]
 * -조건식이 거짓일떄까지 반복적으로 문장을 수행함
 * -형식
 * 
 * for(초기식;조건식;증감식){
 *    반복실행할 문장;
 * 	  ...
 * }
 * 
 */

public class Test04_for {
	public static void main(String[] args) {
		
		//for문을 사용해서 1부터 100까지 출력하기
		for(int i=1;i<=100;i++) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//1부터 100까지 수중 홀수만 출력하기
		for(int i=1;i<=100;i+=2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//1부터 100까지 수중 짝수만 출력하기
		for(int i=2;i<=100;i+=2) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		//1부터 100까지의 합 구하기
		int sum=0;	//지역변수는 초기값을 무조건 입력해줘야한다.
		for(int i=1;i<=100;i++) {
			sum+=i;   //sum = sum+i
		}
		System.out.println("1부터 100까지의 합:" + sum);
		
	}
}
