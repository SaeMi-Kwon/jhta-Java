package day06;
/*
 * [클래스간의 형변환]
 * - 클래스간에는 형변환이 안되지만 상속관계에서는 형변환이 가능하다.
 * - 부모클래스는 자식클래스를 참조할 수 있지만 자식에서 추가된 멤버는 참조할 수 없다.
 * 	단 오버라이딩된 멤버는 참조할 수 있다.
 * - 자식클래스에서 부모클래스를 참조할수는 있지만 이때는 강제형변환해야 한다.
 * 
 */

class AA{
	protected int a;
	
	public AA(int a) {
		this.a=a;
	}
	public void test() {
		System.out.println("test");
	}
	public void print() {
		System.out.println("a:" + a);
	}
}
class BB extends AA{
	private int b;
	
	public BB(int a, int b) {
		super(a);
		this.b=b;
	}
	
	@Override
	public void print() {  //오버라이딩된 메소드
		System.out.println("a:" + a + ", b:" + b);
	}
	
	public int getSum() {  //자식클래스에서 추가된 메소드
		return a+b;
	}
}
//AA를 상속받아 멤버변수 b가 추가되는 BB클래스를 만들고 a,b를 출력하도록 print메소드를 오버라이딩해보세요.
public class Test03_클래스간의형변환 {
	public static void main(String[] args) {
		BB bb=new BB(10,20);
		bb.print();
		
		AA aa=bb;  //가능 - 자동형변환
		aa.print();  //자식에서 오버라이딩된 메소드가 호출
		//aa.getSum();    //에러 -> 부모객체는 자식클래스에 추가된 멤버(메소드)는 호출 못함.(오버라이딩만 호출가능)
		
		BB cc=(BB)aa;  //가능 -> 강제형변환 해야 한다.
		cc.print();
		int n=cc.getSum();
		System.out.println(n);
		
		AA dd=new AA(100);
//		BB ee=(BB)dd;  //실행시에 에러
		
		//instanceof : ~타입의 객체인지 검사
		if(bb instanceof BB) {  //true
			System.out.println("bb는 BB타입의 객체입니다.");
		}
		
		if(bb instanceof AA) {	//true
			System.out.println("bb는 AA타입의 객체입니다.");
		}
		
		if(aa instanceof BB) {  //true
			System.out.println("aa는 BB타입의 객체입니다.");
		}
		
		if(bb instanceof Object) {  //true
			System.out.println("bb는 Object타입의 객체입니다.");
		}
	}
}
