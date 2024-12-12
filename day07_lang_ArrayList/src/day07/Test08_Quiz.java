package day07;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 학생이름을 입력받아 ArrayList에 저장하고
 * 저장된 전체 이름을 출력하세요
 * 이름저장은 exit가 입력될때까지 반복한다.
 * 
 * ->제너릭 사용
 */
public class Test08_Quiz {
	public static void main(String[] args) {
		ArrayList<String> name = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("학생이름 입력:");
			String n=scan.next();
			
			if(n.equals("exit")) {
				break;
			}
			
			name.add(n);
		}
		
		System.out.println("==학생 전체이름==");
		for(int i=0;i<name.size();i++) {
			String s=name.get(i);
			System.out.println(s);
		}
		
	}
}
