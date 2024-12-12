package day07;

import java.util.Scanner;

/*
 * 카드번호(String)를 입력받아 출력해 보세요
 * 
 * - 카드번호는 6자리로 이루어짐 length
 * - 카드번호는 모두 숫자로 이루어져야함 chatAt
 * - 카드번호에 -이 들어가면 안됨 indexOf
 * -> 정상적으로 입력되었으면 입력된 카드번호가 출력되고 잘못입력되었으면 오류메시지를 출력하세요
 * 
 * 예)
 * 카드번호 입력: 123456
 * - 입력된 카드번호:123456
 * 
 * 123-45
 * 
 * - 하이픈이 입력되면 안됩니다.
 * 
 * 1234!
 * - 카드번호는 모두 숫자로 입력해 주세요.
 */
public class Test04_Quiz {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("카드번호 입력:"); //123-45
		String cardNum =scan.next();
		
		boolean error=false;
		
		//public int length()
		if(cardNum.length()!=6) {
			System.out.println("카드번호를 6자리로 입력해 주세요");
			error=true;
		}
		
		for(int i=0;i<6;i++) {		
			//public char charAt(int index)
			char c = cardNum.charAt(i);	
			if(!(c>='0' && c<='9')) {
				System.out.println("카드는 숫자로 입력해 주세요");
				error=true;
				break;
			}
		}
		
		//public int indexOf(String str)
		int index1=cardNum.indexOf("-");
		int index2=cardNum.indexOf("!");
		
		if(index1!=-1) {
			System.out.println("하이픈이 입력되면 안됩니다.");
			error=true;
		}
	
		if(index2!=-1) {
			System.out.println("카드번호는 모두 숫자로 입력해주세요");
			error=true;
		}
		
		if(!error) {
			System.out.println("입력된 카드번호:" + cardNum);
		}
		
	}
}
