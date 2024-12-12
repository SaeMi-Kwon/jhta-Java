package day09_enum;

class MyBirth{
	private int y;
	private int m;
	private int d;
	
	//태어난 요일
	private MyWeek week;
	
	public MyBirth(int y,int m,int d,MyWeek w) {
		this.y=y;
		this.m=m;
		this.d=d;
		this.week=w;
	}
	
	public void print() {
		System.out.println("생년월일:" + y + "년" + m + "월" +d + "일");
		System.out.println("태어난 요일:" + week.getWeekname());
	}
	
}

public class Test05 {
	public static void main(String[] args) {
		MyBirth mb=new MyBirth(2024,1,1,MyWeek.SUN); 
		mb.print();
	}
}
