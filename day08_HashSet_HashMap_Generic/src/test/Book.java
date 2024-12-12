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
	
	//equals메소드에서 true가 리턴되고 리턴된 hashCode값이 같으면 같은 객체로 인정
	@Override
	public boolean equals(Object obj) {
		boolean result=false;
		if(obj instanceof Book) {  //Book가 아닌 다른 객체가 들어오면 에러발생.(에러방지를 위해 instanceof로 사용)
			Book b=(Book)obj;
			if(num==b.num && this.title.equals(b.title) && getPrice()==b.price) {
				result=true;
			}
		}
		return result;
	}
	
	
	@Override
	public int hashCode() { 
		//멤버변수값들이 같으면 같은 해쉬코드 리턴하기
		String s=num+"," + title + "," + price;
		return s.hashCode();
	}
	
	public void print() {
		System.out.println("도서번호:" + num);
		System.out.println("도서제목:" + title);
		System.out.println("도서가격:" + price);
	}


}
