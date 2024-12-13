package day02;

/*
 * [while문]
 * 
 * while(조건식){
 * 	  반복실행한 문장;
 * 	  ...
 * }
 *-> 조건식이 거짓일때까지 반복 수행함
 *
 */

public class Test13_while {
	public static void main(String[] args) {
		
		//1부터 100까지 합 구하기
		int sum=0;
		int i=1;
		
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println("1부터 100까지 합:" + sum);
	}
}
