package day02;

/*
 * 1부터 100까지 수를 출력하세요.
 * 단 한줄에 10개씩 출력하세요.
 * 
 * -> do~while문 사용
 * 
 */

public class Test18_Quiz {
	public static void main(String[] args) {
		
		int i=1;
		
		do {
			System.out.print(i + " ");
			
			if(i%10==0) {
				System.out.println();
				}
			
			i++;
			
		}while(i<=100);
		
	}
}
