package project02;

import java.util.InputMismatchException;
import java.util.Scanner;

import service.FeeService;
import service.RecordService;
import service.ReservService;
import service.SpaceService;
import service.UserService;

public class ParkingMain {
	
	public static void main(String[] args) {
		SpaceService spsvc =new SpaceService();
		UserService uesvc=new UserService();
		ReservService rvsvc=new ReservService();
		FeeService fs=new FeeService();
		RecordService rcsvc=new RecordService();
		
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("1.주차공간  2.사용자  3.주차기록  4.주차예약  5.요금설정");
			int n=sc.nextInt();
			
			if(n==1) { //주차공간
				System.out.println("1.등록 2.수정 3.삭제 4.전체조회");
				int n1=sc.nextInt();
				if(n1==1) {
					spsvc.spaceInsert();
				}else if(n1==2) {
					spsvc.spaceUpdate();     
				}else if(n1==3) {
					spsvc.spaceDelete();  
				}else if(n1==4) {
					spsvc.spaceFindAll();
				}
				
			}else if(n==2) { //사용자
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
				}
				
			}else if(n==3) {  //주차기록 
				System.out.println("1.전체조회 2.사용자로 조회");
				int n1=sc.nextInt();
				if(n1==1) {
					rcsvc.findAll();
				}else if(n1==2) {
					rcsvc.findByUserId();
				}
				
			}else if(n==4) {  //주차예약  
				System.out.println("1.등록 2.수정 3.삭제 4.조회");
				int n1=sc.nextInt();
				if(n1==1) {  
					rvsvc.reservInsert();
					
				}else if(n1==2) {
					System.out.println("1.시간수정 2.예약상태수정");
					int n2=sc.nextInt();
					if(n2==1) {   
						rvsvc.updateTime(); 
					}else if(n2==2) {
						rvsvc.updateStatus();
					}
					
				}else if(n1==3) {
					System.out.println("1.예약번호 삭제 2.'취소'삭제");
					int n2=sc.nextInt();
					if(n2==1) { 
						rvsvc.DeleteId();
					}else if(n2==2) {
						rvsvc.DeleteCancel();
					}
					
				}else if(n1==4) {
					System.out.println("1.전체조회 2.사용자로 조회");
					int n2=sc.nextInt();
					if(n2==1) {  
						rvsvc.findAll();
					}else if(n2==2) {
						rvsvc.findByUserId();
					}
				}
		
			}else if(n==5) {  //요금설정
				System.out.println("1.등록 2.수정 3.삭제 4.조회");
				int n1=sc.nextInt();
				if(n1==1) {
					fs.feeInsert();
				}else if(n1==2) {
					fs.feeUpdate();
				}else if(n1==3) {
					fs.feeDelete();
				}else if(n1==4) {
					fs.findAll();
				}
				
			}else {
				System.out.println("1~5 중에 선택하세요.");
			}
			
		}catch(InputMismatchException ime) {
			System.out.println("숫자를 입력하세요.");
		}
		
	}	

}
