package day09_enum;

public class Test01_Enum {
	//회원등급
	public static final int GOLD=1;
	public static final int SILVER=2;
	public static final int BRONZE=3;
	

	public static void main(String[] args) {
//		int n1=1;  //회원등급
//		
//		switch(n1) {
//		case 1: System.out.println("포인트 10000원 적립"); break;
//		case 2: System.out.println("포인트 5000원 적립"); break;
//		case 3: System.out.println("포인트 1000원 적립"); break;
//		}
		// ---> 코드 파악이 어렵다
		
		
		int n1=GOLD;  //회원등급
		
		switch(n1) {
		case GOLD: System.out.println("포인트 10000원 적립"); break;
		case SILVER: System.out.println("포인트 5000원 적립"); break;
		case BRONZE: System.out.println("포인트 1000원 적립"); break;
		}
		
		
	}
}
