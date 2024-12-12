package day12;

//추상메소드를 딱 하나만 갖는 인터페이스- 함수형인터페이스
@FunctionalInterface   //함수형인터페이스인지 체크하는 어노테이션
interface Vehicle{ //탈 것
	void drive();
}

interface Message{
	void sendMsg(String msg); //메시지 보내기
	void recMsg(String msg); //메시지 받기
}

public class Test12_Quiz {
	public static void main(String[] args) {
		//Vehicle를 익명의 내부클래스로 구현하고 적절히 메소드를 오버라이딩하고 사용해 보세요
		new Vehicle() {
			public void drive() {
				System.out.println("부릉부릉");
			};
		}.drive();
		
		//Message를 익명의 내부클래스로 구현하고 적절히 메소드를 오버라이딩하고 사용해 보세요.
		Message mg=new Message() {
			public void sendMsg(String msg) {
				System.out.println( "[" + msg +"]메시지를 보냈어요");
			}
			public void recMsg(String msg) {
				System.out.println( "[" + msg + "]메시지를 받았어요");
			}
		};
		mg.sendMsg("안녕");
		mg.recMsg("바이");

	}
}
