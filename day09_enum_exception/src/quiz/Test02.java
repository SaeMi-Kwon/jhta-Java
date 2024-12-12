package quiz;

import java.util.Scanner;

/*
	2. 5명 학생들의 신장을 입력받아 신장의 평균을 구해서 출력해 보세요.
		(예외가 발생된다면 적절한 예외처리를 해보세요.)
	  
		입력형식은 아래와 같다.
	  
		5명학생의 신장을 ,로 구분해서 입력해 주세요.
		190,160,150,170,180
	  
		결과
		평균신장:xxx
 */

public class Test02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("5명의 학생의 신장을 , 로 구분해서 입력해 주세요.");
		try {
			String s=scan.next();
		
			//public String[] split(String regex)
			String[] arr=s.split(",");
		
			int[] newArr=new int[arr.length];
		
			double sum=0;
			double avg=0;
			for(int i=0;i<arr.length;i++) {
				newArr[i]=Integer.parseInt(arr[i]);
				sum+=newArr[i];
			}
			avg=sum/newArr.length;

			System.out.println("평균신장:" + avg);
			
		}catch(NumberFormatException e) {
			System.out.println(e.getMessage());
			System.out.println(" , 를 제외한 문자열을 입력했습니다.");
		}
		
	}
}

