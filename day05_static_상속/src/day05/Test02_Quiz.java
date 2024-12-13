package day05;
/*
 *  두 정수를 매개변수로 전달받아 사칙연산하는 static메소드를 4개 만들고 사용해 보세요.
 */

class Calculator{
	//덧셈
	public static int add(int x,int y) {
		return x+y;
	}
	//뺏셈
	public static int sub(int x,int y) {
		return x-y;
	}
	
	//곱셉
	public static int mul(int x,int y) {
		return x*y;
	}
	
	//나눗셈
	public static int div(int x,int y) {
		return x/y;
	}
	
}
public class Test02_Quiz {
	public static void main(String[] args) {
		System.out.println("두수의 합:" + Calculator.add(3, 8));
		System.out.println("두수의 뺄셈:" + Calculator.sub(3, 8));
		System.out.println("두수의 곱:" + Calculator.mul(3, 8));
		System.out.println("두수의 나눗셈:" + Calculator.div(3, 8));
	}
}
