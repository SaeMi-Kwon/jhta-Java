package day16_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import test.Student;

/*
 * ArrayList에 Student를 담고 Stream을 사용해서 아래 가능구현
 * - 학생정보중에서 학생번호와 이름만 추출해서 이름순으로 정렬해서 출력
 * - 학생 점수들의 총합 구하기
 * - 학생 점수들의 평균 구하기
 * - 학생 점수가 60점 미만인 학생들 출력하기
 * - 데이터 출력은 메소드 참조 이용
 */

public class Test09_Quiz {
	public static void main(String[] args) {
		ArrayList<Student> list=new ArrayList<>();
		list.add(new Student(3,"하길동",49));
		list.add(new Student(5,"김길동",86));
		list.add(new Student(2,"박길동",98));
		list.add(new Student(6,"이길동",67));
		list.add(new Student(1,"홍길동",54));
		list.add(new Student(4,"고길동",72));
		
		//학생정보 중에서 학생번호와 이름만 추출해서 이름순으로 정렬해서 출력
		
		//방법1
//		//학생번호,이름 추출
//		Function<Student,String> mapper=new Function<>() {
//			@Override
//			public String apply(Student t) {
//				
//				return t.getNum() + "," + t.getName();
//			}
//		};
//		
//		//이름순으로 정렬
//		Comparator<String> comparator=new Comparator<>() {
//
//			@Override
//			public int compare(String o1, String o2) {
//				String name1= o1.split(",")[1]; 
//				String name2= o2.split(",")[1];
//				return name1.compareTo(name2);
//			}
//		};
//		
//		//출력
//		Consumer<String> consumer=new Consumer<>() {
//			@Override
//			public void accept(String t) {
//				System.out.println(t);
//			}
//		};
//		
//		list.stream().map(mapper).sorted(comparator).forEach(consumer);
		
		System.out.println("<< 학생번호와 이름만 추출해서 이름순으로 정렬 >>");
		list.stream()
			.map(t->t.getNum() + "," + t.getName())
			.sorted((o1,o2)->{
				String name1= o1.split(",")[1]; 
				String name2= o2.split(",")[1];
				return name1.compareTo(name2);
			})
			.forEach(System.out::println);
		
		
		//방법2
//		Comparator<Student> comparator=new Comparator<>() {
//		@Override
//		public int compare(Student o1, Student o2) {
//			return o1.getName().compareTo(o2.getName());
//		}
//	};
//	
//	Comparator<Student> comparator=(o1,o2)->o1.getName().compareTo(o2.getName());
		
		
		Function<Student,HashMap<String,Object>> func1=new Function<>() {

			@Override
			public HashMap<String, Object> apply(Student t) {
				HashMap<String,Object> map=new HashMap<>();
				map.put("num", t.getName());
				map.put("name", t.getName());
				return map;
			}
		};
		
		list.stream()
			.sorted((o1,o2)->o1.getName().compareTo(o2.getName()))
			.map(func1)
			.forEach(System.out::println);
		
		
		
		//학생 점수들의 총합 구하기
//		ToIntFunction<Student> intfunc=new ToIntFunction<>() {
//			@Override
//			public int applyAsInt(Student value) {
//				return value.getScore();
//			}
//		};
//		int tot=list.stream().mapToInt(intfunc).sum();
//		System.out.println("학생 점수들의 총합:" + tot);
		
		int tot=list.stream().mapToInt(value->value.getScore()).sum();
		System.out.println("학생 점수 총합:" + tot);
		
		
		//학생 점수들의 평균 구하기
		OptionalDouble d=list.stream().mapToInt(t->t.getScore()).average();
		double avg=d.getAsDouble();
		System.out.println("학생 점수 평균:" + avg);
		
		
		//학생 점수가 60점 미만인 학생들 출력하기
//		Predicate<Student> predicate=new Predicate<>() {
//			@Override
//			public boolean test(Student t) {
//				return (t.getScore()<60)?true:false;
//			}
//		};
//		
//		Consumer<Student> consumer1=new Consumer<>() {
//			@Override
//			public void accept(Student t) {
//				System.out.println(t);
//			}
//		};
//		
//		list.stream().filter(predicate).forEach(consumer1);

		System.out.println("<< 점수가 60점 미만인 학생들 출력 >>");
		list.stream().filter(t->t.getScore()<60).forEach(System.out::println);
		
	}
}
