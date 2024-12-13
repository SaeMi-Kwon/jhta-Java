package day01;
/*
 *  [대입연산자]
 *  연산자           의미
 *  ---------------------
 *  a+=b           a=a+b
 *  a-=b		   a=a-b
 *  a*=b	       a=a*b
 *  a/=b	       a=a/b
 *  
 */
public class Test12 {
	public static void main(String[] args) {
		int a=3, b=4, c=5, d=6;
		a+=5;	//a=a+5
		b-=5;	//b=b-5
		c*=2;   //c=c*2
		d/=3;	//d=d/3
		
		System.out.println("a:" + a);
		System.out.println("b:" + b);
		System.out.println("c:" + c);
		System.out.println("d:" + d);
	}
}
