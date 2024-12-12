package day09;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03_Calendar {
	public static void main(String[] args) {
		Calendar c=Calendar.getInstance();  //현재 날짜/시간
		c.set(2020,1,1);   //2020년2월1일에 대한 정보를 갖는 클래스
		System.out.println(c.getTimeInMillis());  //1970년 1월1일 0시0분0초 이후에 발생된 밀리초
		
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH) + 1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year + "년" + month + "월" + day + "일");
		String[] weeks= {"일","월","화","수","목","금","토"};
		int w=c.get(Calendar.DAY_OF_WEEK);  //요일에 대한 정보(일요일:1, ...토요일:7)
		System.out.println(weeks[w-1] +"요일");
		
	
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		Date d=new Date();
		String s1=sf.format(d);
		System.out.println(s1);
		
		
		Calendar c1=Calendar.getInstance();  //현재 날짜/시간정보
		c1.add(Calendar.DAY_OF_MONTH, 30);  //현재 날짜에서 30일 이후의 날짜로 설정
		
		//c1가 갖는 날짜 정보를 SimpleDateFormat를 사용해서 출력될수 있도록 해보세요.
		SimpleDateFormat sf1=new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
		
		//String s2=sf1.format(new Date(c1.getTimeInMillis()));
		String s2=sf1.format(c1.getTime());
		System.out.println(s2);
		
		int lastDay=c1.getActualMaximum(Calendar.DAY_OF_MONTH);  //해당 월의 마지막 날짜 구하기
		System.out.println("해당 달의 마지막 날짜는 " + lastDay + "입니다.");
	}
}
