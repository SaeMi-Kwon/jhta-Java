package day08;

import java.util.HashSet;
import java.util.Iterator;

import test.Book;

public class Test04_HashSet {
	public static void main(String[] args) {
		Book b1=new Book(1,"java",10000);
		Book b2=new Book(2,"jsp",20000);
		Book b3=new Book(1,"java",10000);
		
		HashSet<Book> hs = new HashSet<>();
		hs.add(b1);
		hs.add(b2);
		hs.add(b3);
		System.out.println("b1:" + b1.hashCode());
		System.out.println("b3:" + b3.hashCode());
		
		String s1="hello";
		String s2="hello";
		System.out.println(s1.hashCode() + "," + s2.hashCode());
		
		String s3= new String("hello");
		String s4= new String("hello");
		System.out.println(s3.hashCode() + "," + s4.hashCode());
		
		
		//두 객체의 멤버변수값이 같으면 true가 리턴되도록 equals메소드를 오버라이딩해보세요
		if(b1.equals(b3)) {
			System.out.println("두 객체는 같아요");
		}else {
			System.out.println("두 객체는 달라요");
		}
	
		
		//전체 데이터 출력해 보세요
		Iterator<Book> book = hs.iterator();
		
		while(book.hasNext()) {
			Book b=book.next();
			b.print();
			System.out.println();
		}
	}
}
