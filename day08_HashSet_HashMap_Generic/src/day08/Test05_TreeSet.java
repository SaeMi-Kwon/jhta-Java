package day08;

import java.util.Iterator;
import java.util.TreeSet;

public class Test05_TreeSet {  //TreeSet는 사용을 잘 안함
	public static void main(String[] args) {
		//TreeSet을 사용해서 사용자 아이디를 저장하고 전체 저장된 아이디를 출력해 보세요.
		TreeSet<String> treeSet = new TreeSet<>();  //HashSet과 차이점은 저장순서가 정렬(오름차순)되어있다.
		
		treeSet.add("user");
		treeSet.add("admin");
		treeSet.add(new String("abcd"));
		
		Iterator id = treeSet.iterator();
		
		System.out.println("==전체 저장된 아이디 출력==");
		while(id.hasNext()) {
			Object s=id.next();
			System.out.println(s);
		
			//System.out.println(id.next());
		}
	}
}
