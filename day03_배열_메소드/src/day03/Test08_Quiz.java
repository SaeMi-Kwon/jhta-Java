package day03;

/*
 *  문1).
 *  int[][] a= {{1,2,3,0},
 *  			{4,5,6,0},
 *  			{7,8,9,0}};
 *  
 *  위와 같은 배열이 있을때 각 행의 마지막 행의 합을 저장되도록 하고 전체 배열을 출력해 보세요
 *  
 *  [출력결과]
 *  1 2 3 6
 *  4 5 6 15
 *  7 8 9 24
 *  
 */

public class Test08_Quiz {
	public static void main(String[] args) {
		int[][] a= {
					{1,2,3,0},
					{4,5,6,0},
					{7,8,9,0}
				};
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				a[i][3] = a[i][3] + a[i][j];
			}
		}
		
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
			
		
	}
}
