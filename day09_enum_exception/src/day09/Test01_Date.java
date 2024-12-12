package day09;

import java.util.Date;

public class Test01_Date {
	public static void main(String[] args) {
		Date d=new Date();
		System.out.println(d);
		long time=d.getTime(); //1970년 1월1일 0시0분0초 이후에 발생된 밀리초(1초=1000)
		System.out.println(time);
		
		Date d1=new Date(time);
		System.out.println(d1);
		
		//public static long currentTimeMillis()
		long time1=System.currentTimeMillis();  //1970년 1월1일 0시0분0초 이후에 발생된 밀리초(1초=1000)
		System.out.println("time1:" + time1);
	}
}
