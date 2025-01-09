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
		
		if(n==1) {
			System.out.println("1.등록 2.수정 3.전체조회");
			int n1=sc.nextInt();
			if(n1==1) {
				spsvc.spaceInsert();
			}else if(n1==2) {
				spsvc.spaceUpdate();
			}else if(n1==3) {
				spsvc.spaceFindAll();
			}else {
				return;
			}
		}else if(n==2) {
			System.out.println("1.등록 2.수정 3.삭제 4.전체조회");
			int n1=sc.nextInt();
			if(n1==1) {
				uesvc.userInsert();
			}else if(n1==2) {
				uesvc.userUpdate();
			}else if(n1==3) {
				uesvc.userDelete();
			}else if(n1==4) {
				uesvc.userFindAll();
			}else {
				
			}
			
		}else if(n==3) {
			
			
			
		}else if(n==4) {
			System.out.println("1.등록 2.사용자아이디로조회");
			int n1=sc.nextInt();
			if(n1==1) {
				rvsvc.reservInsert();
			}else if(n1==2) {
				rvsvc.findByUserId();
			}
			
		}else {
			System.out.println("잘못선택했습니다.");
		}
		
		
	}

}
