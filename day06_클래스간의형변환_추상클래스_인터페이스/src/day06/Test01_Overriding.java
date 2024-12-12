package day06;

import test.Shape;

/*
 * 오버라이딩(***)
 * - 부모클래스의 메소드를 자식클래스에서 수정하고자 할때 오버라이딩을 한다.
 * - 만드는 방법
 *   부모클래스의 메소드명,리턴형(반환타입),파라미터(매개변수)타입과 갯수 모두 일치해야 한다.
 * 
 * 예)
 * class Parent{
 * 		public void print(){}
 * 
 * class Child extends Parent{
 * 		public void print(){}  //오버라이딩
 * 		public void print(String s){} //오버로딩
 * }
 * 
 */

class Rect extends Shape{
	
	public Rect(int x,int y) {
		super(x,y);
	}
	
	public void draw() {   //오버라이딩
		System.out.println("x:" + x + ",y:" + y);
		System.out.println("사각형 그리기");
	}
	
	public void paint(String color) {  //추가
		System.out.println(color + "색상으로 사각형 칠하기");
	}
	
}
/*
 * Shape를 상속받아 반지름이 추가되는 타원 클래스를 만들고
 * draw메소드를 적절히 오버라이딩하고 사용해 보세요.
 */
class Circle extends Shape{
	private double r;  //반지름
	
	public Circle(int x,int y,double r) {
		super(x,y);
		this.r=r;
	}
	
	public void draw() {
		System.out.println("반지름이 " + r +"인 타원 그리기");
	}
}

public class Test01_Overriding {
	public static void main(String[] args) {
		//Rect객체를 사용하고 그리기/칠하기 메소드 호출해 보세요
		Rect r=new Rect(150,400);
		r.draw();
		r.paint("red");
		
		Circle c=new Circle(100,200,15.6);
		c.draw();
		
	}
}
