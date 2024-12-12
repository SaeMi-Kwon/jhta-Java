package day08;

import java.util.HashMap;
import java.util.Scanner;

import test.Book;

public class Test07 {
	public static void main(String[] args) {
		//도서번호를 KEY로, Book객체를 Value로 갖는 HashMap생성
		HashMap<Integer,Book> hm=new HashMap<>();
		hm.put(1,new Book(1,"jsp",10000));
		hm.put(2,new Book(2,"java",20000));
		hm.put(3,new Book(3,"oracle",30000));
		
		Scanner scan=new Scanner(System.in);
		System.out.println("조회할 도서 번호 입력");
		int n=scan.nextInt();
		
		//public V get(Object key)
		//Book get(Integer n)
		Book b=hm.get(n);
		
		if(b!=null) {
			System.out.println("<<조회된 도서 정보>>");
			b.print();
		}else {
			System.out.println("해당 도서번호가 존재하지 않아요");
		}
				
	}
}
