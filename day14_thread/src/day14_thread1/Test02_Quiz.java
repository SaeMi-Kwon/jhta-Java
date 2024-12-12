package day14_thread1;
/*
 * < 덧셈계산 프로그램 >
 * 임의의 난수를 두개 더해서 맞추는 프로그램
 * 시간은 60초가 주어진다.(스레드로 시간체크하기)
 */

import java.util.Random;
import java.util.Scanner;

class RandomNum implements Runnable{
	static int count=0;
	
	@Override
	public void run() {
		Random r=new Random();
		Scanner scan=new Scanner(System.in);	
		
		while(true) {
			int n1=r.nextInt(10);
			int n2=r.nextInt(10);
			int n3=n1+n2;
					
			System.out.println(n1+ "+" + n2 + "=");
			int result=scan.nextInt();
		
			if(result==n3) {
				count++;
				System.out.println("정답입니다. 맞은 갯수:" + count);
			}
		}
	}
}

class TimeAttack implements Runnable{
	
	@Override
	public void run() {
		int cnt=0;
	
		while(true){
			cnt++;
		
			if(cnt%10==0) {
				System.out.println((60-cnt) + "초 남았습니다");
			}
			
			try {
				Thread.sleep(1000);	
				
			} catch (InterruptedException ei) {
				System.out.println(ei.getMessage());
			}
			
			if(cnt==60) {
				System.out.println("게임이 종료됩니다.");
				System.out.println("최종 맞은 갯수:" + RandomNum.count);
				System.exit(0);
			}
		}
	
	}
}

public class Test02_Quiz {
	public static void main(String[] args) {
		//new Thread(new RandomNum()).start();
		//익명의 내부 클래스로 바꿔서 실행해 보세요.
		
		new Thread(new RandomNum() {
			static int count=0;
			@Override
			public void run() {
				Random r=new Random();
				Scanner scan=new Scanner(System.in);	
				
				while(true) {
					int n1=r.nextInt(10);
					int n2=r.nextInt(10);
					int n3=n1+n2;
							
					System.out.println(n1+ "+" + n2 + "=");
					int result=scan.nextInt();
				
					if(result==n3) {
						count++;
						System.out.println("정답입니다. 맞은 갯수:" + count);
					}
				}
			}
		}).start();
		
		
		new Thread(new TimeAttack()).start();
	}
}
