package day07;

import java.util.Scanner;
import java.util.Vector;

import test.Book;

/*
 * 			   [인터페이스]
 * 
 *             Collection 
 *                  |
 *                 List
 *           _______|________
 *           |              |
 *       ArrayList        Vector
 * 
 * 
 * <Vector 클래스>  //사용을 잘 안함
 * - 객체를 배열처럼 관리해 주는 클래스(ArrayList와 유사함)
 * - ArrayList와 차이점
 * 	1)Vector클래스는 스레드의 동기화가 지원됨 - 멀티스레드환경에서는 안전하나 많은 자원이 소모되고
 *    메모리를 많이 사용함
 *  2)ArrayList는 스레드의 동기화가 지원되지 않음 - 멀티스레드 환경이 아니라면
 *    ArrayList를 사용하는 것이 효율적(가볍다)
 *  
 * - List클래스들의 특징
 *  1.저장순서가 있다.
 *  2.중복데이터가 저장된다.
 */
public class Test10_Vector {
	public static void main(String[] args) {
		Vector<String> vec=new Vector<String>();
		vec.add("홍길동");
		vec.add("이길동");
		vec.add("삼길동");
		
		for(int i=0;i<vec.size();i++) {
			String s=vec.get(i);
			System.out.println(s);
		}
		
		//Vector에 Book객체를 3개 저장하고 전체 도서정보를 출력해 보세요.
		Vector<Book> bv=new Vector<>();
		Scanner scan = new Scanner(System.in);
		
//		for(int i=0;i<3;i++) {
//			System.out.println("도서번호 입력:");
//			int num=scan.nextInt();
//			System.out.println("도서제목 입력:");
//			String title=scan.next();
//			System.out.println("도서가격 입력:");
//			int price=scan.nextInt();
//			
//			Book b = new Book(num,title,price);
//			
//			bv.add(b);
//		}
		
		bv.add(new Book(1,"java",10000));
		bv.add(new Book(2,"python",20000));
		bv.add(new Book(3,"jsp",30000));
		
		System.out.println("==전체 도서정보 출력==");
		for(int i=0;i<bv.size();i++) {
			Book b=bv.get(i);
			b.print();
		}
	}
}
