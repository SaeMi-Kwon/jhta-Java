package quiz;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import test.Book;

/*
	2)도서(Book)관리 기능을 갖는 프로그램 만들어 보세요.
	--> HashMap사용
	
	==== 화면  ====
	1.도서추가  2.도서검색 3.도서삭제   4.도서수정  5.전체조회 6.종료
	원하는 메뉴:1
	..

 */

public class Test02 {
	public static void main(String[] args) {
		HashMap<Integer,Book> hm=new HashMap<>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("1.도서추가  2.도서검색  3.도서삭제  4.도서수정  5.전체조회  6.종료");
			int num =scan.nextInt();
			
			switch(num) {
			//도서추가
			case 1:
				System.out.println("[도서추가]");
				System.out.println("도서번호 입력:");
				int key=scan.nextInt();
				
				//public boolean containsKey(Object key) 
				if(hm.containsKey(key)) {
					System.out.println("해당 도서번호가 존재합니다.");
					break;
				}
				
				System.out.println("도서제목 입력:");
				String title=scan.next();
				System.out.println("도서가격 입력:");
				int price=scan.nextInt();
			
				hm.put(key, new Book(key,title,price));
				
				System.out.println("===추가 완료===");
				break;
				
			//도서검색
			case 2:
				System.out.println("[도서검색]");
				System.out.println("검색할 도서번호 입력:");
				int s=scan.nextInt();
				
				//public V get(Object key)
				Book bs=hm.get(s);
				
				if(bs!=null) {
					System.out.println("[출력결과]");
					bs.print();			
				}else {
					System.out.println("조회실패!");
				}
				
				break;
			//도서삭제
			case 3:
				System.out.println("[도서삭제]");
				System.out.println("삭제할 도서번호 입력:");
				int r=scan.nextInt();
				
				//public boolean containsKey(Object key)
				if(!hm.containsKey(r)) {
					System.out.println("도서번호가 존재하지 않습니다.");
					break;
				}
				//public V remove(Object key)
				hm.remove(r);
				
				System.out.println("===삭제완료===");
				break;
				
			//도서수정
			case 4:
				System.out.println("[도서수정]");
				System.out.println("도서번호 입력:");
				int u=scan.nextInt();
				
				//public boolean containsKey(Object key)
				if(!hm.containsKey(u)) {
					System.out.println("도서번호가 존재하지 않습니다.");
					break;
				}
				
				System.out.println("도서제목 수정:");
				String t=scan.next();
				System.out.println("도서가격 수정:");
				int p=scan.nextInt();
				
				//public V replace(K key,V value)
				hm.replace(u, new Book(u,t,p));
				
				System.out.println("===수정완료===");
				break;
				
			//전체조회
			case 5:
				System.out.println("[도서 전체조회]");
				//public Collection<V> values()
				Collection<Book> list=hm.values();
				Iterator<Book> show=list.iterator();
				while(show.hasNext()) {
					Book ss=show.next();
					ss.print();
				}
				break;
				
			//종료
			case 6:
				System.out.println("===[프로그램종료]===");
				return;
			default:
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}

}
