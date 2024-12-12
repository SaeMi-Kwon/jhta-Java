package day08;

import java.util.HashMap;

/*
 *  Map
 * - Key와 Value가 한쌍으로 저장되는 자료구조 인터페이스
 * - Key값은 중복될수 없고 Value값은 중복될수 있다.
 * 
 * 	HashMap (Map을 구현한 클래스)
 * - 주요메소드
 * public V put(K key,V value) : Key와 Value를 한쌍으로 저장   
 * public V get(Object key) : Key에 해당하는 Value를 리턴(가져옴)
 * 
 */

public class Test06_HashMap {
	public static void main(String[] args) {
		//Key:학생번호, Value:이름
		//HashMap<Key타입, Value타입>;
		HashMap<Integer,String> hm=new HashMap<>();
		hm.put(1, "홍길동");
		hm.put(2, "이길동");
		hm.put(3, "삼길동");
		
		String a= hm.get(1);  //Key에 해당하는 Value리턴(없는 키값을 꺼내오면 null로 반환됨)
		System.out.println(a);
	}

}
