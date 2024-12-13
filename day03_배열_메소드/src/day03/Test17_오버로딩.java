package day03;

public class Test17_오버로딩 {
	public static void main(String[] args) {
		int c=sum(10,20,30);
		System.out.println("세수 합:" + c);
		
		int d=sum(100,200);
		System.out.println("두수 합:" + d);
		
		double e=sum(100.5,200.3);
		System.out.println("두 실수 합:" + e);
	}
	//에러-> 리턴타입은 상관없이 매개변수의 갯수와 타입이 같으면 오버로딩 할 수 없다.(리턴타입은 달라도 소용없음)
//	public static void sum(int a,int b) {      
//		System.out.println("두수합:" + (a+b));
//	}

	public static int sum(int a,int b,int c) {
		return a+b+c;
	}
	
	public static int sum(int a,int b) {  //오버로딩(메소명은 같으면서 매개변수의 갯수나 타입이 다른것)
		return a+b;
	}
	
	public static double sum(double a,double b) { //오버로딩
		return a+b;
	}
}
