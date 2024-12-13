package day03;

public class Test15_Method_Array {
	public static void main(String[] args) {
		int[] a= {10,20,30,40,50};
		int sum=getSum(a);
		System.out.println("배열합:" + sum);
		
		//배열값중 가장 큰값을 메소드를 사용해서 구해 보세요.
		int max=getMax(a);
		System.out.println("배열값중 가장 큰값:" + max);
		
		printArray(a);
		
	}
	
	public static int getSum(int[] b) {
		int sum=0;
		for(int i=0;i<b.length;i++) {
			sum += b[i];
		}
		return sum;
	}
	
	public static int getMax(int[] a) {
		int max=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>max) {
				max = a[i];
			}
		}
		return max;
	}
	
	//리턴문이 없으면 리턴형을 void로 적는다
	public static void printArray(int[] a) {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
}
