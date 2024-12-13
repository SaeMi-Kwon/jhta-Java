package day03;

import java.util.Scanner;

/*
 * 아이디를 입력받아 해당회원의 이름과 전화번호가 출력되도록 해보세요
 * 
 * 예)
 * 조회할 아이디입력
 * user1
 * 
 * <조회된 결과>
 * 아이디: user1
 * 이름: 이자바
 * 전화번호: 010-444-2222
 * 
 * -> 검색된 회원아이디가 없으면
 * <조회된 결과>
 * 해당 아이디가 존재하지 않습니다.
 * 
 */

public class Test11_String {
	public static void main(String[] args) {
		String[][] users= {
								{"admin","김관리","010-111-1234"},
								{"hello","김헬로","010-222-0000"},
								{"test","나회원","010-333-1111"},
								{"user1","이자바","010-444-2222"},
						   };
		
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(users[i][j]+ " ");
			}
			System.out.println();
		}
			
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("조회할 아이디입력");
		String inputId =scan.next();
		
		boolean find=false;   
		
		for(int i=0;i<users.length;i++) {
				if(users[i][0].equals(inputId)) {
					System.out.println("아이디:" +users[i][0]);
					System.out.println("이름:" +users[i][1]);
					System.out.println("전화번호:" +users[i][2]);
					find = true;
					break;
				}					
			}
		
		if(!find) {
			System.out.println("해당 아이디가 존재하지 않습니다.");
		}
	
		
		
	}
}
