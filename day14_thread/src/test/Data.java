package test;


//공유자원
public class Data {
	private int[] b=new int[100];
	
	public void setData(int a,int i) {
		if(i>=b.length) return;
		b[i]=a;
	}
	public int[] getB() {
		return b;
	}
	
	
}
