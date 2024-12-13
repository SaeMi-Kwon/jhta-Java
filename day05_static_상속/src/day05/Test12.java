package day05;

class MyRect{
	private int x;  //가로
	private int y;  //세로
	
	public MyRect(int x, int y) {
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getArea() {  //넓이구하기
		return x*y;
	}
}
//MyRect를 상속받아 부피를 구하는 기능을 갖는 클래스를 만들고 사용해 보세요.
class RectVolume extends MyRect{
	private int z;
	
	public RectVolume(int x,int y,int z) {
		super(x,y);
		this.z=z;
	}
	
//	public int getZ() {
//		return z;
//	}
	
	public int getVolume() {
		return getArea()*z;
	}
}

public class Test12 {
	public static void main(String[] args) {
		RectVolume rv=new RectVolume(7,4,9);
		int n=rv.getVolume();
		System.out.println("부피:"+ n);
	}
}
