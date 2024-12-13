package day05;

class AA{
	private int a;
	
	public AA() {
		System.out.println("AA생성자");
	}
	
	public AA(int a) {
		this.a=a;
	}
	public int getA() {
		return a;
	}
}

class BB extends AA{
	private int b;
	
	public BB(int a,int b) {
		super(a);  //부모생성자 호출
		System.out.println("bb생성자");
		this.b=b;
	}
	public int getB() {
		return b;
	}
}

public class Test11_생성자 {
	public static void main(String[] args) {
		//AA a1=new AA();
		
		//AA객체 생성하고 값 출력해 보기
		AA aa=new AA(4);
		int n=aa.getA();
		System.out.println(n);
		
		BB bb=new BB(100,200);
		System.out.println("a:" + bb.getA() + ",b:" + bb.getB());
	}
}
