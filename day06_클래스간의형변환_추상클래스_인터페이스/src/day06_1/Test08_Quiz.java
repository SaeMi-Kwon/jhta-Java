package day06_1;

abstract class MyArea{
	protected int x;  //가로
	protected int y;  //세로
	
	public MyArea(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public abstract int getArea();
}
/*
 * MyArea 클래스의 getArea메소드를 추상메소드로 바꿔보세요.
 * MyArea 클래스를 상속받아 사각형넓이를 구하는 MyRect,삼각형넓이를 구하는 MyTri클래스를 만들고
 * 사용해보세요.
 */
class MyRect extends MyArea{
	public MyRect(int x,int y) {
		super(x,y);
	}
	
	public int getArea() {
		return x*y;
	}
}

class MyTri extends MyArea{
	public MyTri(int x,int y) {
		super(x,y);
	}
	public int getArea() {
		return (x*y)/2;
	}
}
public class Test08_Quiz {
	
	public static void main(String[] args) {
		MyArea r = new MyRect(3,5);
		MyArea t = new MyTri(3,5);
		
//		int a=r.getArea();
//		int b=t.getArea();
//		System.out.println("사각형의 넓이:"+a);
//		System.out.println("삼각형의 넓이:"+b);		
		
		print(r);
		print(t);
	}
		
		public static void print(MyArea a) {
			int ma=a.getArea();
			System.out.println("넓이:" + ma);
		}
		
}
