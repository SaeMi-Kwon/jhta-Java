package day14_thread1;

import test.Data;
/*
 * [ 스레드의 동기화 ]
 * - 하나의 객체(공유자원)을 여러개의 스레드가 공유해서 사용할때 하나의 스레드가 사용중이면 다른 스레드는
 *   사용할 수 없으면 잠금(lock)인 상태가 되는 것
 *   
 * - 동기화처리방법
 *  방법1) 동기화할 객체에 synchronized블록으로 묶기
 *  	synchronized(공유객체){
 *  	..
 *  
 *  	}
 *  
 *  방법2) 동기화할 클래스 자체에서 synchronized메소드 만들기
 *  	public synchronized 리턴형 메소드명(...){
 *  		..
 *  	}
 *  
 */

class InputThread1 extends Thread{
	Data data;
	public InputThread1(Data data) {
		this.data=data;
	}
	
	@Override
	public void run() {
		//방법1)
		synchronized (data) {
			for(int i=0;i<100;i++) {
				for(int j=1;j<10000000;j++); //=for(int j=1;j<10000;j++){} : 단순히 시간지연하는역할
				data.setData(i+1, i);
			}
		}
		
	}
}

class OutputThread1 extends Thread{
	Data data;
	public OutputThread1(Data data) {
		this.data=data;
	}
	
	
	@Override
	public void run() {
		//방법1)
		synchronized (data) {
			int[] b=data.getB();
			for(int i=0;i<b.length;i++) {
				System.out.print(b[i] + " ");
				if((i+1)%10==0) System.out.println();
			}
			System.out.println();
		}
		
	}
}
 
public class Test06_스레드동기화 {
	public static void main(String[] args) {
		Data data=new Data();
		new InputThread1(data).start();
		new OutputThread1(data).start();
	}
}
