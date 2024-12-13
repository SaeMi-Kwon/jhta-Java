package day05;
/*
 * [상속]
 * - 기본클래스(부모클래스,super클래스)의 속성과 메소드를 물려받고 기존의 기능을 수정하거나 
 * 	새로운 기능을 추가하는 것
 * - 형식
 * 	class 부모클래스명{
 * 		...
 * 	}
 * 	class 자식클래스명 extends 부모클래스명{
 * 		//기능 추가
 * 		..
 * 
 * 	}
 * 
 */

class HandPhone{
	private String phoneNum;
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum=phoneNum;
	}
	
	public void call() {
		System.out.println("내 핸드폰 번호:" + phoneNum);
		System.out.println("전화걸기.......");
	}
}

class Dicaphone extends HandPhone{
	private int pixel;  //화소수
	
	public void setPixel(int pixel) {
		this.pixel=pixel;
	}
	
	public void picture() {
		System.out.println(pixel + "만 화소");
		System.out.println("사진찍기");
	}
}

public class Test08_상속 {
	public static void main(String[] args) {
		Dicaphone dp=new Dicaphone();
		dp.setPhoneNum("010-111-1234");  //부모메소드
		dp.call();	//부모메소드
		dp.setPixel(1000000);
		dp.picture();
	}
}
