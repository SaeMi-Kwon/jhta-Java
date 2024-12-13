package day01;
/*
[변수]
- 변수 : 임의의 값을 저장하기 위해 메모리상에 만들어지는 공간
- 만드는 형식
	자료형 변수명=초기값;
예) int a=10;
- 변수명 만드는 규칙
1)일반적으로 소문자로 작성한다.
2)영문자, 숫자, _를 사용할 수 있다.
3)예약어는 사용할 수 없다.
4)특수문자,공백을 사용할 수 없고 숫자로 변수명이 시작되면 안된다.

[자료형]
1)기본자료형 (Primitive Type)
-정수형:byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
-실수형:double(8바이트), float(4바이트)
-부울형:boolean(1바이트)
-문자형:char(2바이트)
2)자료참조형 (Reference Type)
-클래스, 배열
*/
public class Test02 {
	public static void main(String[] args) {
		int a=100;
		System.out.println("a의 값==>" + a);
		
		int b=200;
		int c=a+b;
		System.out.println("두수 합:" + c);
		
		byte d=100;
		System.out.println("d:" + d);
		
		long e=11111111111L;   //Long 타입의 상수만들기 : l 또는 L을 붙여준다.
		System.out.println("e:" + e);
		
		double f=1.5678;
		System.out.println("f:" + f);
		
		boolean g=4<5;
		System.out.println("g:" + g);
		
		int h='A' + 1;
		// sysout + ctrl + space
		System.out.println("h:" + h);
		System.out.println("h:" + (char)h);
		
		char i ='A';    //char형은 단일 문자만 저장 가능
		System.out.println("i:" + i);
		
		String name = "홍길동";   //문자열을 저장할때는 String클래스를 사용한다.
		System.out.println("name:" + name);
	}

}
