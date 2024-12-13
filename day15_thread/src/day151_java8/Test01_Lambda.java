package day151_java8;
/*
 * [ 람다식 ]
 * - jdk1.8 버전에서 추가된 기능
 * - 메소드를 하나의 식으로 간단하게 표현한 것
 * - 형식)
 * 	(자료형 변수)->{메소드 실행코드;}
 * 	- 함수형 인터페이스에서만 람다식을 사용할 수 있다.
 * 	- 함수형 인터페이스 : 추상메소드를 하나만 갖고 있는 인터페이스 (예:Runnable)
 * 
 */

@FunctionalInterface  //함수형인터페이스인지 검사(확인)
interface Shape{
	void draw();
	default void paint() {
		System.out.println("색칠하기");
	}
}

@FunctionalInterface
interface MyMath{
	int add(int a,int b);
}

interface MyCircle{
	double getArea(double r);
}

interface AA{
	void area(double r);
}

public class Test01_Lambda {
	public static void main(String[] args) {
		//Shape를 구현한 익명의 내부클래스를 만들고 사용해 보세요.
		Shape shape=new Shape() {
			@Override
			public void draw() {
				System.out.println("원 그리기");
			}
		};
		shape.draw();
		
		//()->{}
		//람다식을 사용해 보면
		Shape s=()->{
			System.out.println("사각형 그리기");
		};
		s.draw();
		
		
		
		MyMath myMath=new MyMath() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		int n1=myMath.add(1, 2);
		System.out.println(n1);
		
		//람다식으로 바꿔보면
		MyMath mm=(int a, int b)->{
			return a+b;
		};
		int n2=mm.add(10, 20);
		System.out.println(n2);
		
		//축약
		MyMath mm1=(a,b)->a+b;
		System.out.println(mm.add(10, 20));
		
		
		
		//MyCircle을 람다식을 사용해 구현하고 사용해 보세요.
		MyCircle mc=(r)->{  //파라미터 타입은 생략가능
			return r*r*3.14;
		};
//		double r1=mc.getArea(50);
//		System.out.println(r1);
		System.out.println("원의 넓이:" + mc.getArea(100));
		
		//실행문장이 하나이면서 return문인 경우는
		//return과 {} 생략할 수 있다.
		MyCircle m=(r)-> r*r*3.14;
		System.out.println("원의 넓이:" + m.getArea(100));
	
		
		
		AA aa=(r)->{
			System.out.println("넓이:"+ r*r*3.14);
			
		};
		aa.area(80);
		
		//실행문장이 하나인경우는 {}를 안써도 됨
		//매개변수가 1개인경우는 ()를 안써도 됨
		AA a=r->System.out.println(r*r*3.14);
		a.area(80);
		
	}
}
