package day16_stream;

import java.util.function.Function;

import test.Student;

/*
 * Function인터페이스
 * 	- R apply(T t) 추상메소드를 갖는다
 */

public class Test03_Function {
	public static void main(String[] args) {
		
//		//Function<T, R> : <파라미터타입, 리턴타입>
//		Function<Integer, Double> func1=new Function<>() {
//			@Override
//			public Double apply(Integer t) {
//				return t/2.0;
//			}
//		};
//		double r=func1.apply(15);
//		System.out.println(r);
		
		
		//람다식으로 바꿔보세요.
		Function<Integer, Double> func1=(t)-> t/2.0;
		double r=func1.apply(15);
		System.out.println(r);
		
		
		
//		Function<Student,Integer> func2=new Function<>() {
//			@Override
//			public Integer apply(Student t) {
//				return t.getScore()/10;
//			}
//		};
//		int a=func2.apply(new Student(1,"홍길동",80));
//		System.out.println(a);
		
		
		//람다식으로 바꾸기
		Function<Student,Integer> func2=t-> t.getScore()/10;
		int a=func2.apply(new Student(1,"홍길동",80));
		System.out.println(a);
		
		
		
		//Student객체를 파라미터로 전달받아 학점을 리턴하는 Function인터페이스를
		//람다식을 이용해 만들고 사용해 보세요. 학점:점수 90이상 "A", 80점이상 "B",...
		
//		Function<Student,String> func3=new Function<>() {
//			@Override
//			public String apply(Student t) {
//				if(t.getScore()>=90) {
//					return "A";
//				}else if(t.getScore()>=80) {
//					return "B";
//				}else if(t.getScore()>=70) {
//					return "C";
//				}else if(t.getScore()>=60) {
//					return "D";
//				}else {
//					return "F";
//				}
//				
//			}
//		};
		
		
		Function<Student,String> func3=(Student t)->{
			if(t.getScore()>=90) {
				return "A";
			}else if(t.getScore()>=80) {
				return "B";
			}else if(t.getScore()>=70) {
				return "C";
			}else if(t.getScore()>=60) {
				return "D";
			}else {
				return "F";
			}
		};
		String str=func3.apply(new Student(2,"나길동",78));
		System.out.println("학점:"+str);
		

	}
}
