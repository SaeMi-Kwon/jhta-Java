package quiz;

import java.util.Scanner;

/*
	4) 임의의 수를 입력받아 아래와 같은 연산결과가 나오도록 프로그램을 작성해 보세요.
	예)
	5 를 입력하면
	1+(1+2)+(1+2+3)+(1+2+3+4)+(1+2+3+4+5)를 연산한 결과가 나온다.
	출력결과: 35
*/

public class Test04 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.print("임의수:");
		int num=scan.nextInt();
		
		int sum=0;
		for(int i=1;i<=num;i++) {
			for(int j=0;j<=i;j++) { 
				sum = sum + j;
			}
		}
		System.out.println("출력결과:" + sum);
	}
}


//선생님 코드
class Hw4{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("임의의 수 입력");
		int n = scan.nextInt();
		int sum = 0;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= i; j++){
				sum+=j;
			}
		}
		System.out.println("출력결과:" + sum);
	}
}
