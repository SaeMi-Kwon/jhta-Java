package day03;

import java.util.Scanner;

public class Test05_String {
	public static void main(String[] args) {
		String[] users = new String[] {"hello","test","abcd","blue"};
		//String[] users = {"hello","test","abcd","blue"};
		
		System.out.println("배열에 저장된 아이디");
		for(int i=0;i<users.length;i++) {
			System.out.println(users[i]);
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("사용할 아이디 입력하세요");
		String id = scan.next();
		boolean using = false; //사용중인지에 대한 상태 저장
		
		for(int i=0;i<users.length;i++) {
			if(id.equals(users[i])) {  //입력한id와 배열에 저장된id가 같은게 있는지 비교
				using=true;
				break;   //이미 같은게 있으면 더 이상 비교할 필요가 없으니 빠져나온다.
			}
		}
		
		if(using) {
			System.out.println("사용중인 아이디입니다");
		}else {
			System.out.println("사용가능한 아이디입니다");
		}
	}
}
