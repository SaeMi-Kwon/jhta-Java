package day16_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

import test.Person;
import test.Student;

public class Test02_Stream {
	public static void main(String[] args) {
		ArrayList<Student> list2=new ArrayList<>();
		list2.add(new Student(11,"홍길동",100));
		list2.add(new Student(2,"이길동",30));
		list2.add(new Student(32,"삼길동",50));
		
		
		//Stream<T> sorted(Comparator<? super T> comparator)--> Stream인터페이스의 sorted메소드 : 사용자정의
//		//번호순으로 출력
//		Comparator<Student> comparator=new Comparator<>() {
//			//오름차순
//			@Override
//			public int compare(Student o1, Student o2) {
//				if(o1.getNum()>o2.getNum()) {
//					return 1;
//				}else if(o1.getNum()<o2.getNum()) {
//					return -1;
//				}else {
//					return 0;
//				}
//			}
//		};
		
		//한줄로 축약
		Comparator<Student> comparator=(o1,o2)->Integer.compare(o1.getNum(), o2.getNum());
		
		//comparator : 정렬방식을 재정의 함
		list2.stream().sorted(comparator).forEach(t->System.out.println(t));
		
		
		//ArrayList에 Person객체를 3개 담고 나이가 높은순으로 출력되도록 해보세요.
		ArrayList<Person> list3=new ArrayList<>();
		list3.add(new Person("나길동",31));
		list3.add(new Person("안길동",17));
		list3.add(new Person("장길동",45));
		
		
		//내림차순
//		Comparator<Person> comparator1=new Comparator<>() {
//
//			@Override
//			public int compare(Person o1, Person o2) {
//				if(o1.getAge()>o2.getAge()) {
//					return -1;
//				}else if(o1.getAge()<o2.getAge()) {
//					return 1;
//				}else {
//					return 0;
//				}
//			}
//		};
		
		
		//방식1
//		Comparator<Person> comparator1=(o1,o2)-> Integer.compare(o1.getAge(), o2.getAge())*-1;		
//		list3.stream().sorted(comparator1).forEach(t->System.out.println(t));
		
		
		//방식2
		Stream<Person> st2=list3.stream();
		
		st2
			.sorted((o1,o2)->Integer.compare(o1.getAge(), o2.getAge())*-1)
			.forEach(t->System.out.println(t));
	}
}
