package day08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/*
 * 회원아이디를 입력받아 HashSet에 저장하고 전체 데이터를 출력해 보세요
 * 회원아이디는 exit를 입력하면 입력이 종료된다.
 */
public class Test03_Quiz {
	public static void main(String[] args) {
		HashSet<String> idList=new HashSet<>();
		
		Scanner scan = new Scanner(System.in);
		
		
		while(true) {
			System.out.println("아이디 입력:");
			String id=scan.next();
			
			//public boolean contains(Object o)  //존재(포함)여부 파악 메소드
			boolean b=idList.contains(id);
			if(b) {
				System.out.println("이미 존재하는 아이디입니다");
				continue;
			}
			
			if(id.equals("exit")) {
				System.out.println("입력완료!");
				break;
			}
			idList.add(id);
		}
	
		Iterator<String> getId = idList.iterator();
		
		System.out.println("==전체 아이디 출력==");
		while(getId.hasNext()) {
			String n= getId.next();
			System.out.println(n);
		}
		
	}
}
