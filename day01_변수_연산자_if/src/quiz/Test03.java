package quiz;

import java.util.Scanner;
/*
 * 
	3. 키와 몸무게를 입력받아 비만도 측정프로그램 작성해 보세요.

	- 표준 몸무게 구하는 법 
	키 151 이상일 경우: (키－100)×0.9
	키 150 이하일 경우: (키－100) 

	- 비만도 구하는 법
	현재 몸무게 ÷ 표준 몸무게 ×100

	- 비만도
	90 미만= 저체중
	90~110  = 정상체중
	110~120 =과체중
	120 이상 = 비만

 */
public class Test03 {
	public static void main(String[] argos){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("키 입력:");
		double height = scan.nextDouble();
		System.out.print("몸무게 입력:");
		double weight = scan.nextDouble();

		double bmi=0;

		if(height>=151) {
			double normal=(height-100)*0.9;
			bmi= weight/normal*100;
		}else {
			double normal=(height-100);
			bmi=weight/normal*100;
		}


		if(bmi < 90) {
			System.out.println("저체중");
		}else if(bmi < 110 ) {
			System.out.println("정상체중");
		}else if(bmi < 120) {
			System.out.println("과체중");
		}else if(bmi >= 120) {
			System.out.println("비만");
		}
		
	}
}
