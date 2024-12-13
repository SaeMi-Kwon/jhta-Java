package day03;

/*
 * [배열]
 * -같은 자료형의 변수가 여러개 필요한 경우 연속적인 공간에 데이터를 나열해서 저장하고 첨자로 구분하는 자료구조
 * 1) 1차원배열
 * -첨자가 하나인 배열
 * -형식
 * 	자료형[] 배열명=new 자료형[배열크기]
 */

public class Test01_Array {
	public static void main(String[] args) {
		//정수 5개 저장할 배열 생성
		int[] a = new int[5];
		a[0]=100;
		a[1]=50;
		a[2]=80;
		a[3]=90;
		a[4]=70;
		
		for(int i=0;i<5;i++) {
			System.out.println(a[i]);
		}
		
		//배열초기화 하기
		//int[] b = new int[] {100,200,300,400,500};
		int[] b = {1,2,3,4,5};  //new int[] 생략가능
		for(int i=0;i<5;i++) {
			System.out.println(b[i]);
		}
		
	}
}
