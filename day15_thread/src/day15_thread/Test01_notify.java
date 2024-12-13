package day15_thread;
import test.Data;

//스레드간의 상호통신 : notify(),wait()
//연결(연관)된 관계에 사용
class InputThread extends Thread{
	Data data;
	
	public InputThread(Data data) {
		this.data=data;
	}
	
	@Override
	public void run() {
		synchronized (data) {
			for(int i=0;i<100;i++) {
				for(int j=1;j<=10000;j++);
				data.setData(i+1, i);
			}
			data.notify(); //wait로 대기하는 스레드에게 신호보내기
			data.setStatus(true);  //작업이 끝났다는 표시 -> notify했음
		}
	}
}

class OutputThread extends Thread{
	Data data;
	
	public OutputThread(Data data) {
		this.data=data;
	}
	
	@Override
	public void run() {
		synchronized (data) {
			try {
				if(data.getStatus()==false) {  //다른스레드가 notify하기 전인 상태 -> 이때에만 wait가 걸려야함
					data.wait();  //notify로 신호가 올때까지 대기
				}
			}catch(InterruptedException ie) {
				System.out.println(ie.getMessage());
			}
			
			int[] b=data.getB();
			for(int i=0;i<b.length;i++) {
				System.out.print(b[i] + " ");
				if((i+1)%10==0) System.out.println();
			}
			System.out.println();
		}
	}
}
public class Test01_notify {
	public static void main(String[] args) {
		Data data=new Data();
		while(true) {
			new InputThread(data).start();
			new OutputThread(data).start();
		}
	
	}
}
