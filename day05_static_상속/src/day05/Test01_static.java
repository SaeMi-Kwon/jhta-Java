package day05;
/*
 * [static]
 * 1.static 메소드
 * - 일반 멤버메소드는 객체를 생성한 후에 사용할 수 있지만 static메소드는 <객체 생성없이 클래스명(**)으로 호출> 해서 사용한다.
 * - 일반멤버변수(인스턴스변수)는 사용할 수 없고 static멤버만 사용할 수 있다.
 * - this를 사용할 수 없다.
 * - 만드는 방법: 메소드 리턴형앞에 static을 붙여서 만든다.
 * - 인스턴스변수를 사용하지 않는 독립적인 작업의 메소드를 만들때 static메소드를 만든다.
 */

class Math1{
	private int n=0;
	
	public static int add(int x,int y) {
		//n =x+y;  에러 -> static메소드는 인스턴스변수를 사용할 수 없다
		return x+y;
	}
	public static int max(int x,int y) {
		return (x>y)?x:y;
	}
	
}

public class Test01_static {
	public static void main(String[] args) {
		//static메소드는 객체 생성없이 클래스명으로 호출한다.
		int a=Math1.add(8, 7);
		System.out.println("두수의 합:" + a);
		int b=Math1.max(4, 5);
		System.out.println("두수 중 큰값:" + b);
		
		//Math객체를 생성해서 add와 max메소드를 사용해 보세요
//		Math1 math=new Math1();
//		int a=math.add(4, 8);
//		System.out.println("두수의 합:"+a);
//		int b=math.max(7,3);
//		System.out.println("두수 중 큰값:"+b);
	}
}
