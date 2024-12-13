package day151_java8;

import java.util.ArrayList;
import java.util.Collections;

import test.Person;
import test.Student;

public class Test05_Sort {
	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<>();
		list.add("진달래");
		list.add("개나리");
		list.add("무궁화");
		list.forEach(t->System.out.println(t));
		
		//public static void sort(List<T> list) --> Collections클래스의 메소드
		Collections.sort(list); //정렬하기
		System.out.println("<< 정렬 후 >>");
		list.forEach(t->System.out.println(t));
		
		
		ArrayList<Student> list1=new ArrayList<>();
		list1.add(new Student(10,"이길동",100));
		list1.add(new Student(3,"박길동",90));
		list1.add(new Student(2,"삼길동",70));
		
		//public static <T extends Comparable<? super T>> void sort(List<T> list)
		//Comparable를 상속한 것만 사용이 가능하다. --> Student에 상속되게 한다.
		Collections.sort(list1);
		
		System.out.println("<< 점수순으로 내림차순 정렬후 >>");

		//점수가 높은 높은순으로 출력되도록 해보세요.
		list1.forEach(t->{
			System.out.println(t.getNum() + "," + t.getName() + "," + t.getScore());
		});
		
		//ArrayList에 Person객체를 3개 담고 나이가 높은순으로 정렬되어 출력되도록 해보세요
		ArrayList<Person> list2=new ArrayList<>();
		list2.add(new Person("홍길동",16));
		list2.add(new Person("나길동",28));
		list2.add(new Person("전길동",31));
		
		Collections.sort(list2);
		list2.forEach(t->System.out.println(t));
		
		
		
	}
}
