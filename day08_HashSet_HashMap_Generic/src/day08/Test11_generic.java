package day08;

import java.util.ArrayList;
import java.util.Vector;

/*
 * ArrayList(Collection<? extends E> c)
 * 
 * -> Collection<? extends E> c : 
 * 		E타입의 클래스를 담은 Collection객체이거나 
 * 		E타입의 자식클래스를 담은 Collection객체
 */

class AA{
	private int a;
	public AA(int a) {
		this.a=a;
	}
	public int getA() {
		return a;
	}
}

//AA를 상속받고 int b; 멤버변수를 갖는 BB클래스를 만들고 데이터 출력해 보세요
class BB extends AA{
	private int b;
	
	public BB(int a,int b) {
		super(a);
		this.b=b;
	}
	public int getB() {
		return b;
	}
}

public class Test11_generic {
	public static void main(String[] args) {
//		BB bb=new BB(30,40);
//		System.out.println("a:" + bb.getA() +",b:"+ bb.getB());
		
		
		ArrayList<BB> list=new ArrayList<>();
		list.add(new BB(1,2));
		list.add(new BB(3,4));
		list.add(new BB(5,6));
		
		for(int i=0;i<list.size();i++) {
			BB b = list.get(i);
			System.out.println(b.getA() +", " + b.getB());
		}
		System.out.println("====================================");
		
		
		//ArrayList(Collection<? extends E> c) //Collection객체의 모든 자식타입을 담을수있다
		ArrayList<BB> list1=new ArrayList<>(list);  //가능
		list1.add(new BB(10,20));
		
		for(int i=0;i<list1.size();i++) {
			BB b = list1.get(i);
			System.out.println(b.getA() +", " + b.getB());
		}
		System.out.println("====================================");
		
		
		Vector<BB> v =new Vector<>();
		v.add(new BB(100,200));
		v.add(new BB(300,400));
		
		ArrayList<BB> list2=new ArrayList<BB>(v);
		list2.add(new BB(500,600));
		
		for(int i=0;i<list2.size();i++) {
			BB b = list2.get(i);
			System.out.println(b.getA() +", " + b.getB());
		}
		System.out.println("====================================");
		
		
		ArrayList<BB> list3=new ArrayList<BB>();
		list3.add(new BB(1,2));
		list3.add(new BB(3,4));
		
		//ArrayList(Collection<? extends E> c)
		ArrayList<AA> list4=new ArrayList<AA>(list3);  //가능
		list4.add(new AA(1000));	
		
		for(int i=0;i<list4.size();i++) {
			//멤법변수 b도 출력되도록 해보세요
			AA aa = list4.get(i);

			if(aa instanceof BB) {
				BB bb=(BB)aa;
				System.out.println("a:" + bb.getA() +", b:" + bb.getB());
			}else {
				System.out.println("a:" + aa.getA());
			}
			
			
		}
		
		
	}
}
