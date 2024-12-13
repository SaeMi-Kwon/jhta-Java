package day03;

public class Test18_가변길이인자 {
	public static void main(String[] args) {
		int c=sum(10,20,30);
		System.out.println("세수 합:" + c);
		int d=sum(100,200);
		System.out.println("두수 합:" + d);
		int e=sum1(100,200,300);
		System.out.println("200+300=" + e);
	}
	
	//가변길이 인자 - 파라미터값들이 자동으로 배열로 저장된다.
	public static int sum(int ...args) {   //sum(자료형 ...변수명)
		int s=0;
		for(int i=0;i<args.length;i++) {
			s += args[i];
		}
		return s;
	}
	
	//sum1(100,200,300); 첫번째 파라미터는 a에 저장되고 이후 나머지 값들은 b에 배열로 저장된다.
//	public static int sum1(int ...a,int b) {   ->에러. 가변길이 인자는 맨앞,중간에 올수 없다(마지막에만 가능)
	public static int sum1(int a,int ...b) {
		System.out.println("a:" + a);   //int a 는 반드시 사용해줘야할때 사용
		
		int s=0;           
		for(int i=0;i<b.length;i++) {
			s += b[i];
		}
		return s;
	}

}
