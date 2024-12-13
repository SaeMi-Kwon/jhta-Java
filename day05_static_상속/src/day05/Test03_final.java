package day05;
//final : 변수를 상수화 함. 대문자로 선언한다.

class MyCircle{
	private final int MAX=100;  //final은 선언과 동시에 초기화한다.
	private final String RED;
	private final String BLUE;
	public static final double PI=3.141592;
	
	public MyCircle() {    //final은 생성자에서 초기화 가능
		RED="rgb(255,0,0)";
		BLUE="rgb(0,255,0)";
	}
	
	public void print() {
		//MAX=200;  //에러발생. 값 변경 못함
		System.out.println("MAX:" + MAX);
		System.out.println("RED:" + RED);
		System.out.println("BLUE:" + BLUE);
	}
}
public class Test03_final {
	public static void main(String[] args) {
		MyCircle mc = new MyCircle();
		mc.print();
		System.out.println(10*10*MyCircle.PI);
	}
}
