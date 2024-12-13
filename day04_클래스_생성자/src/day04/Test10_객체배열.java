package day04;

import test.Member;

public class Test10_객체배열 {
	public static void main(String[] args) {
		//Member객체가 3개가 생성된것이 아니라 Member객체를 참조할수 있는 참조변수가 3개 배열로 만들어짐 
		Member[] m=new Member[3];
		m[0]=new Member("admin","1234");
		m[1]=new Member("hello","2222");
		m[2]=new Member("user1","3333");
		
		for(int i=0;i<m.length;i++) {
			System.out.println("회원아이디:" + m[i].getId());
			System.out.println("비밀번호:" + m[i].getPwd());
		}
		
	}
}
