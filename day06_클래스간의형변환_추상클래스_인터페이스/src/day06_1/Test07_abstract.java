package day06_1;
/*
 * <추상클래스>
 * - 추상메소드를 포함하는 클래스
 * - 객체를 생성할 수 없고 자식객체를 참조는 가능하다.
 * 
 * <추상 메소드(***)>
 * - body부분을 갖지 않는 메소드
 * - 자식클래스에서 반드시 오버라이딩해야 한다.
 * 
 */
abstract class Shape{  //추상클래스
	private int x;
	private int y;

	public Shape(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public abstract void draw(); //추상메소드	
}

class Rect extends Shape{
	
	public Rect(int x,int y) {
		super(x,y);
	}
	
	@Override
	public void draw(){
		System.out.println(getX() + "," + getY() + "의 위치에 사각형 그리기");
	}
}

//Shape상속받아 사각형그리는 기능(draw메소드 오버라이딩)을 갖는 Rect라는 클래스를 만들어 보고 사용해 보세요.
//출력결과 -> 100,200의 위치에 사각형 그리기
public class Test07_abstract {
	public static void main(String[] args) {
		//Shape s=new Shape(1,2);  추상클래스는 객체 생성 못함
		Rect r=new Rect(3,4);
		r.draw();
	}
}
