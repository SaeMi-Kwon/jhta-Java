package day02;

/*
다중 for문을 사용해서 아래처럼 출력되도록 해보세요

*****
****
***
**
*

2. 구구단 출력하기
-----------------------------
[2단] 2*1=2 2*2=4 ... 2*9=18
[3단] 3*1=3           3*9=27
..
[9단] 9*1=9 9*2=18    9*9=81
------------------------------

2*1=2  3*1=3 ...........9*1=9
2*2=4  3*2=9 ...........9*2=18
....
2*9=18..................9*9=81

*/

public class Test08_Quiz {
	public static void main(String[] args) {
		//1.문제
		for(int i=1;i<=5;i++) {
			
			for(int j=5;j>=i;j--) {   //for(int j=i;j<=5;j++){
				
				System.out.print("*");
			}
			
			System.out.println();
		}
		System.out.println();
		
		//2.문제
		for(int i=2;i<=9;i++) {
			System.out.print("[" + i + "단] ");
			for(int j=1;j<=9;j++) {
				System.out.print( i + "*" +j + "=" + (i*j) + " ");
			}
			
			System.out.println();
		}
		System.out.println();
		
		
		
		for(int i=1;i<=9;i++) {
			for(int j=2;j<=9;j++) {
				System.out.print( j + "*" + i + "=" + (i*j) + " ");
			
			}
			System.out.println();
		}
		System.out.println();
		
		
		/*
		 3. 알파벳 출력하기
		 A
		 AB
		 ABC
		 ABCD
		 ABCDE
		 
		 */
		
		for(char i='A';i<='E';i++) {
			for(char j='A';j<=i;j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		
	}

}

