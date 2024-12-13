package day02;

import java.util.Random;
import java.util.Scanner;

public class Test10_for {
	public static void main(String[] args) {
		Random rnd=new Random();  //난수를 발생시키는 객체
		
		for(int i=1;i<=5;i++) {
			//int n=rnd.nextInt();   //난수발생
			int n=rnd.nextInt(10);  //0부터 9사이의 난수 발생
			System.out.println(n);
		}
		
		
		Scanner scan = new Scanner(System.in);
		int r = rnd.nextInt(10)+1;
		int inputCnt=0;   //입력횟수
		for(;;) {	//무한루프
			System.out.println("예상되는 숫자 입력하세요");
			int num=scan.nextInt();
			inputCnt++;
			if(r==num) {
				System.out.println("숫자를 맞추셨습니다!!!");
				System.out.println("입력횟수:" + inputCnt);
				break;
			}else {
				System.out.println("맞지 않는 숫자입니다.");
			}
		}
		
	}
}
