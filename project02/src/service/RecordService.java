package service;

import java.util.ArrayList;
import java.util.Scanner;

import dao.RecordDAO;
import dto.RecordDTO;
import dto.RecordDTO;


public class RecordService {
	Scanner scan=new Scanner(System.in);
	RecordDAO rcdao=new RecordDAO();
	
	public void findAll() {
		ArrayList<RecordDTO> list=rcdao.findAll();
		
		System.out.println("[ 주차 전체 기록 ]");
		System.out.println("=========================================");
		for(RecordDTO rcdto:list) {
			System.out.println("기록번호: "+rcdto.getRcid());
			System.out.println("예약번호: "+rcdto.getRvid());
			System.out.println("사용자아이디: "+rcdto.getUsid());
			System.out.println("주차 구역: "+rcdto.getLocation());
			System.out.println("주차 시간: "+rcdto.getStart_time() + " ~ " + rcdto.getEnd_time());
			System.out.printf("총 요금: %.0f원 \n",rcdto.getTotal_fee());
			System.out.println("-----------------------------------------");
		}
	}
	
	public void findByUserId() {
		System.out.println("조회할 사용자아이디");
		String userid=scan.next();
		ArrayList<RecordDTO> list=rcdao.findByUserId(userid);
		
		System.out.println("["+ userid + "님의 주차 기록 ]");
		System.out.println("=========================================");
		for(RecordDTO rcdto:list) {
			System.out.println("기록번호: "+rcdto.getRcid());
			System.out.println("예약번호: "+rcdto.getRvid());
			System.out.println("사용자아이디: "+rcdto.getUsid());
			System.out.println("주차 구역: "+rcdto.getLocation());
			System.out.println("주차 시간: "+rcdto.getStart_time() + " ~ " + rcdto.getEnd_time());
			System.out.printf("총 요금: %.0f원 \n",rcdto.getTotal_fee());
			System.out.println("-----------------------------------------");
		}
	}

}
