package day03;

import java.util.Scanner;

public class Test14_Method {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("가로길이 입력");
		double x=scan.nextDouble();
		System.out.println("세로길이 입력");
		double y=scan.nextDouble();
		
		//1.boxArea메소드를 완성해서 사각형 넓이를 출력해 보세요.
		double area=boxArea(x,y);
		System.out.println("사각형넓이:" + area);
		
		
		//2. 두 정수를 입력받아 (--> main)
		//사용자 정의 메소드를 사용해서 두 수 중 큰값을 구해서 (--->메소드) 출력해 보세요.
		System.out.println("첫번째 정수");
		int n1=scan.nextInt();
		System.out.println("두번째 정수");
		int n2=scan.nextInt();
		
		int num=findMax(n1,n2);
		System.out.println(n1 + "과 " + n2 + "두 수중에 큰값:" + num);
		
		//3. 반지름을 입력받아 원의 넓이(반지름*반지름*3.14)를 구하는 메소드를 만들고
		//이를 이용해 원의 넓이를 구해서 출력해보세요.
		System.out.println("반지름 입력");
		int r=scan.nextInt();
		double circle=circleArea(r);
		System.out.println("원의 넓이:" + circle);
	}
	
	public static double boxArea(double x, double y) {
		double result=x*y;
		return result;
	}
	
	
	public static int findMax(int n1,int n2) {
		int result=(n1>n2)?n1:n2;  //return (n1>n2)?n1:n2;
		return result;
	}
	
	public static double circleArea(int r) {
		return r*r*3.14;
		
	}
	
}
