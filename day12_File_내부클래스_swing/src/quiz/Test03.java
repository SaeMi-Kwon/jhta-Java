package quiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Scanner;

/*
	3. 
	- 회원아이디/비밀번호 파일로 저장하기
	- 회원아이디를 입력받아 비밀번호 조회하기
 */

//  아이디 입력하면 비번이 딱하고 나옴
public class Test03 {
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);
			HashMap<String,String> hm=new HashMap<>();
			BufferedWriter br= new BufferedWriter(new FileWriter("user.txt",true));
			
			while(true) {
				System.out.println("1.아이디,비밀번호 파일로 저장  2.비밀번호 조회  3.종료");
				int num=scan.nextInt();
				
				if(num==1) {
					System.out.println("아이디를 입력");
					String key=scan.next();
					System.out.println("비밀번호를 입력");
					String value=scan.next();
				
					if(hm.containsKey(key)) {
						System.out.println("해당 아이디가 존재합니다.");
						return;  //메소드끝내기
					}
					hm.put(key,value);
					br.write(key + " " + value + "\n");
					br.flush();
					System.out.println("회원등록 완료!");
					
					
				}else if(num==2) {
					System.out.println("[회원조회]");
					System.out.println("조회할 id 입력:");
					String s =scan.next();
		
					String pwd=hm.get(s);
					if(pwd != null) {
						System.out.println("비밀번호:" + pwd);
					}else {
						System.out.println("해당 아이디가 존재하지 않습니다");
					}
					
				}else if(num==3) {
					System.out.println("프로그램 종료");
					br.close();
					return;
				}else {
					System.out.println("번호를 다시 입력해주세요.");
				}
			}
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		
		}

	}
	
}
