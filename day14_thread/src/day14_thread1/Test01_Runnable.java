package day14_thread1;

import day14_thread.Test04_FileThread;

class FileCopyThread implements Runnable{  //class AA extends Frame implements Runnable{} (다중상속을 사용하기위해 사용)
	@Override
	public void run() {
		for(int i=1;i<=1000;i++) {
			System.out.print("파일복사중!!");
			if(i%10==0) System.out.println();
		}
		System.out.println("<<<< 파일복사완료 >>>>");
	}
}

//인쇄하는 스레드 만들고 실행해 보세요 -> Runnable 상속받아 구현
class PrintThread implements Runnable{
	@Override
	public void run() {
		for(int i=1;i<=1000;i++) {
			System.out.print("파일인쇄중@@");
			if(i%10==0) System.out.println();
		}
		System.out.println("&&&& 파일인쇄완료 &&&&");
	}
}

public class Test01_Runnable {
	public static void main(String[] args) {
		FileCopyThread copyThread=new FileCopyThread();
		
		//public Thread(Runnable target) --> Thread생성자
		Thread thread1=new Thread(copyThread);
		thread1.start();
		
		
		//한줄로 축약
		new Thread(new PrintThread()).start();
	}
}
