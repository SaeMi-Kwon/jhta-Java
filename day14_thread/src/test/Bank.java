package test;

public class Bank {
	private String account;  //계좌번호
	private long money;  //잔고
	
	public Bank(String account,long money) {
		this.account=account;
		this.money=money;
	}
	
	//방법2)
	public synchronized void deposit(long m) {
		//시간지연 for문
		for(int i=0;i<1000000;i++) {
			for(int j=1;j<500000;j++);
			if(i%100000==0) System.out.println("입금 처리중.....");
		}
		//--------------------------------------------------------
		
		money += m;	
		System.out.println("입금완료!!");
		info();
	}
	
	//방법2)
	public synchronized void withdraw(long m) {
		if(money<=0) {
			System.out.println("잔고부족");
			return;
		}
		
		//시간지연 for문
		for(int i=0;i<1000000;i++) {
			for(int j=1;j<500000;j++);
			if(i%100000==0) System.out.println("출금중.....");
			}
		for(int j=1;j<50000;j++);
		//--------------------------------------------------------
		
		money -= m;
		System.out.println("출금완료!!");
		info();
	}
	
	public void info() {
		System.out.println("계좌번호:" + account);
		System.out.println("잔액:" + money);
	}
	
	public String getAccount() {
		return account;
	}
	
	public long getMoney() {
		return money;
	}
	
	public String setAccount(String a) {
		return this.account=a;
	}
	
	public long setMoney(long m) {
		return this.money=m;
	}
}
