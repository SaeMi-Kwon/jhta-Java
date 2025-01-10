package service;


import java.util.ArrayList;
import java.util.Scanner;
import dao.ReservDAO;
import dto.ReservDTO;


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
		System.out.println("예약 시작시간(예:25/01/01 12:00)");
		scan.nextLine();
		String start=scan.nextLine();
		System.out.println("예약 종료시간(예:25/01/01 13:00)");
		String end=scan.nextLine();
		System.out.println("예약상태(예정/완료/취소)");
		String status=scan.next();
		
		ReservDTO rvdto=new ReservDTO(rvid,usid,sid,start,end,status);
		
		int n=rvdao.insert(rvdto);
		
		if(n>0) {
			System.out.println("예약 등록성공!");
		}else {
			System.out.println("예약 등록실패!");
		}
	}
	
	public void updateTime() {
		System.out.println("수정할 예약번호");
		int rvid=scan.nextInt();
		
		System.out.println("예약 시작시간(예:25/01/01 12:00)");
		scan.nextLine();
		String start=scan.nextLine();
		System.out.println("예약 종료시간(예:25/01/01 13:00)");
		String end=scan.nextLine();
		
		ReservDTO rvdto=new ReservDTO(rvid,null,-1,start,end,null);
		
		int n=rvdao.updateTime(rvdto);
		
		if(n>0) {
			System.out.println("예약시간 수정성공!");
		}else {
			System.out.println("예약시간 수정실패!");
		}
	}
	
	public void updateStatus() {
		System.out.println("수정할 예약번호");
		int rvid=scan.nextInt();
		
		System.out.println("예약상태 변경(예정/완료/취소)");
		String status=scan.next();
		
		int n=rvdao.updateStatus(rvid, status);
		
		if(n>0) {
			System.out.println("예약상태 수정성공!");
		}else {
			System.out.println("예약상태 수정실패!");
		}
		
	}
	
	
	public void reservDelete() {
		System.out.println("삭제할 예정번호");
		int rvid=scan.nextInt();
		
		int n=rvdao.delete(rvid);
		
		if(n>0) {
			System.out.println("예약 삭제성공!");
		}else {
			System.out.println("예약 삭제실패!");
		}
		
	}
	
	public void findAll() {
		//출력
		ArrayList<ReservDTO>list=rvdao.findAll();
		
		System.out.println("[ 예약 전체목록 ]");
		System.out.println("====================================");
		for(ReservDTO rvdto:list) {
			System.out.println("예약번호:"+rvdto.getRvid());
			System.out.println("사용자아이디:"+rvdto.getUsid());
			System.out.println("주차공간번호:"+rvdto.getSid());
			System.out.println("예약 시간:"+rvdto.getStart_time() + " ~ " + rvdto.getEnd_time());
			System.out.println("예약 상태:"+rvdto.getStatus());
			System.out.println("--------------------------------------------");
		}
		
	}
	
	public void findByUserId() {
		System.out.println("조회할 사용자아이디");
		String userid=scan.next();
		
		ArrayList<ReservDTO>list=rvdao.findByUsid(userid);
		System.out.println( "["+userid+"님의 예약 목록 ]");
		System.out.println("====================================");
		for(ReservDTO rvdto:list) {
			System.out.println("예약번호:"+rvdto.getRvid());
			System.out.println("사용자아이디:"+rvdto.getUsid());
			System.out.println("주차공간번호:"+rvdto.getSid());
			System.out.println("예약 시간:"+rvdto.getStart_time() + " ~ " + rvdto.getEnd_time());
			System.out.println("예약 상태:"+rvdto.getStatus());
			System.out.println("--------------------------------------------");
		}
		
	}
	
	
}
