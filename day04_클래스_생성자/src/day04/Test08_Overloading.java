package day04;

/*
 * [오버로딩(Overloading)]
 * - 같은 이름의 메소드를 중복해서 정의하는 것
 * - 메소드 이름은 같지만 파라미터 타입이나 갯수는 달라야 한다.
 * 
 * 예)
 * class AA{
 * 		public int add(int x,int y){
 * 			return x+y;
 * 		}
 * 		public int add(int x,int y,int z){  --> 오버로딩
 * 			return x+y+z;
 * 		}
 * 		public void add(int x,int y){  --> 오버로딩안됨 (에러)/리턴타입 영향X
 * 			System.out.println(x+y);
 * 		}
 * 		public double add(int x,double y){
 * 			return x+y;
 * 		}
 * 		public double add(double x,int y){  //오버로딩가능
 * 			return x+y;
 * 		}
 * }
 */

class MyRect{
	
	public int getArea(int x, int y) {
		return x*y;
	}
	
	public int getArea(int x) {
		return x*x;
	}
	
	public double getArea(double x,double y) {  //오버로딩
		return x*y;
	}
}

public class Test08_Overloading {
	public static void main(String[] args) {
		// MyRect 클래스의 세개의 메소드를 호출해서 사각형 넓이를 구해보세요.
		MyRect mr=new MyRect();
		
		//다른방식 예)
//		int n1 = mr.getArea(15,36);
//		System.out.println("직사각형 넓이:" + n1);
		
		System.out.println("직사각형 넓이:" + mr.getArea(15,36));
		System.out.println("정사각형 넓이:" + mr.getArea(70));
		System.out.println("실수형 직사각형 넓이:" + mr.getArea(48.3, 55.4));
	}
}
