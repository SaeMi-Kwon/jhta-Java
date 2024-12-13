package day04;

class MyCircle{
	private double r; //반지름

	public MyCircle() {  //생성자
		r=50;
	}
	
	public MyCircle(double r) {  //생성자
		this.r=r;
	}
	
	public double circleArea() {
		return r*r*3.14;
	}
}

public class Test05 {
	public static void main(String[] args) {
		//MyCircle 객체를 생성하고 넓이가 출력되도록 해보세요.
		MyCircle mc = new MyCircle();
		System.out.println("원의 넓이:" + mc.circleArea());
		
		MyCircle mc1 = new MyCircle(100);
		System.out.println("원의 넓이:" + mc1.circleArea());
	}
}
