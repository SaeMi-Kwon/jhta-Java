package test;

public class Shape {  //클래스 접근 지정자: public / default만 가능
	//protected : 패키지가 달라도 자식클래스에서 접근 가능한 멤버
	protected int x;
	protected int y;
	
	public Shape(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public void printXY() {
		System.out.println("x:" + x);
		System.out.println("y:" + y);
	}
	
	public void draw() {
		System.out.println("도형그리기");
	}
	
}
