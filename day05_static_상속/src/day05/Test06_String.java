package day05;

public class Test06_String {
	public static void main(String[] args) {
		//String 클래스
		String s1="Hello";
		//public int length()
		int a=s1.length();
		System.out.println("문자열의 길이:" + a);
		
		//public char charAt(int index)
		char b=s1.charAt(0);
		System.out.println("0번째 문자:" + b);
		
		//public String toUpperCase() 메소드를 사용해서 Hello을 대문자로 출력해 보세요.
		String c=s1.toUpperCase();
		System.out.println("대문자출력:" + c);
		
		//public String substring(int beginIndex)   //인덱스(0부터시작)
		String st =s1.substring(1);  //1번째 위치부터 문자열 끝까지 추출하기
		System.out.println(st);  //ello
		
		String s2="Hello World!!!!";
		//public String substring(int beginIndex,int endIndex)  //마지막인덱스 포함안됨(0부터시작)
		String st2=s2.substring(6, 11);
		System.out.println(st2);
		
		//public String(byte[] bytes)
		byte[] bb= {65,66,67,68,69};
		String e=new String(bb);
		System.out.println(e); //ABCDE
		
		//public String(char[] value,int offset,int count)
		//위의 생성자를 사용해서 ello만 String으로 생성해서 출력되도록 해보세요.
		char[] ch= {'H','e','l','l','o'};
		String h=new String(ch,1,4);
		System.out.println(h);
		
		String s3="java-spring-jpa";
		//public int indexOf(String str) : str문자열이 발생된 위치값 리턴. 없으면 -1리턴
		int n=s3.indexOf("spring");
		System.out.println(n);  //"spring" 위치값 5
		
		int n1=s3.indexOf("html");
		System.out.println(n1);  //-1
		
		char[] ch1= {'H','e','l','l','o'};
		//public static String valueOf(char[] data)
		//->valueOf메소드를 사용해서 ch1을 String으로 만들어서 출력해 보세요.
		String s4=String.valueOf(ch1);
		System.out.println(s4);
		
		//Math 클래스
		//public static final double PI
		System.out.println(Math.PI);
		
		//public static double abs(double a)
		//메소드를 사용해서 절대값을 구해 보세요.
		System.out.println(Math.abs(-20.86));
	}

}
