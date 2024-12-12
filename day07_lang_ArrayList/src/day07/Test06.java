package day07;

import test.Person;
import java.util.ArrayList;

public class Test06 {
	public static void main(String[] args) {
		Person p1=new Person("홍길동",10);
		Person p2=new Person("이길동",20);
		
		ArrayList list=new ArrayList();
		list.add(p1);
		list.add(p2);
		list.add("삼길동");  //컴파일에 문제가 없지만 런타임시 오류가 발생한다.
		
		//list에 저장된 요소의 이름과 나이가 출력되도록 해보세요
		for(int i=0;i<list.size();i++) {
			Object obj=list.get(i);
			
//			System.out.println(obj);  //obj.toString() 생략 -> 주소값 반환
			
			Person p=(Person)obj;
			p.print();
			
			//System.out.println(obj);
		}
	}
}
