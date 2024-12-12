package day09;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//LocalDateTime : 날짜와 시간에 관련된 정보를 갖는 클래스 -> jdk1.8이상에서 사용가능

public class Test05_LocalDateTime {
	public static void main(String[] args) {
		//public static LocalDateTime now()
		LocalDateTime dt= LocalDateTime.now();  //현재 날짜와 시간에 대한정보를 갖는 객체 얻어오기
		System.out.println(dt);
		System.out.println(dt.getYear() + "년" + dt.getMonthValue() + "월" + dt.getDayOfMonth() + "일");
		
		
		DayOfWeek dw=dt.getDayOfWeek();
		System.out.println(dw.name());
		
		
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  //날짜 포멧형식 설정
		
		LocalDateTime dt2=dt.plusDays(40);  //오늘날짜로부터 40일후의 날짜 얻어오기
		String s2=dt2.format(df);
		System.out.println("40일후:" + s2);
		
		
		//2021년 1월1일 0시0분0초에대한 정보를 갖는 날짜 객체로설정
		LocalDateTime dt1=LocalDateTime.of(2021,1,1,0,0,0);  

		String s=dt1.format(df);
		System.out.println(s);
		
		
	}
}
