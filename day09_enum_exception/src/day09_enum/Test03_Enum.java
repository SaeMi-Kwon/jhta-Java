package day09_enum;

//enum : 열거형 상수 - jdk1.5버전에서 추가된 기능

//class MyGrade{
//	public static final MyGrade GOLD=new MyGrade();
//	public static final MyGrade SIlVER=new MyGrade();
//	public static final MyGrade BRONZE=new MyGrade();
//	
//}
//class MyColor{
//	public static final MyColor RED=new MyColor();
//	public static final MyColor GOLD=new MyColor();
//}
//--> enum의 위의 클래스와 같은 의미가 된다.

enum MyGrade{
	GOLD,SILVER,BRONZE;
}

enum MyColor{
	GOLD,RED,GREEN,BLUE;
}

public class Test03_Enum {
	public static void main(String[] args) {
		
		MyGrade d1=MyGrade.GOLD;
		//MyGrade d1=MyGrade.GOLD;  //불가능(실수 예방)
		
		//(예외)case절에는 enum타입은 쓰지 않는다.(if에서는 MyGrade.SILVER으로 사용) 
		switch(d1) {   
		case GOLD: System.out.println("포인트 10000원 적립"); break;
		case SILVER: System.out.println("포인트 5000원 적립"); break;
		case BRONZE: System.out.println("포인트 1000원 적립"); break;
		}
		
	}
}
