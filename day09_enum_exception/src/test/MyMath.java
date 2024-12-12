package test;

public class MyMath {

	//방법1) 예외가 발생될 수 있는 문장들을 직접 try~catch로 처리하기
	public static int div1(int a,int b) {
		try {
			int c=a/b;
			return c;
				
		}catch(ArithmeticException ae) {
			System.out.println("0으로 나눌수 없어요");
			return 0;
			
		}finally {  //return으로 프로그램을 끝내도 finally는 무조건 실행된다.
			System.out.println("finally--> 메소드 수행 완료");
		}
			
	}
	
	
	//방법2) 예외가 발생될 수 있는 문장들을 직접 try~catch로 처리하지 않고 throws로 떠넘기기
	public static int div2(int a,int b) throws ArithmeticException {
		int c=a/b;
		return c;
	}
}

