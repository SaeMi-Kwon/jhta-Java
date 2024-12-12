package test;

public class MemberMySql implements MemberDB{
	@Override
	public void conn() {
		System.out.println("MySQL db접속...");
	}
	
	@Override
	public void insert(String mem) {
		System.out.println("MySQL명령어를 사용해서 " + mem + " 회원추가");
	}
	
	@Override
	public void select(String mem) {
		System.out.println("MySQL명령어를 사용해서 " + mem + " 회원조회");
	}
	
	@Override
	public void update(String mem) {
		System.out.println("MySQL명령어를 사용해서 " + mem + " 회원수정");
	}
	
	@Override
	public void delete(String mem) {
		System.out.println("MySQL명령어를 사용해서 " + mem + " 회원삭제");
	}
	
	@Override
	public void disconn() {
		System.out.println("MySQL db연결 종료...");
	}
}
