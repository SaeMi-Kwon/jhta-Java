package quiz;

import java.util.HashSet;
import java.util.Iterator;

import test.Member;

//1) HashSet에 Member객체를 저장하고 전체데이터를 출력해 보세요.

public class Test01 {
	public static void main(String[] args) {
		HashSet<Member> member= new HashSet<>();
		member.add(new Member("user1","1234","user1@email.com"));
		member.add(new Member("test","5555","test@email.com"));
		member.add(new Member("admin","1111","admin@email.com"));
		
		Iterator<Member> m=member.iterator();
		
		while(m.hasNext()) {
			Member mm=m.next();
			System.out.println(mm);
		}
	}


}
