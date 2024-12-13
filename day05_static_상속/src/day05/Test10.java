package day05;
class Box{
	private double x;  //가로
	private double y;  //세로
	
	public void setXY(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getArea() {  //넓이구하기
		return x*y;
	}
}

//위의 클래스를 상속받아 높이에 해당하는 멤버변수를 갖고 부피를 구하는 기능을 추가된 클래스 만들고 사용해 보세요.
class MyBox extends Box{
	private double z; //높이

	public void setXYZ(double x,double y,double z) {
		setXY(x,y);
		this.z=z;
	}
	public double getZ() {
		return z;
	}
	public double getVolume() {
		return getArea() *z;
	}
	
}

public class Test10 {
	public static void main(String[] args) {
		MyBox b2=new MyBox();
		b2.setXYZ(10, 30, 55.5);
		System.out.println(b2.getVolume());
	}
}
