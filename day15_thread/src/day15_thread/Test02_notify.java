package day15_thread;

import java.util.Scanner;

import test.Restaurant;

class CookThread extends Thread{
	Restaurant res;
	String food;
	
	public CookThread(Restaurant res,String food) {
		this.res=res;
		this.food=food;
	}
	@Override
	public void run() {
		synchronized (res) {
			res.cooking(food);
			res.notify();
		}
	}
}

//주문한 음식을 서빙하는 스레드를 완성해 보세요
//wait하다가 notify가 오면 serving하기
class ServeThread extends Thread{
	Restaurant res;
	
	public ServeThread(Restaurant res) {
		this.res=res;
	}
	
	@Override
	public void run() {
		synchronized (res) {
			try {
				//if(res.getStatus()==false) 
				if(!res.getStatus())	
					res.wait();
			} catch (InterruptedException e) {
					System.out.println(e.getMessage());
			}
			res.serving();
		}
	}
}

public class Test02_notify {
	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
			
		while(true) {
			System.out.println("1.주문  2.영업종료");
			int n=scan.nextInt();
			switch(n) {
			case 1:
				System.out.println("주문할 음식");
				String food=scan.next();
				Restaurant res=new Restaurant();
				new CookThread(res,food).start();
				new ServeThread(res).start();
				break;
			case 2: System.exit(0);
			}
		}

	}
}
