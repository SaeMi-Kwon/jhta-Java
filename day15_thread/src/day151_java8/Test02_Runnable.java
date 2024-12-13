package day151_java8;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Test02_Runnable {
	public static void main(String[] args) {
		//스레드 시간 출력하기 -> Runnable인터페이스 사용(익명의 내부클래스사용) -> 람다식으로 바꿔보기
		
		//내부익명클래스 만들기
		Runnable runnable=new Runnable() {
			@Override
			public void run() {
				while(true) {
					DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy/MM/dd a HH:mm:ss");
					String str=LocalDateTime.now().format(f);
					System.out.println(str);
					try {
						Thread.sleep(1000);
					}catch(InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				}
			}
		};
		new Thread(runnable).start();
		
		
		//람다식
		Runnable r=()->{
			while(true) {
				DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy/MM/dd a HH:mm:ss");
				String str=LocalDateTime.now().format(f);
				System.out.println(str);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ie) {
					System.out.println(ie.getMessage());
				}
			}
		};
		new Thread(r).start();
		
		
		
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy/MM/dd a HH:mm:ss");
					String str=LocalDateTime.now().format(f);
					System.out.println(str);
					try {
						Thread.sleep(1000);
					}catch(InterruptedException ie) {
						System.out.println(ie.getMessage());
					}
				}
			}
		}).start();
		
		
		
		//람다식 	축약
		new Thread(()->{
			while(true) {
				DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy/MM/dd a HH:mm:ss");
				String str=LocalDateTime.now().format(f);
				System.out.println(str);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ie) {
					System.out.println(ie.getMessage());
				}
			}
		}).start();
		
	}
}
