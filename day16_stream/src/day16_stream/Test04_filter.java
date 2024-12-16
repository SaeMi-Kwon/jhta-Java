package day16_stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.OptionalDouble;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import test.MyStudent;
import test.Person;
import test.Student;

public class Test04_filter {
	public static void main(String[] args) {
		ArrayList<Student> list1=new ArrayList<>();
		list1.add(new Student(10,"홍길동",100));
		list1.add(new Student(2,"이길동",80));
		list1.add(new Student(31,"삼길동",90));
		list1.add(new Student(11,"오길동",70));
		list1.add(new Student(22,"사길동",50));
		list1.add(new Student(30,"칠길동",90));
		
		//번호가 짝수인 데이터만 추출해서 출력하기
		//Stream<T> filter(Predicate<? super T> predicate)
		//boolean test(T t)-->Predicate의 함수형인터페이스
//		Predicate<Student> predicate=new Predicate<>() {
//			@Override
//			public boolean test(Student t) {
//				if(t.getNum()%2==0) {
//					return true;
//				}
//				return false;
//			}
//		};
//		list1.stream().filter(predicate).forEach(s->System.out.println(s));
		
		
		//람다식으로 바꿔서 해보세요
//		Predicate<Student> predicate=(t)->{
//			if(t.getNum()%2==0) {
//				return true;
//			}
//			return false;
//		};
//		list1.stream().filter(predicate).forEach(s->System.out.println(s));
		
		//(t.getNum()%2==0?true:false) -> t.getNum()%2==0 으로 생략가능
		//filter에서 반환값이 boolean을 반환하기 때문에 true,false는 불필요하다.
		list1.stream().filter(t->t.getNum()%2==0).forEach(s->System.out.println(s));
		
		
		
		//점수가 80점이상인 학생들만 출력되도록 해보세요.
//		Predicate<Student> predicate2=new Predicate<>() {
//			@Override
//			public boolean test(Student t) {
//				if(t.getScore()>=80) {
//					return true;
//				}
//				return false;
//			}
//		};
//		list1.stream().filter(predicate2).forEach(s->System.out.println(s));
		
		//람다식 해보기
		list1.stream().filter(t->t.getScore()>=80).forEach(s->System.out.println(s));
		
		
		//학생들 이름 출력하기
		//map : 원하는 객체들로만 뽑아와서 새로운 객체에 담고 싶을때 사용
		//<R> Stream<R> map(Function<? super T,? extends R> mapper)
//		Function<Student,String> mapper=new Function<>() {
//			@Override
//			public String apply(Student t) {
//				return t.getName();
//			}
//		};
//		list1.stream().map(mapper).forEach(t->System.out.println(t));
		
		System.out.println("<< 람다식 >>");
		list1.stream().map(t->t.getName()).forEach(t->System.out.println(t));
		
		
		//Student객체에서 번호와 이름을 추출해서 MyStrudent에 담기
//		Function<Student, MyStudent> mapper1=new Function<>() {
//			@Override
//			public MyStudent apply(Student t) {
//				return new MyStudent(t.getNum(),t.getName());
//			}
//		};
//		list1.stream().map(mapper1).forEach(t->System.out.println(t));
		
		
		list1
			.stream()
			.map(t->new MyStudent(t.getNum(),t.getName()))
			.forEach(t->System.out.println(t));
		
		
		
		//학생번호/점수만 추출하기 ->map
		Function<Student,HashMap<String,Integer>> func1=new Function<>() {
			@Override
			public HashMap<String, Integer> apply(Student t) {
				HashMap<String,Integer> map=new HashMap<>();
				map.put("num", t.getNum());
				map.put("score", t.getScore());
				return map;
			}
		};
		
		Consumer<HashMap<String,Integer>> consumer=new Consumer<HashMap<String,Integer>>() {
			@Override
			public void accept(HashMap<String, Integer> t) {
				int num=t.get("num");
				int score=t.get("score");
				System.out.println("번호" + num + ",점수:" + score);
			}
		};
		list1.stream().map(func1).forEach(consumer);
		
		
		System.out.println("<< 람다식으로 바꿔보기 >>");
		list1.stream().map(func1).forEach(t->{
			int num=t.get("num");
			int score=t.get("score");
			System.out.println("번호" + num + ",점수:" + score);
		});
		
		
		//ArrayList에 Person객체를 담고 age값이 20이상인 사람들만 출력되도록 해보세요.(filter)
		ArrayList<Person> list2=new ArrayList<>();
		list2.add(new Person("가길동",36));
		list2.add(new Person("나길동",15));
		list2.add(new Person("다길동",22));
		list2.add(new Person("라길동",31));
		list2.add(new Person("마길동",40));
		list2.add(new Person("바길동",28));
		list2.add(new Person("사길동",19));
		
//		Predicate<Person> predicate3=new Predicate<>() {
//			@Override
//			public boolean test(Person t) {
//				return (t.getAge()>=20)?true:false;
//			}
//		};
		
		list2.stream().filter(t->t.getAge()>=20).forEach(t->System.out.println(t));
		
		
		//ArrayList에 Person객체를 담고 이름값들만 출력되도록 해보세요.(map)
//		Function<Person,String> mapper2=new Function<>() {
//			@Override
//			public String apply(Person t) {
//				return t.getName();
//			}
//			
//		};
		
		list2.stream().map(t->t.getName()).forEach(t->System.out.println(t));
		
		//나이 합 구하기
		//IntStream mapToInt(ToIntFunction<? super T> mapper)
//		ToIntFunction<Person> intfunc=new ToIntFunction<Person>() {
//			public int applyAsInt(Person value) {
//				return value.getAge();
//			}
//		};
//		int tot=list2.stream().mapToInt(intfunc).sum();
//		System.out.println("사람들의 나이 합:" + tot);
		
//		int tot=list2.stream().mapToInt(new ToIntFunction<Person>() {
//			public int applyAsInt(Person value) {
//				return value.getAge();
//			}
//		}).sum();
//		System.out.println("사람들의 나이 합:" + tot);
		
		int tot=list2.stream().mapToInt(t->t.getAge()).sum();
		System.out.println("사람들의 나이 합:" + tot);
		
		//나이 평균 구하기
		//OptionalDouble : NullPointerException 방지하지 위해 한번 감싸준것(안전한 코딩)
		OptionalDouble d=list2.stream().mapToInt(t->t.getAge()).average();
		double ave=d.getAsDouble();
		System.out.println("나이평균:" + ave);
	}
}
