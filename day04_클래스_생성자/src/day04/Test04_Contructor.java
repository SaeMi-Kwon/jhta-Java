package day04;

/*
 * <생성자 - Constructor>
 * - 객체가 생성될때 자동으로 호출되는 메소드
 * - 주로 멤버변수값을 초기화하려는 목적으로 만든다.
 * - 만드는 형식
 * 	1. 클래스명과 동일한 이름으로 메소드이름을 만든다.
 * 	2. 리턴값을 갖을수 없으면 void를 적지 않는다.
 * 
 * 	예)
 * 	class AA{
 * 		public AA(){ }  //생성자
 * 	}
 * 
 */

class Font{
	private int fontSize; //글꼴크기
	private String fontName;  //글꼴체
	
	public Font() {   //기본생성자 초기화(셋팅)
		fontSize=12;
		fontName="굴림체";
	}
	
	public Font(int fontSize,String fontName) {   
		this.fontSize = fontSize;
		this.fontName = fontName;
	}
	
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}
	
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	
	public void printInfo() {
		System.out.println("설정된 글꼴크기:" + fontSize);
		System.out.println("설정된 글꼴체:" + fontName);
	}
}

public class Test04_Contructor {
	public static void main(String[] args) {
		//Font객체 생성해서 설정값을 지정후 정보를 출력해 보세요.
		Font font = new Font();
		font.setFontSize(5);
		font.setFontName("궁서체");
		font.printInfo();
		
		Font font1 = new Font();
		font1.printInfo();
		
		Font font2 = new Font(9,"바탕체");
		font2.printInfo();
	
	}
}
