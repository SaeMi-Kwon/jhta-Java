package day05;
/*
 * 2.static변수
 * - 인스턴스변수는 객체의 수만큼 생성되지만 static변수는 <객체의 생성수와는 상관없이 오로지 하나만 생성> 되어
 * 	모든 객체가 공유해서 사용한다.
 * - 만드는 방법: 멤버변수앞에 static을 붙여서 만든다.
 * - 인스턴스변수는 객체를 new로 생성하는 순간에 만들어지지만 static멤버변수는 new로 생성하지 않아도 클래스가
 * 	메모리에 로딩되는 순간에 생성된다.
 * 
 */

class MyClass{
	private int a;   //인스턴스변수
	private static int b=0;  //static 멤버변수
	
	public MyClass() {
		a++;
		b++;
	}
	public void print() {
		System.out.println("a:" + a);
		System.out.println("b:" + b);
	}
	public static int getB() {
		return b;
	}
}
public class Test04_static {
	public static void main(String[] args) {
		MyClass ob1=new MyClass();
		ob1.print();
		MyClass ob2=new MyClass();
		ob2.print();
		MyClass ob3=new MyClass();
		ob3.print();
		
		System.out.println("b:" + MyClass.getB());
	}
}
