package day07;
/*
 * StringBuffer
 * - String클래스는 문자열을 조작할때 복사본을 생성후 조작함-> 원본 문자열은 변경되지 않으며
 *   문자열조작이 많으면 메모리를 많이 사용한다.
 * - StringBuffer클래스는 문자열을 조작할때 원본 문자열을 조작함-> 원본 문자열이 변경되며
 *   문자열조작이 많으면 String클래스보다 메모리를 적게 사용한다.
 */
public class Test02_String_Buffer {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("aaa");
		
		//public StringBuffer append(String str)
		StringBuffer s1=sb.append("bbb");  //문자열 연결
		System.out.println("s1:" + s1);
		System.out.println("sb:" + sb);  //원본 문자열이 변경됨
		
		//public String[] split(String regex)
		String s5="홍길동,이길동,삼길동";
		String[] s6=s5.split(",");  // ","를 기준으로 문자열을 쪼개서 배열에 담아 리턴
		for(int i=0;i<s6.length;i++) {
			System.out.println(s6[i]);
		}
	}
}
