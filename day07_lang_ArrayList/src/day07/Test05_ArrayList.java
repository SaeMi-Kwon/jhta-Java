package day07;

import java.util.ArrayList;
/*
 * <ArrayList(***)>
 * - 객체를 배열처럼 저장하고 꺼내는 기능을 갖는 클래스(배열은 고정된 값,ArrayList 추가하기 용이함)
 * - 주요메소드
 * 	 public boolean add(E e) : 요소를 List의 마지막 위치에 추가
 *	 public int size() : List에 담긴 요소의 갯수 리턴
 *   public E get(int index) : index위치의 요소를 리턴
 *   public E set(int index,E element) : index위치에 element넣기
 *   public E remove(int index) : index위치의 요소 삭제
 *  
 */
public class Test05_ArrayList {
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		//public boolean add(Object e)
		list.add("홍길동");
		list.add("이길동");
		list.add("삼길동");
		
		//public int size()
		System.out.println("size:" + list.size());
		
		for(int i=0;i<list.size();i++) {
			//public Object get(int index)
			Object ob=list.get(i);
			System.out.println(ob);
		}
		
		
	}
}
