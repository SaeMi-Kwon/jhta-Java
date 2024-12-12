package day06;

import test.Member;

public class Test06_equals {
	public static void main(String[] args) {
		Object ob1=new Object();
		Object ob2=new Object();
		
//		if(ob1==ob2) {
//			System.out.println("두 객체는 같아요");
//		}else {
//			System.out.println("두 객체는 달라요");
//		}
		
		//public boolean equals(Object obj)
		boolean b = ob1.equals(ob2);
			if(b) {
				System.out.println("두 객체는 같아요");
			}else {
				System.out.println("두 객체는 달라요");
			}
		
			
		String s1=new String("hello");
		String s2=new String("hello");
		
//		if(s1==s2) {
//			System.out.println("두 문자열은 같아요");
//		}else {
//			System.out.println("두 문자열은 달라요");
//		}
		
		//public boolean equals(Object obj)
		boolean b1= s1.equals(s2);
		if(b1) {
			System.out.println("두 문자열은 같아요");
		}else {
			System.out.println("두 문자열은 달라요");
		}
		
		Member m1=new Member("hello","1234");
		Member m2=new Member("hello","1234");
		//두 객체의 id와 pwd가 같으면 true, 아니면 false가 리턴되도록 equals메소드 오버라이딩 하기
		boolean b2= m1.equals(m2);
		if(b2) {
			System.out.println("두 회원은 같아요");
			
		}else {
			System.out.println("두 회원은 달라요");
		}
		
	}
}
