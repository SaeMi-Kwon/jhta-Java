package day01;

import java.util.Scanner;

public class Test03 {
	// main ctrl + space
		public static void main(String[] args) {
			//키보드로부터 데이터를 입력받는 기능을 갖는 객체 생성하기
			Scanner scan = new Scanner(System.in);
			
			System.out.println("첫번째 정수입력:");
			//키보드로부터 정수 입력받기
			int n1=scan.nextInt();
			
			System.out.println("두번째 정수입력:");
			int n2=scan.nextInt();
			
			int n3=n1+n2;
			System.out.println("두수 합:" + n3);
			System.out.println(n1 + "+" + n2 + "=" + n3);
			
			System.out.println("문자열 입력하세요:");
			String str = scan.next(); //문자열 입력받기
			System.out.println("입력된 문자열 =>" + str);

			System.out.println("실수를 입력하세요:");
			double d = scan.nextDouble(); //실수 입력받기
			System.out.println("입력된 값:" + d);
		}

}
