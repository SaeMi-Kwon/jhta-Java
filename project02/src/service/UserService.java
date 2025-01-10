package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.UserDAO;
import dto.UserDTO;

public class UserService {
	Scanner scan=new Scanner(System.in);
	UserDAO uedao=new UserDAO();
	
	public void userInsert() {
		System.out.println("사용자 아이디");  
		String usid=scan.next();
		System.out.println("사용자 이름");  
		String uname=scan.next();
		System.out.println("연락처");  
		String phone=scan.next();
		System.out.println("차량번호");  
		String car_number=scan.next();
		
		UserDTO uedto=new UserDTO(usid,uname,phone,car_number);
		int n=uedao.insert(uedto);
		
		if(n>0) {
			System.out.println("사용자 등록성공!");
		}else {
			System.out.println("사용자 등록실패!");
		}
	}
	
	public void userUpdate() {
		System.out.println("수정할 사용자 아이디");  
		String usid=scan.next();
		
		System.out.println("연락처 변경");  
		String phone=scan.next();
		System.out.println("차량번호 변경");  
		String car_number=scan.next();
		
		UserDTO uedto=new UserDTO(usid,null,phone,car_number);
		int n=uedao.update(uedto);
		
		if(n>0) {
			System.out.println("사용자 수정성공!");
		}else {
			System.out.println("사용자 수정실패!");
		}
	}
	
	public void userDelete() {
		System.out.println("삭제할 사용자 아이디");  
		String usid=scan.next();
		
		int n=uedao.delete(usid);
		
		if(n>0) {
			System.out.println("사용자 삭제성공!");
		}else {
			System.out.println("사용자 삭제실패!");
		}
	}

	public void userFindAll() {
		//출력
		ArrayList<UserDTO> list=uedao.findAll();
		
		System.out.println("[ 사용자 목록 ]");
		System.out.println("====================================");
		for(UserDTO uedto:list) {
			System.out.println("사용자아이디:" +uedto.getUsid());
			System.out.println("이름:"+uedto.getUname());
			System.out.println("연락처:"+uedto.getPhone());
			System.out.println("차량번호:"+uedto.getCar_number());
			System.out.println("--------------------------------------");
		}
		
		
	}
	
	
}
