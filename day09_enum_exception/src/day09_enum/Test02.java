package day09_enum;

interface MGrade{
	//회원등급
	int GOLD=1;  //public static final 생략가능
	public static final int SILVER=2;
	public static final int BRONZE=3;
}

interface ItemColor{
	//색상
	public static final int RED=1;
	public static final int GOLD=2;
	public static final int GREEN=3;
	public static final int BLUE=4;
	
}

public class Test02 {
	public static void main(String[] args) {
		//int n=MGrade.GOLD;
		int n=ItemColor.GOLD;  //실수로 ItemColor에 GOLD를 사용해도 제대로 작동하기때문에 실수할수있음
		
		switch(n) {
		case MGrade.GOLD: System.out.println("포인트 10000원 적립"); break;
		case MGrade.SILVER: System.out.println("포인트 5000원 적립"); break;
		case MGrade.BRONZE: System.out.println("포인트 1000원 적립"); break;
		}
		
	}
}
