package day16_stream;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Supplier;

import test.Person;

/*
 * < 메소드 참조 >
 * 	람다식이 하나의 메서드만 호출하는 경우에는 '메서드 참조(method reference)'라는 방법으로 람다식을 간략히 할 수 있다.
 * 	메소드를 참조해서 매개변수의 정보 및 리턴타입을 알아내어 람다식에서 불필요한 매개변수를 제거한다.
 * 	
 * 	형식)
 * 	- 클래스이름::메소드이름 (static인 경우)
 * 	  또는
 *    참조변수::메소드이름	(인스턴스인 경우)
 *    
 *  예) Function<String,Integer> f=(String s)->Integer.parseInt(s); //람다식
 *  	==> Function<String,Integer> f=Integer::parseInt;  //메소드참조
 *  
 *  
 *     생성자를 호출하는 람다식
 *     Function<String,MyClass> f=(s)->new MyClass(s);  //람다식
 *     Function<String,MyClass> f=MyClass::new;	 //메소드참조
 *     
 *     //Supplier<MyClass> <- 리턴타입
 *     Supplier<MyClass> s=()->new MyClass();	//람다식
 *     Supplier<MyClass> s=MyClass::new;  //메소드참조
 */

class MyMath{
	static int pow(int a) {
		return a*a;
	}
	int abs(int a) {
		return a>0?a:-a;
	}
}

public class Test08_메소드참조 {
	public static void main(String[] args) {
		MyMath m=new MyMath();
		
//		 Function<Integer,Integer> func1=new Function<>() {
//			@Override
//			public Integer apply(Integer t) {
//				return m.abs(t);
//			}
//		 };
		 
		 //Function<Integer,Integer> func1=t->m.abs(t);
		Function<Integer,Integer> func1=m::abs;
		int a=func1.apply(-10);
		System.out.println(a);
		
		
		
		//Function<Integer,Integer> func2=t->MyMath.pow(t);
		Function<Integer,Integer> func2=MyMath::pow;
		int b=func2.apply(10);
		System.out.println(b);
		
		
		//String s=String.valueOf(100);
		//Function을 사용해서 파라미터로 전달받은 Integer값을 String으로 변환해서 리턴하는
		//apply메소드를 구현하고 사용해 보세요 -> 메소드참조 사용해 보세요.
		
//		Function<Integer,String> func3=new Function<>() {
//			@Override
//			public String apply(Integer t) {
//				return String.valueOf(t);
//			}
//		};

		//람다식
		//Function<Integer,String> func3=t->String.valueOf(t);

		
		//메소드참조
		Function<Integer,String> func3=String::valueOf;
		String str=func3.apply(100);
		System.out.println(str);
		
		
		
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("개나리");
		list1.add("진달래");
		list1.add("무궁화");
		//list1.stream().forEach(t->System.out.println(t));
		list1.stream().forEach(System.out::println);

		
		
//		Supplier<Person> sp1=new Supplier<>() {
//
//			@Override
//			public Person get() {
//				return new Person();
//			}
//		};
		
		//람다식
		//Supplier<Person> sp1=()->new Person();  
		
		
		Supplier<Person> sp1=Person::new;  //생성자를 메소드참조 사용해보기
		Person p=sp1.get();
		p.setName("홍길동");
		p.setAge(20);
		System.out.println(p);
		
	}
}
