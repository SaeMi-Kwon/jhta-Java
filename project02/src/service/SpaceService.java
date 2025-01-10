package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.SpaceDAO;
import dto.SpaceDTO;


public class SpaceService {
	Scanner scan=new Scanner(System.in);
	SpaceDAO spdao=new SpaceDAO();

	public void spaceInsert() {
		System.out.println("등록할 번호");
		int sid=scan.nextInt();
		System.out.println("등록할 위치");
		String location=scan.next();
		System.out.println("사용가능여부(Y/N)");
		String useyn=scan.next();
		
		SpaceDTO spdto=new SpaceDTO(sid,location,useyn);
		int n=spdao.insert(spdto);   //SpaceDAO에 insert 호출
		
		if(n>0) {
			System.out.println("주차공간 등록성공!");
		}else {
			System.out.println("주차공간 등록실패!");
		}
	}
	
	public void spaceUpdate() {
		System.out.println("주차공간 번호");
		int sid=scan.nextInt();
		
		System.out.println("위치 변경");
		String location=scan.next();
		System.out.println("사용가능여부 변경(Y/N)");
		String useyn=scan.next();
		
		SpaceDTO spdto=new SpaceDTO(sid,location,useyn);
		int n=spdao.update(spdto);
		
		if(n>0) {
			System.out.println("주차공간 수정성공!");
		}else {
			System.out.println("주차공간 수정실패!");
		}
	}
	
	public void spaceDelete() {
		System.out.println("삭제할 주차공간 번호");
		int sid=scan.nextInt();
		
		int n=spdao.delete(sid);
		
		if(n>0) {
			System.out.println("주차공간 삭제성공!");
		}else {
			System.out.println("주차공간 삭제실패!");
		}
		
	}
	

	public void spaceFindAll() {
		//출력
		ArrayList<SpaceDTO> list=spdao.findAll();
		
		System.out.println("[ 주차 공간 목록 ]");
		System.out.println("====================================");
		for(SpaceDTO spdto:list) {
			System.out.println("주차공간 번호:"+spdto.getSid());
			System.out.println("주차 위치:"+spdto.getLocation());
			System.out.println("사용가능여부:"+spdto.getUseyn());
			System.out.println("-----------------------------------");
		}
	}
	
}
