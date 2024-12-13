package day15_thread;

class MyThread extends Thread{
	
	public MyThread(String name) {  //스레드 이름 전달하기
		super(name); 
	}
	
	@Override
	public void run() {
		exec1();
		exec2();
		exec3();
	}
	public void exec1() {
		System.out.println(getName() + "스레드 실행중1...");
	}
	public void exec2() {
		System.out.println(getName() + "스레드 실행중2...");
	}
	public void exec3() {
		System.out.println(getName() + "스레드 실행중3...");
	}
}

public class Test03_join {
	public static void main(String[] args) {
		MyThread thread1=new MyThread("스레드1");
		MyThread thread2=new MyThread("스레드2");
		
		thread1.setPriority(Thread.MAX_PRIORITY); //우선순위 부여하기 : MAX_PRIORITY 가장 높은 순위
		thread1.setPriority(Thread.MIN_PRIORITY); //우선순위 부여하기 : MIN_PRIORITY 가장 낮은 순위
		
		thread1.start();
		thread2.start();

		try {
			thread1.join(); 
			thread2.join();  //스레드가 종료될때까지 부모(메인)스레드가 기다림
			
		}catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		
		System.out.println("메인스레드 종료...");
	}
}
