package day12;

class Outer5{
	private int c=10;
	private static int d=20;
	
	static class Inner5{ //static 내부클래스 -> 아우터 클래스의 static멤버만 접근 가능
		private int a=10;
		public void printA() {
			//System.out.println("c:" + c);  //에러
			System.out.println("d:" + d);
			System.out.println("a:" + a);
		}
	}
}

public class Test10_static내부클래스 {
	public static void main(String[] args) {
		//static내부클래스는 아우터 객체 없이 생성할 수 있다.
		Outer5.Inner5 inner=new Outer5.Inner5();
		inner.printA();
	}
}
