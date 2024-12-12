package day14_thread1;

import java.util.Scanner;

import test.Bank;
/*
 * Bank클래스를 만드세요
 * Bank클래스
 * - 계좌번호/잔액
 * - 입금메소드/출금메소드
 * 
 * - 입금스레드 -> Bank객체의 입금메소드 호출
 * - 출금스레드 -> Bank객체의 출금메소드 호출
 * 
 * 위의 작업을 하는 프로그램을 작성해 보세요
 */

class BankInput extends Thread{
	Bank bank;
	
	public BankInput(Bank bank) {
		this.bank=bank;
	}
	public void run() {
		//방법1)
		//synchronized (bank) {
			bank.deposit(10000);  //입금하기
		//}
			
	}
	
}

class BankOutput extends Thread{
	Bank bank;
	
	public BankOutput(Bank bank) {
		this.bank=bank;
	}
	public void run() {
		//방법1)
		//synchronized (bank) {
			bank.withdraw(20000);  //출금하기
		//}
	};
}

public class Test07_스레드동기화 {
	public static void main(String[] args) {
		Bank bank=new Bank("1234567", 100000);
		
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("1.입금  2.출금  3.종료");
			int n=scan.nextInt();
			switch(n) {
			case 1: new BankInput(bank).start();
				break;
			case 2: new BankOutput(bank).start();
				break;
			case 3: System.exit(0);
			}
		}

		
		
	}
}
