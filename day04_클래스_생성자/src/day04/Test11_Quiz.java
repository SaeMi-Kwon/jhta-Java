package day04;

import java.util.Scanner;

import test.Book;

//Book객체를 5개 배열로 생성하고 값 저장하고 출력되도록 해보세요.

public class Test11_Quiz {
public static void main(String[] args) {
		
		Book[] b = new Book[5];
		
//		b[0]=new Book("java",20000);
//		b[1]=new Book("C++",35000);
//		b[2]=new Book("python",18000);
//		b[3]=new Book("spring",25000);
//		b[4]=new Book("database",31000);
		
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<b.length;i++) {
			System.out.println("도서제목입력");
			String title=scan.next();
			System.out.println("도서가격입력");
			int price=scan.nextInt();
			
			b[i]=new Book(title,price);
		}
		
		for(int i=0;i<b.length;i++) {
			b[i].showInfo();
		}
		
	}
}
