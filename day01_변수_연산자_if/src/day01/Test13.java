package day01;
/*
 * <강제형변환>
 * - 데이터형을 강제로 변환하는 것
 * - 형식
 * 	 (바꿀자료형)변수
 * 	 (바꿀자료형)상수
 * 
 * 	예) int a=(int)4.5;
 */
public class Test13 {
	public static void main(String[] args) {
		int a=(int)4.5;   //강제형변환
		System.out.println("a:" + a);
		
		byte b = 100;   //자동형변환
		System.out.println("b:" + b);
		
		int c=b;  //큰 자료형 변수는 작은 자료형 변수값을 저장할 수 있다(자동형 변환됨)
		System.out.println("c:" + c);
		
		byte d = (byte)c;   //작은 자료형 변수는 큰 자료형 변수값을 저장하려면 강제형변환 해야 한다.
		System.out.println("d:" + d);
		
		char ch = 'A';
		System.out.println("ch:" + ch);
		System.out.println("ch:" + (int)ch);
		System.out.println("ch+1:" + (ch+1));  //char+int = int
		
		int e=67;
		char ch1= (char)e;
		System.out.println("ch1:" + ch1);
	}
}
