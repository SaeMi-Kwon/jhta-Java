package day09_enum;

enum MyWeek{
	SUN("일요일"),MON("월요일"),TUE("화요일"),WEB("수요일"),THU("목요일"),FRI("금요일"),SAT("토요일");
	
	private String weekname;
	//enum은 생성자를 갖을수 있다.(private로 만들어야 함)
	private MyWeek(String weekname) {
		this.weekname=weekname;
	}
	
	public String getWeekname() {
		return weekname;
	}
}

public class Test04 {
	public static void main(String[] args) {
		MyWeek w=MyWeek.SUN;
		System.out.println("name:" + w.name());
		System.out.println("ordinal:" + w.ordinal());  //열거 타입의 몇 번째 위치인지 반환(ordinal() 대신 인스턴스 필드를 사용)
		System.out.println("weekname:" + w.getWeekname());
	}
}
