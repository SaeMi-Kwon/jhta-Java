package quiz;

import java.util.Scanner;

//6. 정수를 입력받아 사용자 정의 메소드를 사용해서 절대값을 구해 보세요

public class Test06 {
	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);
       	System.out.println("정수를 입력하세요");
       	int num=scan.nextInt();


       	int abs=getAbs(num);
       	System.out.println(num + "의 절대값: " + abs);
   	}


   	public static int getAbs(int num) {
       		return (num>=0)? num:-num;
   	}
}
