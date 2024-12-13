package day04;

import test.Member;

public class Test07 {
public static void main(String[] args) {
		
		//참조형
		Member m=new Member("hello","1234");
		System.out.println("아이디:" + m.getId() + ", 비밀번호:" + m.getPwd());
		Member m1=m;  //가능
		System.out.println("아이디:" + m1.getId() + ", 비밀번호:" + m1.getPwd());
		
		print(m);
		System.out.println("<메소드 호출후>");
		System.out.println("아이디:" + m.getId() + ", 비밀번호:" + m.getPwd());
		
		
		//자료형
		int a=10;
		System.out.println("main에서 a:" + a);
		printA(a);
		System.out.println("<메소드 호출후>");
		System.out.println("main에서 a:" + a);
	}
	
	//자료형 메소드
	public static void printA(int a) {
		a = a + 20;
		System.out.println("메소드에서 a:" + a);
	}
	
	//참조형 메소드
	public static void print(Member m1) {
		System.out.println("<프린터로 출력>");
		System.out.println("아이디:" + m1.getId() + ", 비밀번호:" + m1.getPwd());
		m1.editInfo("user1", "0000");
		System.out.println("<정보 변경후>");
		System.out.println("아이디:" + m1.getId() + ", 비밀번호:" + m1.getPwd());
	}
}
