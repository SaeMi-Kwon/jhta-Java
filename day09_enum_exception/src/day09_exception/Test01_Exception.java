package day09_exception;

import java.util.Scanner;

/*
 * 예외(Exception)
 * - 예외 : 프로그램 실행도중에 발생되는 경미한 에러
 * - 예외처리 : 예외가 발생했을때 이를 적절히 처리하는 것
 * - 형식)
 * 	try{
 * 		예외가 발생될 수 있는 문장;
 * 		..
 * 	}catch(예외타입1 변수){
 * 		예외발생시 처리할 문장;
 * 		...
 * 	}catch(예외타입2 변수){
 * 		예외발생시 처리할 문장;
 * 		...
 * 	}finally{
 * 		예외와 상관없이 무조건 수행해야 할 문장;
 * 		..
 * 	}
 * 	->예외가 발생될 수 있는 문장을 try블록으로 묶고 catch절에서 예외가 발생되었을때에 대한 적절한 처리를 한다.
 * 
 */
public class Test01_Exception {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			System.out.println("첫번째 정수 입력 (종료:0)");
			int n1=scan.nextInt();
			
			if(n1==0) {
				break;
			}
			
			System.out.println("두번째 정수 입력");
			int n2=scan.nextInt();
			
			try {
				int n3=n1/n2;
				System.out.println(n1 + "/" + n2 + "=" + n3);
		
			}catch(ArithmeticException e) {
				System.out.println("에러메시지:" + e.getMessage());
				System.out.println("0으로 나눌수 없어요");
				continue;  
			}

		}	
			
	}
}
