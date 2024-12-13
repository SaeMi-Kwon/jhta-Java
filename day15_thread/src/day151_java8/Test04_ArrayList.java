package day151_java8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import test.Person;

public class Test04_ArrayList {
	public static void main(String[] args) {
		//ArrayList에 문자열 3개를 저장하고 전체 데이터를 출력해 보세요
		ArrayList<String> list=new ArrayList<>();
		list.add("사과");
		list.add("복숭아");
		list.add("자두");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
//		//public Iterator<E> iterator()
//		Iterator<String> it=list.iterator();
//		while(it.hasNext()) {
//			String s=it.next();  
//			System.out.println(s);
//		}
		
		
		//public void forEach(Consumer<? super E> action)
		//void accept(T t) --> Consumer의 생성자
		Consumer<String> action=new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		list.forEach(action);
		
		
		//람다식으로 바꿔보세요
		Consumer<String> action1=(t)->System.out.println(t);
		list.forEach(action1);
		
		
		//한줄 축약
		list.forEach(t->System.out.println(t));
		
		//------------------------------------------------------------------------------
		
		//ArrayList에 Person객체 3명을 담고 forEach사용해서 출력해 보세요. 람다식 사용
		ArrayList<Person> psList=new ArrayList<>();
		psList.add(new Person("홍길동",21));
		psList.add(new Person("이길동",26));
		psList.add(new Person("삼길동",26));
		
		for(int i=0;i<psList.size();i++) {
			System.out.println(psList.get(i));
		}
		
		//ArrayList에 forEach메소드 사용
		//public void forEach(Consumer<? super E> action)
		//void accept(T t) --> Consumer의 생성자
		Consumer<Person> p=new Consumer<>() {
			@Override
			public void accept(Person t) {
				System.out.println(t);
			}
		};
		psList.forEach(p);
		
		
		//람다식
		Consumer<Person> p1=(t)->System.out.println(t);
		psList.forEach(p1);
		
		//한줄 축약
		psList.forEach(t->System.out.println(t));
		
		//---------------------------------------------------------------------------------
		
		//HashMap에 key값은 학생번호(Integer), value는 학생이름을 저장하는 해쉬맵을 생성하고 전체
		//key값과 value를 출력해 보세요.
		HashMap<Integer,String> hm=new HashMap<>();
		hm.put(1,"이몽룡");
		hm.put(2, "이춘향");
		hm.put(3, "황진이");
		
		//키 꺼내오기
		//public Set<K> keySet()
		Set<Integer> k= hm.keySet();
		Iterator<Integer> it=k.iterator();
		
		while(it.hasNext()) {
			Integer key=it.next();
			String value=hm.get(key);  //key값에 해당하는 value값을 얻어옴
			System.out.println(key + "," + value);
		}
		
		//값 꺼내오기
		//public Collection<V> values()
		Collection<String> c=hm.values();
		Iterator<String> it1 = c.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		//public Set<Map.Entry<K,V>> entrySet() : key와 value를 한쌍으로 저장하는 Set객체 얻어오기
		Set<Map.Entry<Integer,String>> entry=hm.entrySet();
		Iterator<Map.Entry<Integer,String>> it2=entry.iterator();
		while(it2.hasNext()) {
			Map.Entry<Integer, String> e=it2.next();
			System.out.println(e.getKey() +"," + e.getValue());
 		}
		
		//----------------------------------------------------------------------------------
		
		HashMap<Integer,String> map=new HashMap<>();
		map.put(1,"kim");
		map.put(2, "lee");
		map.put(3, "park");
		
		//public void forEach(BiConsumer<? super K,? super V> action)
		//void accept(T t,U u) -> BiConsumer의 생성자
		BiConsumer<Integer,String> action2=new BiConsumer<Integer,String>(){
			@Override
			public void accept(Integer t, String u) {
				System.out.println(t + "," + u);	
			}
		};
		map.forEach(action2);
		
		
		//람다식으로 바꿔보세요.
		BiConsumer<Integer,String> bc=
				(t,u)->System.out.println(t + "," + u);
		map.forEach(bc);
		
		//한줄 축약
		map.forEach((t,u)->System.out.println(t + "," + u));
		
		//-----------------------------------------------------------------------------------
		
		//HashSet에 3명의 학생이름을 저장하고 forEach메소드를 사용해서 전체 이름을 출력해 보세요.(람다식사용)
		HashSet<String> hs=new HashSet<>();
		hs.add("이대한");
		hs.add("이민국");
		hs.add("이만세");
		
		Iterator<String> it4=hs.iterator();
		while(it4.hasNext()) {
			String name=it4.next();
			System.out.println(name);
		}
		
		//default void forEach(Consumer<? super T> action)--> Iterable의 생성자
		Consumer<String> action3=new Consumer<>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};
		hs.forEach(action3);
		
		//람다식
		Consumer<String> cs=(t)->System.out.println(t);
		hs.forEach(cs);
		
		//한줄 축약
		hs.forEach(t->System.out.println(t));
		
	}

}
