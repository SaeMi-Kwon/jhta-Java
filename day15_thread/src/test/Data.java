package test;

//공유자원
public class Data {
	private int[] b=new int[100];
	private boolean status=false;
	
	public void setData(int a,int i) {
		if(i>=b.length) return;
		b[i]=a;
	}
	public int[] getB() {
		return b;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status=status;
	}
	
}
