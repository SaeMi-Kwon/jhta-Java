package day16_stream;

import java.util.NoSuchElementException;
import java.util.Optional;

import test.Student;

//Optional은 null 또는 값을 감싸서 NullPointerException으로부터 부담을 줄이기 위해 등장한 Wrapper클래스

public class Test06_Optional {
	public static void main(String[] args) {
		
		Student s1=new Student(1,"홍길동",100);
		
		//s1를 Optional객체로 감싸기(null이 아닌 경우(null값 허용안함))
		Optional<Student> opt=Optional.of(s1);  
		if(opt.isPresent()) {  //객체가 존재하면
			Student s2=opt.get(); //Optional에서 객체 꺼내오기
			System.out.println(s2);
		}
		
		
		
		Student s2=null;
		
		//s2를 Optional객체로 감싸기 -> null인 경우도 발생될 수 있는 경우(null값 허용)
		Optional<Student> opt1=Optional.ofNullable(s2);
		if(opt1.isPresent()) {  //객체가 존재하면
			Student s=opt1.get();  //Optional에서 객체 꺼내오기
			System.out.println(s);
		}else {
			System.out.println("데이터가 존재하지 않아요");
		}
		
		
		Optional<Student> opt2=Optional.ofNullable(s2);
		try {
			Student s3=opt2.orElseThrow();  //객체가 존재하면 반환하고 없으면 예외발생
			System.out.println("s3:" + s3);
			
		}catch(NoSuchElementException e) {
			System.out.println("데이터가 존재하지 않음");
		}
		
		
		
	}
}
