package service;

import java.util.Scanner;

import dao.ReservDAO;
import dto.ReservDTO;
import dto.UserReservDTO;




public class ReservService {
	Scanner scan=new Scanner(System.in);
	ReservDAO rvdao=new ReservDAO();
	
	public void reservInsert() {
		System.out.println("예약번호");
		int rvid=scan.nextInt();
		System.out.println("사용자아이디");
		String usid=scan.next();
		System.out.println("주차공간아이디");
		int sid=scan.nextInt();
		System.out.println("예약상태(예정/완료/취소)");
		String status=scan.next();
		
		ReservDTO rvdto=new ReservDTO(rvid,usid,sid,null,null,status);
		
		int n=rvdao.insert(rvdto);
		
		if(n>0) {
			System.out.println("예약등록 성공!");
		}else {
			System.out.println("예약등록 실패!");
		}
	}
	
	
	public void findByUserId() {
		System.out.println("조회할 사용자아이디");
		String usid=scan.next();
		
		
		//UserReservDTO urvdao=rvdao.findByUsid();
	}
}
