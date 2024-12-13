package day04;

import java.util.Scanner;

//가로길이,세로길이를 입력받아 사각형 넓이를 구해서 출력하는 클래스를 만들고
//main메소드에서 생성해서 사용해 보세요

class RectArea{
	private double width;
	private double height;
	private double area;
	
	//입력 메소드
	public void inputRect() {
		Scanner scan = new Scanner(System.in);
		System.out.print("가로길이 입력:");
		width=scan.nextInt();
		System.out.print("세로길이 입력:");
		height=scan.nextInt();
	}
	
	//계산 메소드
//	public void calcArea() {
//		area=width*height;
//	}
	
	public double calcArea() {
		return area=width*height;
	}
	
	//출력 메소드
	public void printArea() {
		calcArea();
		System.out.println("====사각형 정보=====");
		System.out.println("가로길이:" + width);
		System.out.println("세로길이:" + height);
		//System.out.println("사각형 넓이:" + area);
		System.out.println("사각형 넓이:" + calcArea());
		System.out.println();
	}
	
}

public class Test03_Quiz {
	public static void main(String[] args) {
		RectArea ra = new RectArea();
		ra.inputRect();
		//ra.calcArea();
		ra.printArea();
		
		RectArea ra1 = new RectArea();
		ra1.inputRect();
		//ra1.calcArea();
		ra1.printArea();
		
		if(ra.calcArea()>ra1.calcArea()) {
			System.out.println("첫번째 박스가 더 넓어요.");
		}else {
			System.out.println("두번째 박스가 더 넓어요.");
		}
	}
}
