package day08;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import test.Member;

/*
 * <아이디/ 비밀번호/ 이메일에 대한 정보를 갖는 Member 클래스 만들기>
 * 1.HashMap에 아이디를 Key값으로 Member객체를 value값으로 저장하도록 생성하고 데이터를 저장해 보세요
 * 2.아이디로 Member객체를 조회해 보세요. 출력결과는 아이디,비밀번호,이메일
 * 
 * *메뉴선택
 * 1.회원등록  2.아이디로 조회  3.회원삭제(아이디)  4.전체회원출력
 * public V replace(K key,V value)  -> 수정시 사용
 * 
 */
public class Test09_Quiz {
	public static void main(String[] args) {
		HashMap<String,Member> hm=new HashMap<>();
		
		Scanner scan=new Scanner(System.in);
		
//		hm.put("user1", new Member("user1","1234","user1@naver.com"));
//		hm.put("abcd", new Member("abcd","2233","abcd@naver.com"));
//		hm.put("admin", new Member("admin","1111","admin@gmail.com"));

		//회원등록
		while(true) {
			System.out.println("1.회원등록  2.아이디로 조회  3.회원삭제  4.전체회원출력  5.종료");
			int num =scan.nextInt();
			
			switch(num) {
				case 1:
					System.out.println("[회원등록]");
					System.out.println("아이디 입력");
					String key=scan.next();
		
					System.out.println("비밀번호 입력");
					String pw=scan.next();
		
					System.out.println("이메일 입력");
					String email=scan.next();

					//public boolean containsKey(Object key)  //중복키 존재 확인여부
					if(hm.containsKey(key)) {
						System.out.println("해당 아이디가 존재합니다.");
						return;  //메소드끝내기
					}
					
					hm.put(key, new Member(key,pw,email));
					System.out.println("회원등록 완료!");
					break;
	
				//조회기능
				//public V get(Object key)
				case 2:
					System.out.println("[회원조회]");
					System.out.println("조회할 id 입력:");
					String s =scan.next();
		
					Member id=hm.get(s);
		
					if(id!=null) {
						System.out.println("[출력결과]");
						System.out.println(id);
						//id.print();			
					}else {
						System.out.println("조회실패!");
					}
					break;
					
					
				//회원삭제
				//public V remove(Object key)
				case 3:	
					System.out.println("[회원삭제]");
					System.out.println("삭제할 id 입력:");
					String r =scan.next();
					
					//public boolean containsKey(Object key)
					if(!hm.containsKey(r)) {
						System.out.println("해당 아이디가 존재하지 않습니다.");
						return;  //메소드끝내기
					}
			
					hm.remove(r);
					System.out.println("회원삭제 완료!");
					break;
			
				//전체회원출력
					
				case 4:
					System.out.println("[전체회원출력]");
					
					//public Collection<V> values()
					Collection<Member> list=hm.values();
					Iterator<Member> m = list.iterator();
					while(m.hasNext()) {
						Member mm=m.next();
						System.out.println(mm);
					}
					break;
		
				case 5:
					System.out.println("[프로그램종료]");
					return;
				default:
					System.out.println("번호를 다시 선택해주세요");
			}
		}
		
		
	}
}
