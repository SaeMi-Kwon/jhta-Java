package day151_java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Consumer;

import test.Member;

//회원아이디와 비밀번호를 저장하는 Member라는 클래스를 만들고
//ArrayList에 저장하고 아이디순으로 정렬되어 출력해 보세요.

public class Test06_Quiz {
	public static void main(String[] args) {
		ArrayList<Member> list=new ArrayList<>();
		list.add(new Member("user1@user.com","1111"));
		list.add(new Member("admin@admin.com","2222"));
		list.add(new Member("test@test.com","3333"));
		
		//public static <T extends Comparable<? super T>> void sort(List<T> list)
		Collections.sort(list);
		
		
		Consumer<Member> action=new Consumer<>() {
			@Override
			public void accept(Member t) {
				System.out.println(t);
			}
		};
		list.forEach(action);
		
		
		//람다식 forEach 사용 
		list.forEach(t->System.out.println(t));
	}
}
