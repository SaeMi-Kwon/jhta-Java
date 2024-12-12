package day08;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import test.Book;

public class Test08_Quiz {
	public static void main(String[] args) {
		//아이디를 key로 비밀번호를 value로 저장하는 HashMap을 생성해서
		//데이터를 입력받아 저장하고 아이디로 비밀번호를 조회해 보세요
		
		HashMap<String,String> hm=new HashMap<>();
		
		Scanner scan=new Scanner(System.in);
		
//		while(true) {
//			System.out.println("아이디 입력");
//			String id=scan.next();
//			
//			if(id.equals("exit")) {
//				System.out.println("종료");
//				break;
//			}
//			System.out.println("비밀번호 입력");
//			String pw=scan.next();
//			
//			hm.put(id,pw);
//		}
//		
//		System.out.println("조회할 아이디 입력");
//		String findId=scan.next();
//		
//		String pwd=hm.get(findId);
//		
//		if(pwd!=null) {
//			System.out.println("<<조회된 비밀번호>>");
//			System.out.println(pwd);
//		}else {
//			System.out.println("해당 아이디가 존재하지 않아요");
//		}
		
		hm.put("hello","1234");
		hm.put("admin","0000");
		hm.put("java","1111");
		
		//public Set<K> keySet()     //key의 값만 필요한 경우 사용
		Set<String> set=hm.keySet();
		Iterator<String> it=set.iterator();
		
		System.out.println("==전체 Key값 출력하기==");
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		//TreeSet(Collection<E> c)
		TreeSet<String> ts=new TreeSet<String>(set);     //Key 정렬
		Iterator<String> it2=ts.iterator();
		System.out.println("=============================");
		System.out.println("TreeSet 사용해서 정렬후 출력");
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		System.out.println("=============================");
		
		//public Collection<V> values() : 메소드를 사용해서 전체 value값들을 출력해 보세요
		Collection<String> c=hm.values();
		Iterator<String> it1 = c.iterator();
		
		System.out.println("==전체 Value값 출력하기==");
		while(it1.hasNext()) {
			String s=it1.next();
			System.out.println(s);
		}
		
		
	}
}
