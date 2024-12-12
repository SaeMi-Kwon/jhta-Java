package day12;
/*
 * [ 로컬내부클래스 ]
 * - 메소드안에 클래스가 만들어진 경우
 * - 메소드내에서만 사용가능
 * - 외부클래스의 멤버변수는 접근가능하지만 메소드내의 지역변수는 접근할 수 없고 final상수만 접근가능하다.
 */

class Outer2{
	private int a=10;
	
	public void printA() {
		int c=100;  //final int c=100;
		System.out.println("1. a:" + a);
		
		class Inner1{  //로컬내부 클래스-메소드내에서만 사용가능
			private int b=10;
			public void printAll() {
				//로컬내부클래스에서 지역변수를 사용하면 자동 final이 된다.
				System.out.println("2. a:" + a + ",b:" + b + ",c:" + c);
			}
		}
		
		Inner1 in =new Inner1();
		in.printAll();
	}
}
public class Test09_로컬내부클래스 {
	public static void main(String[] args) {
		Outer2 out = new Outer2();
		out.printA();
	}
}
