package day09_exception;

import java.util.Scanner;

import test.MyMath;

public class Test05 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("첫번째수");
		int n1=scan.nextInt();
		System.out.println("두번째수");
		int n2=scan.nextInt();
		
		try {
			int n3=MyMath.div2(n1,n2);
			System.out.println(n1+ "/" + n2 + "=" + n3);
			
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌수 없어요");
		}
	}
	
	//방법2) 예외가 발생될 수 있는 문장들을 직접 try~catch로 처리하지 않고 throws로 떠넘기기
//	public static int div2(int a,int b) throws ArithmeticException {
//		int c=a/b;
//		return c;
//	}
	
}
