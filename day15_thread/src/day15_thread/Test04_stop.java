package day15_thread;

class MyThread1 extends Thread {
	private boolean stop=false;
	
	public void setStop(boolean stop) {
		this.stop=stop;
	}
	
	public void run() {
		while(stop==false) {
			System.out.println("1.스레드로 작업중...");
			System.out.println("2.스레드로 작업중...");
			System.out.println("3.스레드로 작업중...");
			System.out.println("4.스레드로 작업중...");
			System.out.println("5.스레드로 작업중...");
			System.out.println("6.스레드로 작업중...");
			System.out.println("작업완료!!");
		}
	
	}
}

public class Test04_stop {
	public static void main(String[] args) {
		MyThread1 t=new MyThread1();
		t.start();
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException ie) {
			System.out.println(ie.getMessage());
		}
		t.setStop(true);
	}
}
