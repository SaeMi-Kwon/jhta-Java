package test;

public class Book {
	private int num;  //도서번호
	private String title;  //제목
	private int price;  //가격
	
	public Book(int num,String title,int price) {
		this.num=num;
		this.title=title;
		this.price=price;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void print() {
		System.out.println("도서번호:" + num);
		System.out.println("도서제목:" + title);
		System.out.println("도서가격:" + price);
	}


}
