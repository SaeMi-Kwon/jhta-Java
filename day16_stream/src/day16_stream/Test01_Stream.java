package day16_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import test.Student;

/*
 * < Stream >
 * - JDK1.8버전부터 지원됨
 * - Collection객체들의 for문이나 iterator를 사용하는 것을 추상화해서 통일된 방식으로
 * 	 처리하도록 구현함
 * - 자주 사용되는 데이터 처리들을 정의해 놓음
 * 
 * - 스트림의 구조
 * 	 1. 스트림 생성
 *   2. 중개연산
 *   3. 최종연산
 *   
 * - 스트림의 특징
 *   1. 스트림은 데이터 소스를 변경하지 않음
 *   2. 스트림은 일회용이다.
 *   3. 스트림은 작업을 내부 반복으로 처리한다. (내부반복은 반복문을 메소드 내부에 숨겼다는 의미)
 */

public class Test01_Stream {
	public static void main(String[] args) {
		ArrayList<String> list1=new ArrayList<String>();
		list1.add("개나리");
		list1.add("진달래");
		list1.add("무궁화");
		
		//스트림객체 얻어오기
		//void forEach(Consumer<? super T> action)
		Stream<String> st1=list1.stream();
		
//		Consumer<String> action=new Consumer<>() {
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		};
//		st1.forEach(action);
		
		//람다식으로 바꿔보세요
		st1.forEach(t->System.out.println(t));
		//st1.forEach(t->System.out.println(t)); //예외발생 -> 스트림은 한번만 사용할 수 있다.
	
		Stream<String> st2=list1.stream();
		System.out.println("<< 정렬후 출력 >>");
		st2.sorted().forEach(t->System.out.println(t));
		
		
		ArrayList<Student> list2=new ArrayList<>();
		list2.add(new Student(1,"홍길동",100));
		list2.add(new Student(2,"이길동",30));
		list2.add(new Student(3,"삼길동",50));
		
//		Stream<Student> st3=list2.stream();
//		st3.sorted().forEach(t->{
//			System.out.println(t.getNum() + "," + t.getName() + "," + t.getScore());
//		});
		
		//축약
		list2.stream().sorted().forEach(t->{
			System.out.println(t.getNum() + "," + t.getName() + "," + t.getScore());
		});
		
		
		int[] a= {100,40,70,20,30};
		IntStream st3=Arrays.stream(a); //int배열을 스트림으로 얻어오기
		//오름차순 정렬해서 출력하기
		System.out.println("<< 오름차순 정렬후 출력 >>");
		st3.sorted().forEach(t->System.out.println(t));
		
		IntStream st4=Arrays.stream(a);
		int s=st4.sum();  
		//long count()
		long c=Arrays.stream(a).count(); 
		System.out.println("배열합:" + s + ",배열요소의 갯수:" + c);
		
		
		Stream<Integer> st5=Arrays.stream(a).boxed();  //boxed() : stream객체로 받아오기
		st5.forEach(t->System.out.println(t));
		
		
		
	}
}
