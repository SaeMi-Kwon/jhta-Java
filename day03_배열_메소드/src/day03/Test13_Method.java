package day03;
/*
 * [사용자 정의 메소드]
 * -어떠한 기능을 갖는 코드의 묶음
 * -형식)
 * 		리턴형 메소드명(매개변수,...){
 * 			실행문장;
 * 			..
 * 			[return]
 * 		}
 * 
 */
public class Test13_Method {
	public static void main(String[] args) {
		int a=10;
		int b=20;
		int c=sum(a,b);
		System.out.println("두수 합:" + c);
		
	}
	
	public static int sum(int x,int y) { //사용자 정의 메소드
		int c=x+y;
		return c;  //리턴은 호출한 자리에 c값을 보내준다
	}
}
