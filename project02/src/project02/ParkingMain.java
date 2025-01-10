package project02;

import java.util.Scanner;

import service.ReservService;
import service.SpaceService;
import service.UserService;

public class ParkingMain {
	
	public static void main(String[] args) {
		SpaceService spsvc =new SpaceService();
		UserService uesvc=new UserService();
		ReservService rvsvc=new ReservService();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("1.주차공간  2.사용자  3.주차기록  4.주차예약");
		int n=sc.nextInt();
		
		if(n==1) { //주차공간
			System.out.println("1.등록 2.수정 3.삭제 4.전체조회");
			int n1=sc.nextInt();
			if(n1==1) {
				spsvc.spaceInsert();
			}else if(n1==2) {
				spsvc.spaceUpdate();
			}else if(n1==3) {
				spsvc.spaceDelete();   //자식레코드 삭제해야함(변경해야됨) 트리거OR저장프로시져
			}else if(n1==4) {
				spsvc.spaceFindAll();
			}else {
				return;
			}
		}else if(n==2) { //사용자
			System.out.println("1.등록 2.수정 3.삭제 4.전체조회");
			int n1=sc.nextInt();
			if(n1==1) {
				uesvc.userInsert();
			}else if(n1==2) {
				uesvc.userUpdate();
			}else if(n1==3) {
				uesvc.userDelete();  //자식레코드 삭제해야함(변경해야됨)트리거사용
			}else if(n1==4) {
				uesvc.userFindAll();
			}else {
				
			}
			
		}else if(n==3) {  //주차기록 //조인해서 요금계산보여주기(insert자동저장??)
			System.out.println("1.등록 2.전체조회 3.아이디조회");
			int n1=sc.nextInt();
			if(n1==1) {
				
			}else if(n1==2) {
				
			}else if(n1==3) {
				
			}
			
		}else if(n==4) {  //주차예약   트리거사용해야됨
			System.out.println("1.등록 2.시간수정 3.예약상태수정 4.삭제 5.전체조회 6.사용자로 조회");
			int n1=sc.nextInt();
			if(n1==1) {
				rvsvc.reservInsert();
			}else if(n1==2) {
				rvsvc.updateTime();  
			}else if(n1==3) {
				rvsvc.updateStatus();
			}else if(n1==4) {
				rvsvc.reservDelete();
			}else if(n1==5) {
				rvsvc.findAll();
			}else if(n1==6) {
				rvsvc.findByUserId();
			}
			
		}else {
			System.out.println("1~4 중에 선택하세요.");
		}
		
		
	}

}
