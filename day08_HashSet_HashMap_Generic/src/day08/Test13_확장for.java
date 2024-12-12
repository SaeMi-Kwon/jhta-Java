package day08;

import java.util.ArrayList;

import test.Book;

/*
 * <확장 for>
 * - 배열이나 컬렉션 객체를 순차적으로 꺼내옴
 * - 형식
 * 	for(저장타입과 변수 : 배열(컬렉션객체)){
 * 		수행문장;
 * 		..
 * 	}
 * 
 */
public class Test13_확장for {
	public static void main(String[] args) {
		int[]a = {1,2,3,4,5};
		for(int n:a) {
			System.out.println(n);
		}
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("개나리");
		list.add("진달래");
		for(String s:list) {
			System.out.println(s);
		}
		
		//ArrayList에 Book객체 2개를 담고 확장for사용해서 출력해 보세요.
		ArrayList<Book> book=new ArrayList<>();
		book.add(new Book(1,"java",12000));
		book.add(new Book(2,"python",22000));
		for(Book bb:book) {
			bb.print();
		}
	}

}
