package day03;

/*
 *  문2).
 *  int[][] a = {{1,2,3},
 *  			 {4,5,6},
 *               {7,8,9},
 *               {0,0,0}};
 *               
 * -> 마지막 행에 각 열의 합이 저장되도록 하고 전체 배열을 출력해 보세요
 * [출력결과]
 * 1  2  3
 * 4  5  6
 * 7  8  9
 * 12 15 18
 * 
 */

public class Test09_Quiz {
	public static void main(String[] args) {
		
		int[][] a = {
						{1,2,3},
						{4,5,6},
						{7,8,9},
						{0,0,0}
			    	};
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				a[3][i] = a[3][i] + a[j][i];
			}
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
}
