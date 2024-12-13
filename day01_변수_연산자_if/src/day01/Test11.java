package day01;

public class Test11 {
	public static void main(String[] args) {
		int a=5, b=5, c=5;
		int d = ++a + b;  //  11=6+5 
		int e = b-- + 10; //  15= 5+10   -> b=4
		int f = c++ + b;  //  9= 5+4     -> c=6
		System.out.println("a:" + a);    //6
		System.out.println("b:" + b);    //4
		System.out.println("c:" + c);    //6
		System.out.println("d:" + d);    //11
		System.out.println("e:" + e);    //15
		System.out.println("f:" + f);    //9
		
	}
}
