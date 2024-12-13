package day01;

import java.util.Scanner;

public class Test15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("두 정수를 순서대로 입력하세요");
		int n1 = scan.nextInt();
		int n2 = scan.nextInt();
		if(n1>n2) {
			System.out.println("큰수:" + n1);
		}else if(n1<n2) {
			System.out.println("큰수:" + n2);
		}else {
			System.out.println("두 수는 같습니다.");
		}
	}
}
