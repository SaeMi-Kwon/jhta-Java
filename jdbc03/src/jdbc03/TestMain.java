package jdbc03;

import java.util.ArrayList;
import java.util.Scanner;

import test.dto.MembersDAO;
import test.dto.MembersDTO;

public class TestMain {

	static Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("1.회원가입 2.전체조회 3.회원삭제 4.회원수정" +
					" 5.회원조회(회원번호) 6.회원조회(이름) 7.종료");
		
		int n=scan.nextInt();
		switch(n) {
			case 1: insert(); break;
			case 2: selectAll(); break;
			case 3: delete(); break;
			case 4: update(); break;
			case 5: findNum(); break;
			case 6: findName(); break;
			
		}
	}
	
	public static void insert() {
		System.out.println("가입할 회원번호");
		int num=scan.nextInt();
		System.out.println("가입할 회원이름");
		String name=scan.next();
		System.out.println("전화번호");
		String phone=scan.next();
		System.out.println("주소");
		String addr=scan.next();
		
		//DB에 저장
		MembersDAO dao=new MembersDAO();
		MembersDTO dto=new MembersDTO(num,name,phone,addr,null); //db에 저장할 정보를 dto에 담기
		int n=dao.insert(dto);
		
		if(n>0) {
			System.out.println("회원등록 성공!");
		}else {
			System.out.println("오류로 인해 회원등록 실패!");
		}
			
	}
	
	public static void selectAll() {
		MembersDAO dao=new MembersDAO();
		ArrayList<MembersDTO> list=dao.selectAll();
		
		//출력
		System.out.println("[ 전체 회원 목록 ]");
		System.out.println("-------------------------------------");
		for(MembersDTO dto:list) {
			System.out.println("회원번호:" + dto.getNum());
			System.out.println("이름:" + dto.getName());
			System.out.println("전화번호:" + dto.getPhone());
			System.out.println("주소:" + dto.getAddr());
			System.out.println("가입일:" + dto.getRegdate());
			System.out.println("-------------------------------------");
		}
		
	}
	
	//회원번호 입력받아 회원삭제
	public static void delete() {
		System.out.println("삭제할 회원번호");
		int num=scan.nextInt();
		
		MembersDAO dao=new MembersDAO();
		int n=dao.delete(num);
		
		if(n>0) {
			System.out.println("회원삭제 성공!");
		}else {
			System.out.println("오류로 인해 회원삭제 실패!");
		}
	}
	
	//회원수정하기 (번호 입력받아 전화번호,주소 수정하기)
	public static void update() {
		System.out.println("수정할 회원번호");
		int num=scan.nextInt();
		
		System.out.println("전화번호 변경");
		String phone=scan.next();
		System.out.println("주소 변경");
		String addr=scan.next();
		
		MembersDAO dao=new MembersDAO();
		MembersDTO dto=new MembersDTO(num,null,phone,addr,null);  //장바구니
		int n=dao.update(dto);
		
		if(n>0) {
			System.out.println("회원수정 완료!");
		}else {
			System.out.println("오류로 인해 회원수정 실패!");
		}
		
	}
	
	//회원번호로 회원조회하기
	public static void findNum() {
		System.out.println("조회할 회원번호");
		int num=scan.nextInt();
		
		MembersDAO dao=new MembersDAO();
		MembersDTO dto1=dao.findNum(num);

		//출력
		if(dto1!=null) {
			System.out.println("[회원 조회]");
			System.out.println("회원번호:" + dto1.getNum());
			System.out.println("이름:" + dto1.getName());
			System.out.println("전화번호:" + dto1.getPhone());
			System.out.println("주소:" + dto1.getAddr());
			System.out.println("가입일:" + dto1.getRegdate());
		}else {
			System.out.println("회원번호로 회원조회 실패!");
		}
	}
	
	
	public static void findName() {
		System.out.println("조회할 회원이름");
		String name=scan.next();
		
		MembersDAO dao=new MembersDAO();
		ArrayList<MembersDTO> list=dao.findName(name);
		
		//출력
		if(list.size()>0) {
			System.out.println("[회원 조회]");
			for(MembersDTO dto:list) {
				System.out.println("회원번호:" + dto.getNum());
				System.out.println("이름:" + dto.getName());
				System.out.println("전화번호:" + dto.getPhone());
				System.out.println("주소:" + dto.getAddr());
				System.out.println("가입일:" + dto.getRegdate());
				System.out.println("-------------------------------------");
			}
			
		}else {
			System.out.println("조회된 정보가 없습니다.");
		}
		
	}
	
	
}
