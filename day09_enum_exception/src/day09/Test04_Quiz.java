package day09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

//자신의 생년월일을 입력받아 태어난 요일을 출력해 보세요
public class Test04_Quiz {
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("태어난 년도 입력:");
		int y=scan.nextInt();
		System.out.println("태어난 월 입력:");
		int m=scan.nextInt();
		System.out.println("태어난 일 입력:");
		int d=scan.nextInt();
		
		Calendar cal= Calendar.getInstance();
		cal.set(y,m-1,d);
		
		int w=cal.get(Calendar.DAY_OF_WEEK);
		String[] w1= {"일","월","화","수","목","금","토"};
		
		System.out.println("당신이 태어난 요일은 [" + w1[w-1] + "요일] 입니다.");
		
	}
}
