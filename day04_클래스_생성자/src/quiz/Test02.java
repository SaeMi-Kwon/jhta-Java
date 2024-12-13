package quiz;

//문제2) 가로,세로길이를 생성자 매개변수로 받아 사각형의 넓이를 
//구하는 클래스를 만들어 보세요


class Box{
	private int w,h,area;


	public Box(int w,int h) {
		this.w = w;
		this.h = h;
	}


	private int getArea() {
		return w*h;
	}


	public void areaInfo() {
		System.out.println("사각형의 넓이:" + getArea());
	}
}


public class Test02 {
	public static void main(String[] args) {
		Box b=new Box(3,4);
		b.areaInfo();
	}
}
