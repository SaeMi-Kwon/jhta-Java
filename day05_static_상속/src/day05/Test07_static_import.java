package day05;

//static import -> 메소드 호출시 클래스명을 쓰지 않는다.
//import static test.Calc.add;
//import static test.Calc.sub;
import static test.Calc.*;

public class Test07_static_import {
	public static void main(String[] args) {
		System.out.println("두수합:" + add(3, 4));
		System.out.println("두수차:" + sub(3, 4));
	}
}
