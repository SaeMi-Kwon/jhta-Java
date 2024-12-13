package day04;
/*
 * 파라미터로 int/double/long 을 받아서 절대값을 구해서 리턴하는 메소드를 갖는 클래스를 만들고
 * 사용해 보세요. 메소드들은 오버로딩하기
 * 
 * 예)
 * MyMath m = new MyMath();
 * int a=m.abs(-10);  //a는 10이 저장
 * double b=m.abs(-10.6) //b는 10.6이 저장
 * 
 */

class MyMath{
	
	public int abs(int x) {
		return (x>=0)?x:-x;
	}
	
	public double abs(double x) {
		return (x>=0)?x:-x;
	}
	
	public long abs(long x) {
		return (x>=0)?x:-x;
	}
	
	public float abs(float x) {
		return (x>=0)?x:-x;
	}
	
}
public class Test09_Quiz {
	public static void main(String[] args) {
		MyMath m = new MyMath();
		
		int a=m.abs(-10);
		System.out.println("a:" + a);
		
		double b=m.abs(-10.6);
		System.out.println("b:" + b);
		
		long c=m.abs(-2000000000000L);
		System.out.println("c:" + c);
		
		float f =m.abs(-10.5F);
		System.out.println("f:" + f);
	}
}
