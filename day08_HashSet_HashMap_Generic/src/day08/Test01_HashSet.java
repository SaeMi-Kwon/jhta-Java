package day08;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
/*
 * Set ==> 자식클래스: HashSet
 * - 데이터를 저장할때 순서가 없다.
 * - 중복값을 저장할 수 없다.
 * 
 * Iterator (반복자) - 다음 요소를 순차적으로 꺼내옴
 * - boolean   hasNext() : 다음번 요소가 존재하면 true 리턴, 존재하지않으면 false
 * - E   next() : 다음번 요소를 리턴
 */
public class Test01_HashSet {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("개나리");
		hs.add("진달래");
		hs.add("무궁화");
		hs.add("장미꽃");
		hs.add("개나리");  //중복값이 허용안됨
		
		/*
		 * HashSet는 값을 꺼내오는 get메소드가 없다.(get(int index)는 인덱스값으로 꺼내오는것) 
		 * Set클래스는 순차적으로 저장이 되지않기때문에 get메소드를 사용할 수 없다.
		 * 그래서 값을 꺼내오는 메소드가 iterator()이다.
		 */
		
		//public Iterator<E> iterator()
		Iterator<String> it=hs.iterator();  //요소를 순차적으로 꺼내오기 위한 객체 얻어오기

		while(it.hasNext()) {  //다음 요소가 있나요?
			String s=it.next();  //다음 요소 객체 꺼내오기
			System.out.println(s);
		}
		
		ArrayList<String> list =new ArrayList<>();
		list.add("홍길동");
		list.add("이길동");
		list.add("삼길동");
		list.add("삼길동");  //중복값 허용
		
		//iterator메소드 사용해서 list의 모든 요소를 출력해 보세요.
		//public Iterator<E> iterator()
		Iterator<String> it2=list.iterator();
		
		//boolean  hasNext()
		//E  next()
		while(it2.hasNext()) {
			String n=it2.next();
			System.out.println(n);
		}
		
	}
}
