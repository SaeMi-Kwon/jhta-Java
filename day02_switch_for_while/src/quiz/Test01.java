package quiz;

import java.util.Scanner;

//1) 임의의 정수를 입력받아 1부터 입력된 정수까지의 합을 구해서 출력해 보세요.

public class Test01 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.println("정수 입력:");
		int num=scan.nextInt();
		
		int sum=0;
		for(int i=1;i<=num;i++) {
			sum+=i;
		}
		System.out.println("1부터 입력된 정수의 합:" + sum);
	}
}
