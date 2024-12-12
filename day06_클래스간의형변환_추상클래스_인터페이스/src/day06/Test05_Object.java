package day06;


import java.util.Date;

import test.Member;

public class Test05_Object {
	public static void main(String[] args) {
		
		Object ob1=new Object();
		//public String toString()
		String a= ob1.toString();
		System.out.println(a);
		
		String b=new String("hello");
		//String클래스에서 toString()메소드를 오버라이딩했다
		String s1=b.toString();
		System.out.println("String===> " + s1);
		
		Date d=new Date();
		String s2= d.toString();
		System.out.println("Date===>" + s2);
		
		String s3=new String("world");
		System.out.println("s3:" + s3);  //.toString()은 생략가능
		
		Member m=new Member("user01","1234");
		String s4=m.toString();
		System.out.println("멤버===>" + s4);
		System.out.println(m);
	}


}
