package day08;

class Data<T>{
	private T a;
	public Data() {}
	public Data(T a) {
		this.a=a;
	}
	public void setA(T a) {
		this.a=a;
	}
	public T getA() {
		return a;
	}
}

class MyArray<T>{
	private T[] a;
	public MyArray(T[] a) {
		this.a=a;
	}
	public void print() {
		for(int i=0;i<a.length;i++) {
			T b=a[i];
			System.out.print(b + " ");
		}
		System.out.println();
	}
}

public class Test12_generic {
	public static void main(String[] args) {
		Data<String> d1=new Data<String>();
		d1.setA("hello");
		String s=d1.getA();
		System.out.println(s);
		
		Data<Integer> d2=new Data<Integer>(100);
		Integer s1=d2.getA();
		System.out.println(s1);
		
		String[] ss=new String[] {"hello","1234","good"};  //String[] ss={"hello","1234","good"};
		MyArray<String> arr1=new MyArray<>(ss);
		arr1.print();
		
		MyArray<Integer> arr2=new MyArray<>(new Integer[] {1,2,3});
		arr2.print();
	}
}
