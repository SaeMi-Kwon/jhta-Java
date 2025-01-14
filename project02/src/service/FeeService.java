package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.FeeDAO;
import dto.FeeDTO;


public class FeeService {
	Scanner scan=new Scanner(System.in);
	FeeDAO fdao=new FeeDAO();
	
	public void feeInsert() {
		System.out.println("요금입력");
		Double fee=scan.nextDouble();
		
		int n=fdao.insert(fee);
		
		if(n>0) {
			System.out.println("요금 등록성공!");
		}else {
			System.out.println("요금 등록실패!");
		}
		
	}
	
	public void feeUpdate() {
		System.out.println("수정할 요금아이디번호");
		int fid=scan.nextInt();
		
		System.out.println("요금 변경");
		Double fee=scan.nextDouble();
		
		int n=fdao.update(fid,fee);
		
		if(n>0) {
			System.out.println("요금 변경성공!");
		}else {
			System.out.println("요금 변경실패!");
		}
		
		
	}
	
	public void feeDelete() {
		System.out.println("삭제할 요금번호");
		int fid=scan.nextInt();
		
		int n=fdao.delete(fid);
		
		if(n>0) {
			System.out.println("요금 삭제성공!");
		}else {
			System.out.println("요금 삭제실패!");
		}
		
	}
	
	public void findAll() {
		ArrayList<FeeDTO> list=fdao.findAll();
		
		System.out.println("[ 요금 조회 ]");
		System.out.println("================================");
		for(FeeDTO fdto:list) {
			System.out.println("요금 번호: "+fdto.getFid());
			System.out.printf("시간당 요금: %.0f원 \n", fdto.getHourly_rate());
			System.out.println("----------------------------------------");
		}
		
	}
	
}

