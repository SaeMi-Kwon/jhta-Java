package day06_2;
/*
 * [인터페이스(***)]
 * - 자식클래스들이 가져야 할 기능들의 목록을 제시(뼈대역할,기본틀)
 * - 상수와 추상메소드들로 이루어진다. (jdk8.0이상에서는 default메소드기능이 추가됨)
 * - 만드는 형식
 * 	interface 인터페이스명{
 * 		상수;
 * 		추상메소드();
 * 		default 리턴형 메소드명(){ 실행코드; ...}
 * }
 * 
 *- 인터페이스는 객체를 생성할 수 없지만 자식객체를 참조할 수는 있다.
 *- 사용이유
 *	1. 자식클래스들이 가져야 할 기능들의 뼈대를 제공
 *	2. 클래스에서 다중상속이 지원되지 않지만 인터페이스는 다중상속이 가능하다.
 *	3. 인터페이스를 적절히 사용함으로써 유지보수가 수월해 진다.
 */
interface Shape{
	//상수 + 추상메소드로 이루어짐
	double PI=3.14;   //public static final이 생략됨 (상수)
	void paint(String color);  //public abstact가 생략됨
	void draw();
	default void initXY(int x,int y) {   //default메소드 -> 구현부를 갖을수 있다.
		System.out.println(x + "," + y + "위치로 초기화 됨");
	}
}

class Box implements Shape{  //implements : 인터페이스 상속
	@Override
	public void paint(String color) {   //오버라이딩 메소드에는 public 생략하면 안된다.
		System.out.println(color + "색상으로 사각형 칠하기");
	}
	@Override
	public void draw() {
		System.out.println("사각형 그리기");
	}
}
public class Test09_Interface {
	public static void main(String[] args) {
		Box box = new Box();
		box.paint("red");
		box.draw();
		box.initXY(0, 0);
		System.out.println(Shape.PI);  //static이라서 클래스로 호출
		
		Shape s= new Box();
		s.paint("blue");
		s.draw();
	}
}
