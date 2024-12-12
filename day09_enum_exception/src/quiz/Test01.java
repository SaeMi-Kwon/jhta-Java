package quiz;

import java.util.Calendar;
import java.util.Scanner;

/*
	1. 년도와 월을 입력받아 달력출력하기
	예) 
	년도 : 2010
	월 : 11
	
	---------------------------
	   2010년 11월
	---------------------------
	  일 월 화 수 목 금 토
	      1  2 3  4  5  6
	 ..
 */

public class Test01 {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		
		Calendar c=Calendar.getInstance();
		
		System.out.println("년도 입력");
		int year=scan.nextInt();
		System.out.println("월 입력");
		int month=scan.nextInt();
		
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.MONTH,1);
		
		int lastDay=c.getActualMaximum(Calendar.DAY_OF_MONTH); //마지막 일짜
		
		int week=c.get(Calendar.DAY_OF_WEEK);  //요일에 대한 정보(일요일:1, ...토요일:7)
		
		System.out.println("-------------------------");
		System.out.println("   "+ year + "년" + month +"월");
		System.out.println("-------------------------");
		System.out.println("  일  월  화  수  목   금   토");
		
		
		for (int i = 1; i < week; i++) {
            System.out.print("    ");
        }
		
		for (int i = 1; i <= lastDay; i++) {
			if(i<10) {
				System.out.print(" ");
			}
			System.out.print(" " + i + " ");
			
			if(week%7==0) {
				System.out.println();
			}
			
			week++;
			
			if(week>7) {
				week=1; 
	        }
		}		
			
		System.out.println();
	}
}
