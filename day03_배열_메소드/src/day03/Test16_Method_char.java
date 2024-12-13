package day03;

import java.util.Scanner;

public class Test16_Method_char {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("글자 하나만 입력하세요");
		String str=scan.next();
		char ch=str.charAt(0); //str문자열에서 첫번째 글자 하나 꺼내오기
		
		//isUpper 메소드를 완성해 보세요.
		if(isUpper(ch)==true) {
			System.out.println("대문자입니다.");
		}else {
			System.out.println("대문자가 아닙니다.");
		}
	}
	
	
	public static boolean isUpper(char ch) {
		for(char i='A';i<='Z';i++) {
			if(ch == i) {
				return true;
			}
		}
		return false;
	}
	
//	if(ch>='A'&& ch<='Z') {
//		return true;
//	}
//	return false;
}
