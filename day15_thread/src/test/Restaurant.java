package test;

public class Restaurant {
	private String food;
	private boolean status=false;
	
	public void cooking(String food) {
		this.food=food;
		
		// --------------------------------------------------------
		//동기화가 되는지 확인하기 위해 시간을 지연시키는 for문
		for(int i=0;i<=500000000;i++) {
			for(int j=1;j<=100;j++);
			if(i%100000000==0) System.out.println(food + "만드는중....");
		}
		// -------------------------------------------------------
		
		for(int i=1;i<=500000;i++) ;
			System.out.println(food + "요리 완료");
			status=true;
	}	
	
	public void serving() {
		System.out.println(food + "요리 서빙 완료!!");
	}
		
	public boolean getStatus() {
		return status;
	}
	
}
