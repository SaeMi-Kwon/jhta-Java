package day07;

import java.util.ArrayList;
import java.util.Scanner;

import test.Book;
import test.Person;

/*
 * 1. 도서정보를 입력받아 ArrayList에 저장하세요. (도서정보는 3개)
 * 2. 입력된 전체 도서정보를 출력해 보세요.
 * 3. 도서번호를 입력받아 해당 도서를 조회하세요.
 * 	예)
 * 	도서번호:1
 * 	찾는 도서가 없습니다. 또는
 * 
 * 	도서번호:1
 * 	도서제목:자바완전정복
 * 	가격:20000원
 * 
 * 4. 도서번호 입력받아 해당 도서 삭제하기
 */
public class Test09_Quiz {
	public static void main(String[] args) {
		ArrayList<Book> bookList = new ArrayList<>();
		Scanner scan=new Scanner(System.in);
		
		for(int i=0;i<3;i++) {
			System.out.println("도서번호 입력:");
			int num=scan.nextInt();
			System.out.println("도서제목 입력:");
			String title=scan.next();
			System.out.println("도서가격 입력:");
			int price=scan.nextInt();
			
			Book b = new Book(num,title,price);
			bookList.add(b);
			
			//bookList.add(new Book(num,title,price));
		}
		
		//도서 검색하기
		System.out.println("찾는 도서번호 입력:");
		int num = scan.nextInt();
		boolean find=false;
		
		//System.out.println("==전체 도서 정보출력==");
		for(int i=0;i<bookList.size();i++) {
			Book b=bookList.get(i);
			//b.print();
			
			if(b.getNum()==num){
				System.out.println("====검색된 도서 정보===");
				b.print();
				find=true;
				break;
			}
		}
		
		if(!find) {
			System.out.println("검색된 도서번호가 없습니다.");
		}
		
		//도서 삭제하기
		System.out.println("삭제할 도서번호 입력:");
		int bNum = scan.nextInt();
		find=false;
		for(int i=0;i<bookList.size();i++) {
			Book b= bookList.get(i);
			
			if(b.getNum()==bNum){
				Book delB = bookList.remove(i);
				System.out.println("도서가 삭제되었습니다.");
				System.out.println("삭제된 도서 정보");
				delB.print();
				find=true;
				break;
			}
		}
		
		if(!find) {
			System.out.println("삭제할 도서번호가 없습니다.");
		}
		
	}
}
