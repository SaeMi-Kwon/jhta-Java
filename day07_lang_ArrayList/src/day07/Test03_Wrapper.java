package day07;
/*
 * Wrapper 클래스
 * -> 기본자료형을 클래스로 포장해 놓은 것
 * 
 * int    -> Integer
 * double -> Double
 * char   -> Character
 * ...
 * 
 */
public class Test03_Wrapper {
	public static void main(String[] args) {
		
		//Integer클래스
		//public static final int MAX_VALUE
		int n1=Integer.MAX_VALUE;
		int n2=Integer.MIN_VALUE;
		System.out.println(n1 + "," + n2);
		
		//public static int parseInt(String s)
		String s="100";
		//parseInt메소드 사용해서 s를 int값으로 얻어와 출력해 보세요.
		int n3=Integer.parseInt(s);
		System.out.println(n3);
		
		//public static String toBinaryString(int i) 
		//-> 메소드를 사용해서 100의 이진수(문자열)을 출력해 보세요
		int n4=100000;
		String s2=Integer.toBinaryString(n4);
		System.out.println("100000의 이진수값==>"+s2);
		
		//public static String toHexString(int i)
		String s3=Integer.toHexString(n4);
		System.out.println("100000의 16진수값==>"+s3);
		
		Integer n5=100; //가능(오토박싱)
//		int a=n5.intValue();
		int a=n5;  //가능(언박싱)
		System.out.println(a);
		
		//Double클래스
		//public static double parseDouble(String s)
		String s4="100.56";  //-->double 값 얻어와 출력해 보세요
		double d=Double.parseDouble(s4);
		System.out.println(d);
		
	}
}
