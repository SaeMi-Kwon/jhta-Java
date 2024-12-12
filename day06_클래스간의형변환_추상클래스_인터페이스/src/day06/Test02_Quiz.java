package day06;

class Rect1{
	protected double w; //가로
	protected double h; //세로
	
	public void setXY(double w,double h) {
		this.w=w;
		this.h=h;
	}
	public double getArea() {
		return w*h;
	}
}

class Triangle extends Rect1{
	
	@Override  //오버라이딩된 메소드인지 체크하기(오타 방지)
	public double getArea() {
		return (w*h)/2;
	}
}
//위의 클래스를 상속받아 삼각형의 넓이를 구하는 클래스를 만들고 사용해 보세요
//삼각형 넓이는 getArea()메소드를 오버라이딩합니다.
public class Test02_Quiz {
	public static void main(String[] args) {
		//삼각형 객체 생성하고 넓이 구해 보세요.
		Triangle t = new Triangle();
		t.setXY(5, 8);
		double ta =t.getArea();
		System.out.println("삼각형의 넓이:"+ta);
	}
}
