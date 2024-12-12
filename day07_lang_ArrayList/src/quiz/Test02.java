package quiz;

import java.util.ArrayList;
import java.util.Scanner;

/*
	과제2)
	회원관리 기능을 갖는 프로그램 만들어 보세요.
	회원정보 : 아이디,비밀번호,이메일,전화번호
	회원정보를 갖는 클래스를 만들고 ArrayList에 저장하고 아래의 기능을
	작성해 보세요.
	
	회원추가기능
	회원검색기능(아이디로 검색하면 모든 정보 출력)
	회원삭제기능(아이디를 입력하면 해당 정보 삭제) - remove메소드
	회원수정기능(아이디를 입력받아 비밀번호,이메일,전화번호를 수정할 수 
	있도록)- set메소드
	
	==== 화면  ====
	1.회원추가  2.회원검색 3.회원삭제   4.회원수정  5.종료
	원하는 메뉴:1
	[회원추가]
	아이디:__

 */
class Member{
	private String id;
	private String pw;
	private String email;
	private String phoneNum;
	
	public Member(String id,String pw,String email,String phoneNum) {
		this.id=id;
		this.pw=pw;
		this.email=email;
		this.phoneNum=phoneNum;
	}
	
	public String getId() {
		return id;
	}
	
	public void showInfo() {
		System.out.println("아이디:" + id);
		System.out.println("비밀번호:" + pw);
		System.out.println("이메일:" + email);
		System.out.println("전화번호:" + phoneNum);
	}
}


public class Test02 {
	public static void main(String[] args) {
		ArrayList<Member> member=new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		boolean find=false;
		
		while(true) {
			System.out.println("1.회원추가 2.회원검색 3.회원삭제 4.회원수정  5.종료");
			int num=scan.nextInt();
			if(num==1) {//추가
				System.out.println("[회원추가]");
				for(int i=0;i<1;i++) {
					System.out.println("아이디 입력:");
					String id=scan.next();
					System.out.println("비밀번호 입력:");
					String pw=scan.next();
					System.out.println("이메일 입력:");
					String email=scan.next();
					System.out.println("전화번호 입력:");
					String phoneNum=scan.next();
					
					Member mm = new Member(id,pw,email,phoneNum);
				
					member.add(mm);
					
					System.out.println("추가되었습니다.");
				}
				
			}else if(num==2) {//검색
				find=false;
				System.out.println("[회원검색]");
				System.out.println("찾을 아이디:");
				String search=scan.next();
				
				for(int i=0;i<member.size();i++) {
					Member mm=member.get(i);
				
					if(mm.getId().equals(search)) {
						mm.showInfo();
						find=true;
						break;
					}		
				}
				if(!find) {
					System.out.println("검색한 아이디가 없습니다.");
				}
				
			}else if(num==3) {//삭제
				find=false;
				System.out.println("[회원삭제]");
				System.out.println("삭제할 아이디:");
				String del=scan.next();
				
				for(int i=0;i<member.size();i++) {
					Member mm=member.get(i);
					
					if(mm.getId().equals(del)) {
						member.remove(i);
						System.out.println("삭제되었습니다.");
						find=true;
						break;
					}
					
				}
				if(!find) {
					System.out.println("삭제할 아이디가 없습니다.");
				}
				
			}else if(num==4) {//수정
				find=false;
				System.out.println("[회원수정]");
				System.out.println("수정할 아이디:");
				String setId=scan.next();
				
				for(int i=0;i<member.size();i++) {
					Member mm=member.get(i);
					
					if(mm.getId().equals(setId)) {
						System.out.println("비밀번호 변경:");
						String pw=scan.next();
						System.out.println("이메일 변경:");
						String email=scan.next();
						System.out.println("전화번호 변경:");
						String phoneNum=scan.next();
					
						member.set(i,new Member(setId,pw,email,phoneNum));
						System.out.println("변경되었습니다.");
						find=true;
						break;
					}
				}
				if(!find) {
					System.out.println("수정할 아이디가 없습니다.");
				}
				
			}else if(num==5) {
				System.out.println("시스템을 종료합니다");
				return;
				
			}else {
				System.out.println("번호를 다시 입력해주세요.");
			}
		}
	}

}
