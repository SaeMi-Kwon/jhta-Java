package day16_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.IntStream;

import test.MyUser;
import test.Student;

/*
 * 회원아이디,이름,이메일,적립금(int) 정보를 갖는 클래스를 만드세요.(MyUser)
 * - ArrayList에 회원정보를 담고 Stream을 사용해서 전체 데이터를 출력해 보세요
 * - Stream을 사용해서 아이디순으로 정렬해서 출력해 보세요
 * - 적립금이 3000원이상인 회원들을 적립금이 높은순으로 출력해 보세요.
 * - 전체 회원들의 적립금의 합계금액을 구해서 출력해 보세요.
 */

public class Test05_Quiz {
	public static void main(String[] args) {
		ArrayList<MyUser> list=new ArrayList<>();
		list.add(new MyUser("user4","홍길동","hong4@naver.com",1000));
		list.add(new MyUser("user6","이길동","Lee6@naver.com",1500));
		list.add(new MyUser("user2","김길동","kim2@naver.com",2200));
		list.add(new MyUser("user1","박길동","park1@naver.com",3000));
		list.add(new MyUser("user3","권길동","kwon3@naver.com",3600));
		list.add(new MyUser("user5","조길동","cho5@naver.com",4200));
		
		
		//ArrayList에 회원정보를 담고 Stream을 사용해서 전체 데이터를 출력해 보세요
		System.out.println("<< 전체 데이터출력 >>");
		list.stream().forEach(t -> System.out.println(t));
		
		
		//Stream을 사용해서 아이디순으로 정렬해서 출력해 보세요
//		Comparator<MyUser> comparator=new Comparator<>() {
//			@Override
//			public int compare(MyUser o1, MyUser o2) {
//				return o1.getId().compareTo(o2.getId());
//			}
//		};
//		System.out.println("<< 아이디순으로 정렬 >>");
//		list.stream().sorted(comparator).forEach(t->System.out.println(t));
		
		System.out.println("<< 아이디순으로 정렬 >>");
		list.stream()
			.sorted((o1,o2)->o1.getId().compareTo(o2.getId()))
			.forEach(t->System.out.println(t));


		//적립금이 3000원이상인 회원들을 적립금이 높은순으로 출력해 보세요.
//		Predicate<MyUser> predicate1=new Predicate<>() {
//
//			@Override
//			public boolean test(MyUser t) {
//				if(t.getSavedMoney()>=3000) {
//					return true;
//				}
//				return false;
//			}
//		};
//		
//		Comparator<MyUser> comparator1=new Comparator<>() {
//			@Override
//			public int compare(MyUser o1, MyUser o2) {
//				return Integer.compare(o1.getSavedMoney(), o2.getSavedMoney())*-1;
//			}
//		};
//		System.out.println("<< 적립금 3000원이상 높은순으로 정렬>>");
//		list.stream().filter(predicate1).sorted(comparator1).forEach(t->System.out.println(t));
		
		System.out.println("<< 적립금 3000원이상 높은순으로 정렬>>");
		list.stream()
			.filter(t->t.getSavedMoney()>=3000)
			.sorted((o1,o2)->Integer.compare(o1.getSavedMoney(), o2.getSavedMoney())*-1)
			.forEach(t->System.out.println(t));
		
		
		//전체 회원들의 적립금의 합계금액을 구해서 출력해 보세요.
//		int sum=list.stream().mapToInt(new ToIntFunction<MyUser>() {
//			public int applyAsInt(MyUser value) {
//				return value.getSavedMoney();
//			}
//		}).sum();
//		System.out.println("회원들의 적립금 합:" + sum);
		
		int tot=list.stream().mapToInt(t->t.getSavedMoney()).sum();
		System.out.println("회원들의 적립금 합:" + tot);
		
	}
}
