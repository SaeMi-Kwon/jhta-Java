package day09;

import java.util.Calendar;

/*
 * Calendar 
 * - 현재 날짜와 시간에 대한 정보을 갖는 클래스
 * - 추상클래스라서 객체를 생성할 수는 없지만 getInstance메소드를 사용해서 Calendar객체를 얻어와 사용할 수 있다.
 * 
 *  //public static Calendar getInstance()
 *    Calendar calendar = Calendar.getInstance();
 */
public class Test02_Calendar {
	public static void main(String[] args) {
		Calendar c1 = Calendar.getInstance();
		System.out.println(c1);
		
		c1.set(Calendar.YEAR, 2023);   //날짜 변경을 설정
		
		//public int get(int field)
		int year=c1.get(Calendar.YEAR);
		int month=c1.get(Calendar.MONTH)+1;  //MONTH는 1월이 0부터 시작됨
		int date=c1.get(Calendar.DATE);  //c1.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "년" + month + "월" + date + "일");
		
		int d=c1.get(Calendar.DAY_OF_WEEK);
		System.out.println(d);
		
		switch(d) {
		case Calendar.SUNDAY: System.out.println("일요일"); break;  //1
		case Calendar.MONDAY: System.out.println("월요일"); break;  //2
		case Calendar.TUESDAY: System.out.println("화요일"); break;
		case Calendar.WEDNESDAY: System.out.println("수요일"); break;
		case Calendar.THURSDAY: System.out.println("목요일"); break;
		case Calendar.FRIDAY: System.out.println("금요일"); break;
		case Calendar.SATURDAY: System.out.println("토요일"); break;
		}
		
		//현재 시간 출력해 보세요.(시 분 초)
		Calendar c2 = Calendar.getInstance();
		
		int ap=c2.get(Calendar.AM_PM);
		if(ap==Calendar.AM) {   //0
			System.out.print("오전 ");
		}else if(ap==Calendar.PM){  //1
			System.out.print("오후 ");
		}
		
		int hour=c2.get(Calendar.HOUR);  //12시간단위
		//int hour=c2.get(Calendar.HOUR_OF_DAY);  //24시간단위
		int minute=c2.get(Calendar.MINUTE);
		int second=c2.get(Calendar.SECOND);
		System.out.println(hour + "시" + minute + "분" + second + "초");
		
	}

}
