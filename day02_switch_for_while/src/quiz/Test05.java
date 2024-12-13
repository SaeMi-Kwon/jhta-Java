package quiz;

import java.util.Scanner;

/*
5) 임의의 정수를 입력받아 소수인지 아닌지 출력해 보세요.
소수:1과 자신으로만 나누어지는 수(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31....)

(힌트 : for문으로 입력된 정수가 100이면 2부터 99까지 나눠본다)
예)
정수입력:5
5는 소수입니다.

*/

public class Test05 {
	public static void main(String[] args) {
		Scanner scan =new Scanner(System.in);
		
		System.out.print("정수입력:");
		int num=scan.nextInt();
		for (int i = 2; i < num; i++) {
			if (num% i == 0) {
				System.out.print(num + "은 소수가 아닙니다. ");
				return;
			}
		}
		System.out.println(num + "은 소수입니다. ");


	}

}


//선생님 코드
class HW5 {
	public static void main(String[] args) 	{
		Scanner scan = new Scanner(System.in);
		System.out.print("임의의 정수를 입력하세요 : ");
		int n = scan.nextInt();
		boolean isPrime = true;
		for (int i = 2 ;i<n ; i++){
			if (n%i==0)	{
				isPrime = false;
				break;
			}
		}
		if (isPrime){
			System.out.println(n +"은 소수입니다.");
		}
		else System.out.println(n +"은 소수가 아닙니다.");
	}
}
