package day07;

public class Test01_String {
	public static void main(String[] args) {
		String s1="Hello";
		String s2="Hello";
		if(s1==s2) {  //같은 문자열 상수(리터럴)를 참조하면 s1과 s2의 참조 주소값은 같다.
			System.out.println("1.두 문자열은 같아요");
		}else {
			System.out.println("2.두 문자열은 달라요");
		}
		
		String s3=new String("Hello");
		String s4=new String("Hello");
		if(s3==s4) {  //두 객체의 주소값을 비교하므로 다르다라고 출력됨
			System.out.println("두 문자열은 같아요");
		}else {
			System.out.println("두 문자열은 달라요");
		}
		
		//public String concat(String str) : 문자열 연결
		String s=s3.concat("World!!!");
		System.out.println("s:" + s);
		System.out.println("s3:" + s3);  //원본문자열은 변경 안됨
	}
}
