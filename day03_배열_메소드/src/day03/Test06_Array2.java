package day03;

/*
 * <2차원 배열>
 * -첨자가 두개인 배열
 * -예)
 * int[][] a = new int[3][4]; -> 3행 4열로 배열방이 12개 만들어짐
 * 
 */

public class Test06_Array2 {
	public static void main(String[] args) {
		int[][] a = {
				{1,2,3},
				{4,5,6},
				{7,8,9},
				{10,11,12}
			};
		
		for(int i=0;i<4;i++) {  //행 
			for(int j=0;j<3;j++) {  //열
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("배열 행의 크기:" + a.length);
		System.out.println("배열 열의 크기:" + a[0].length);
		
		
		for(int i=0;i<a.length;i++) {  //행 
			for(int j=0;j<a[i].length;j++) {  //열
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
