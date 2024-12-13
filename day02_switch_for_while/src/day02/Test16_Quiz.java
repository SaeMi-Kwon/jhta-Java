package day02;

/*
 * 다중 while 사용해서 구구단을 출력해 보세요
 * 
 -출력결과
 1.
  [2단] 2*1=2 2*2=4 ... 2*9=18
  [3단] 3*1=3           3*9=27
  ..
  [9단] 9*1=9 9*2=18    9*9=81
 
  
 2. 알파벳 출력하기
	A
	AB
	ABC
	ABCD
	ABCDE		
		
 */

public class Test16_Quiz {
	public static void main(String[] args) {
		//문제1
		int i=2;
		
		while(i<=9) {
			System.out.println("["+ i + "단]");
			int j=1;     //j값 초기화
			while(j<=9) {
				System.out.print(i + "*" + j + "=" + (i*j) + " ");
				j++;	
			}
			System.out.println();
			i++;
		}
		
		//문제2
		char a='A';
		
		while(a<='E') {
			char b='A';  // 두번째 while의 b값 초기화
			
			while(b<=a) {  
				System.out.print(b);   //System.out.print(b++);
				b++;
			}
			System.out.println();
			a++;
		}
		
	}
}
