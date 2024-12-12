package day14_thread1;

import test.Data;

class InputThread extends Thread{
	Data data;
	public InputThread(Data data) {
		this.data=data;
	}
	
	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			for(int j=1;j<10000000;j++); //=for(int j=1;j<10000;j++){} : 단순히 시간지연하는역할
			data.setData(i+1, i);
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
		int[] b=data.getB();
		for(int i=0;i<b.length;i++) {
			System.out.print(b[i] + " ");
			if(i%10==0) System.out.println();
		}
		System.out.println();
	}
}

public class Test05_자원공유 {
	public static void main(String[] args) {
		Data data=new Data();
		new InputThread(data).start();
		new OutputThread(data).start();
	}
}
