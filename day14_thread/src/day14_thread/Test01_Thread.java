package day14_thread;

/*
 * [ 스레드 ]
 * - 하나의 응용프로그램에서 여러개의 작업을 경량의 프로세스로 나누어서 실행하는 것
 * - 시간이 오래 지연되는 작업이나 동시에 실행되어야 하는 작업이 있을때 스레드로 만든다
 *  예)
 *  - 동시에 파일 다운로드하기
 *  - 게임프로그램에서 이미지를 동시에 따로 움직이기
 * 	...
 * - 스레드 만드는 방법
 *  방법1) Thread클래스를 상속받아 만들기
 *  방법2) Runnable인터페이스를 상속받아 만들기
 */



public class Test01_Thread {
	public static void main(String[] args) {
		//파일 복사
		filecopy();
		//파일 인쇄
		print();
	}
	
	public static void filecopy() {
		for(int i=1;i<=1000;i++) {
			System.out.print("파일복사중!!");
			if(i%10==0) System.out.println();
		}
		System.out.println("<<<< 파일복사완료 >>>>");
	}
	
	public static void print() {
		for(int i=1;i<=1000;i++) {
			System.out.print("파일인쇄중@@");
			if(i%10==0) System.out.println();
		}
		System.out.println("&&&& 파일복사완료 &&&&");
	}
}
