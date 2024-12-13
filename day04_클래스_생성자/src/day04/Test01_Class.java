package day04;

/*
 * [객체 지향 프로그래밍]
 * - 모든 작업을 객체화해서 프로그래밍하는 기법
 * - 객체지향 프로그래밍에서는 모든 작업을 클래스로 구현한다.
 * - 클래스 만드는 형식
 * 	class 클래스명{  	//클래스명 대문자로 시작 예)Day, Car
 * 		멤버변수;
 * 		멤버메소드(){..}
 * 	}
 * 
 * - 클래스를 사용하기 위해서는 객체(인스턴스)를 생성해야 한다.
 * - 객체 생성 형식
 * 	클래스명 객체명=new 클래스명();
 * 
 * <접근 지정자>
 * private - 같은 클래스내에서만 접근 가능
 * default(생략가능) - 같은 패키지 내에서만 접근 가능
 * protected - 같은 패키지 내에서 접근 + 패키지가 달라도 상속받은 자식클래스에서 접근 가능
 * public - 어디서든 접근 가능
 *
 */


 /* 
 * 사격형 클래스
 * - 멤버변수 : 가로길이,세로길이,색상,내부색상,좌표(x,y),선색상, ...
 * - 멤버메소드(기능) : 값 지정/값 변경, 색상칠하기, 크기 확대, ... 
 */

class Rect{
	//멤버변수
	private int w;  //가로길이
	private int h;  //세로길이
	private String color;  //색상   //초기화 null
	
	public Rect() {}  //디폴트 생성자
	
	//멤버메소드
	//값 지정/값 변경
	public void setW(int w) {
		if(w<0) {
			System.out.println("가로길이가 0이하이면 안됩니다");
			this.w=10;
		}else {
			this.w=w;
		}
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void draw() {
		System.out.println(w + "," + h + "크기의 사각형 그리기");
	}
	
	public void paint() {
		System.out.println(color + "색상으로 사각형 칠하기");
	}
	
}

public class Test01_Class {
	public static void main(String[] args) {
		Rect r = new Rect();  //객체 생성 - 인스턴스
		
		//자바에서는 멤버변수에 직접 지정해주지 않는다(메소드를 통해 값 지정)
//		r.w=100;  //private멤버변수는 외부에서 접근못함
//		r.h=50;
//		r.color="blue";
		
		r.setW(-100);
		r.setH(50);
		//색상지정하기
		r.setColor("red");
		
		r.draw();
		r.paint();
		
		Rect r1= new Rect();
		r1.setW(200);
		r1.setH(200);
		r1.draw();
	}
}
