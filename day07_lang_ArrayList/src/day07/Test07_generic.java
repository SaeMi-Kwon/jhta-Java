package day07;

import java.util.ArrayList;

import test.Person;

/*
 * [제너릭(Generic)]
 * - 자료구조관련 클래스(ArrayList,Vector,...)에 특정 클래스타입만 저장할 수 있도록 설정해 주는 것
 * - Collection 클래스에 실수로 다른 클래스타입이 저장됨을 방지할수 있다.(안전하게 사용가능)
 * - 저장된 요소를 꺼내올때 형변환을 하지 않아도 된다.
 * - 형식
 *   클래스명<저장할클래스타입> 객체명=new 클래스명<저장할클래스타입>();
 *   
 */
public class Test07_generic {
	public static void main(String[] args) {
		//String타입객체만 저장 가능한 ArrayList생성
		ArrayList<String> list=new ArrayList<>();  //jdk7이상부터는 뒤에 <>생략가능
		list.add("김자바");
		list.add("이디비");
		list.add("나하나");
		//list.add(new Integer("김두울"));  //->에러 : String객체만 저장 가능
		for(int i=0;i<list.size();i++) {
			//제너릭을 사용하면 자식타입으로 형변환 하지 않아도 됨
			String s=list.get(i);
			System.err.println(s);
		}
		
		//ArrayList에 Person객체를 3개 담고 전체 데이터를 출력해 보세요 -> 제너릭 사용
		ArrayList<Person> ps=new ArrayList<Person>();
		Person pe1=new Person("류희동",14);
		Person pe2=new Person("이수동",20);
		//Person pe3=new Person("김자동",23);
		
		ps.add(pe1);
		ps.add(pe2);
		ps.add(new Person("김자동",23));
		
		for(int i=0;i<ps.size();i++) {
			Person p=ps.get(i);
			p.print();
		}
		
		//public E set(int index,E element) : index위치에 element넣기
		Person pp=ps.set(0,new Person("hong",40));
		System.out.println("수정후 된 요소 ===>" + pp);
		
		//public E remove(int index) : index위치의 요소 삭제
		Person pp1=ps.remove(1);
		System.out.println("삭제후 리턴된 요소==>" + pp1);
		System.out.println("<<<<<리스트 요소>>>>");
		for(int i=0;i<ps.size();i++) {
			Person p1=ps.get(i);
			System.out.println(p1);
		}
		
	}
}
