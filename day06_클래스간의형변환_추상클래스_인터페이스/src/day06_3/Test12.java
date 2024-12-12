package day06_3;

interface Shape{
	void draw();
	void paint();
}

interface Point{
	void setPoint(int x,int y);  //좌표지정
}

interface Rect extends Shape,Point{     //interface 두개를 상속할때는 extends를 사용한다.
	void resize();
}

class MyRect implements Rect{
	private int x; 
	private int y;
	private int w;
	private int h;
	
	public MyRect(int w,int h) {   //가로세로 초기화
		this.w=w;
		this.h=h;
	}
	
	@Override
	public void draw() {
		System.out.println("그리기");
	}
	
	@Override
	public void paint() {
		System.out.println("채우기");
	}
	
	@Override
	public void setPoint(int x,int y) {  //좌표값
		this.x=x;
		this.y=y;
		System.out.println("x:" + x + ", y:" + y);
	}
	
	@Override
	public void resize() {
		System.out.println("사이즈 변경");
	}
}
//Rect를 상속받아 구현하는 MyRect라는 클래스를 적절히 만들고 사용해 보세요
public class Test12 {
	public static void main(String[] args) {
		Rect mr=new MyRect(4,6);
		mr.draw();
		mr.paint();
		mr.setPoint(7, 9);
		mr.resize();
		
		
	}
}
