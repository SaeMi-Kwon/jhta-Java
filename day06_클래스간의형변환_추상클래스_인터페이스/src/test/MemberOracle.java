package test;

public class MemberOracle implements MemberDB{
	@Override
	public void conn() {
		System.out.println("오라클 db접속...");
	}
	
	@Override
	public void insert(String mem) {
		System.out.println("오라클명령어를 사용해서 " + mem + " 회원추가");
	}
	
	@Override
	public void select(String mem) {
		System.out.println("오라클명령어를 사용해서 " + mem + " 회원조회");
	}
	
	@Override
	public void update(String mem) {
		System.out.println("오라클명령어를 사용해서 " + mem + " 회원수정");
	}
	
	@Override
	public void delete(String mem) {
		System.out.println("오라클명령어를 사용해서 " + mem + " 회원삭제");
	}
	
	@Override
	public void disconn() {
		System.out.println("오라클 db연결 종료...");
	}
}
