package quiz;

import java.util.Scanner;

/*

2. 보너스를 지급하려고한다. 근무시간과 본봉을 입력받아
 근무시간에 따라 보너스를 계산하여 본봉과 합하여 출력하는 프로그램을 작성
	--------------------------------------------
	근무시간           보너스
	--------------------------------------------

	25시간이상         본봉의 100%  
	20시간이상         본봉의 80%
	18시간이상         본봉의 50%
	18시간미만         없음
	---------------------------------------------
	[출력결과]
	근무시간입력:20
	본봉입력:1000000
	===============
	보너스:800000
	지급될 급여:1800000
	출력해 보세요.

*/
public class Test02 {
	public static void main(String[] argos){
		Scanner scan = new Scanner(System.in);

		System.out.print("근무시간입력:");
		int work = scan.nextInt();


		System.out.print("본봉입력:");
		int salary = scan.nextInt();
		System.out.println("================");
		
		
		double bonus = 0;
		if(work>=25){
			bonus = salary;
		}else if(work>=20) {
			bonus = salary*0.8;
		}else if(work>=18) {
			bonus = salary*0.5;
		}else{
			bonus = 0;
		}

		System.out.println("보너스:" + (int)bonus);
		System.out.println("지급될 급여:" + (salary+(int)bonus));
	}
}
