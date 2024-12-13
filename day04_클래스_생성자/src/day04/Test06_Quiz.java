package day04;

import test.Book;

/*
 * 도서제목과 가격을 저장하고 출력하는 클래스를 만들고 사용해 보세요.
 * 도서제목과 가격은 생성자 매개변수로 초기화 됩니다.
 * 예)Book book= new Book("java완전정복",10000);
 * 
 */
public class Test06_Quiz {
	public static void main(String[] args) {
		Book book=new Book("java의 정석", 28000);
		book.showInfo();
	}
}
