package day06;

import test.Shape;

class Rect2 extends Shape{
	
	public Rect2(int x,int y) {
		super(x,y);
	}

	public void draw() {   //오버라이딩
		System.out.println("사각형 그리기");
	}
	
	public void changeSize(int w,int h) {  
		System.out.println("가로:" + w + ",세로:" + h + "크기로 변경하기");
	}
}

class Circle2 extends Shape{
	private double r;  //반지름
	
	public Circle2(int x,int y,double r) {
		super(x,y);
		this.r=r;
	}
	
	public void draw() {
		System.out.println("반지름이 " + r +"인 타원 그리기");
	}
	
	public void changeR(double r) {
		this.r=r;
		System.out.println("반지름을 " + r + "로 변경");
	}
}

public class Test04 {
	public static void main(String[] args) {
//		Rect2 rect=new Rect2(100,200);
//		Shape s=rect; //가능
//		s.draw();  //Rect2d의 draw호출
//		//s.changeSize(400,500);  //에러
//		//new Circle(10,20,100.5).draw();  //사용은 가능(한번만 사용. 호출해서 사용할 변수가 없기 때문에)
//		Shape s1=new Circle2(10,20,100.5);  //가능      
//		s1.draw();
//		//s1.changeR(200);
//		Circle2 c2=(Circle2)s1;
//		c2.changeR(200);
		
		Rect2 r=new Rect2(100,200);
		Circle2 c=new Circle2(100,200,50);
		
		printer(r);
		printer(c);
		
		//sizeChange 메소드에서 각각 사각형의 크기 또는 타원의 크가가 변경되도록
		//메소드를 만들어 보세요
		
		sizeChange(r);
		sizeChange(c);
	
	}
	public static void sizeChange(Shape s) {
		System.out.println("도형크기 변경......");
		if(s instanceof Rect2) {
			Rect2 r= (Rect2)s;
			r.changeSize(4,6);
		}else if(s instanceof Circle2) {
			Circle2 c=(Circle2)s;
			c.changeR(8);
		}
	}
	
	
//	public static void sizeChange(Rect2 a) {
//		System.out.println("도형크기 변경1......");
//		a.changeSize(4,6);
//	}
//	public static void sizeChange(Circle2 b) {
//		System.out.println("도형크기 변경2......");
//		b.changeR(8);
//	}
//	
	
	public static void printer(Shape a) {
		System.out.println("프린터로 출력1......");
		a.draw();
	}
	
//	public static void printer(Rect2 a) {
//		System.out.println("프린터로 출력2......");
//		a.draw();
//	}
//	
//	public static void printer(Circle2 a) {
//		System.out.println("프린터로 출력3......");
//		a.draw();
//	}
}
