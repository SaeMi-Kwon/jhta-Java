package test;

public class Book {
	private String title;
	private int price;
		
	public Book(String title,int price) {  //생성자
		this.title=title;
		this.price=price;
	}
		
	//출력메소드
	public void showInfo() {
		System.out.println("도서 제목:" + title);
		System.out.println("도서 가격:" + price + "원");
	}
}
