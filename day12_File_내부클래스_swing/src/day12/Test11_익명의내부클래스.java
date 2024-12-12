package day12;

/*
 * 익명의 내부클래스(*)
 * - 이름이 없는 클래스
 * - 추상클래스나 인터페이스를 상속받아 만든 클래스가 딱 한번만 사용되고 더이상 사용하지 않을때 익명의 내부클래스를 만들어준다.
 * - 만드는 방법
 * 	 인터페이스명(또는 추상클래스명) 객체명=new 인터페이스명(){
 * 	 	추상메소드오버라이딩(){...}
 *   };
 */
interface Shape{
	void draw();
}


public class Test11_익명의내부클래스 {
	public static void main(String[] args) {
		//방식1
		Shape box=new Shape() {
			public void draw() {
				System.out.println("사각형 draw");
			}
		};
		box.draw();
		
		
		//방식2
		new Shape() {
			public void draw() {
				System.out.println("타원그리기");
			};
		}.draw();
		
		
		//Shape를 상속받는 Rect라는 클래스를 만들고 사용해 보세요. 출력결과: 사각형그리기
		class Rect implements Shape{
			public void draw() {
				System.out.println("사각형그리기");
			}
		}
		Rect r=new Rect();
		r.draw();
		//new Rect().draw(); //가능 -> 한번만 호출할때
	}
}
