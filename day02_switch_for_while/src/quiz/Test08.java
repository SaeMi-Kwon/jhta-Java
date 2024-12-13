package quiz;

/*
8) for문을 사용해서 아래처럼 출력해 보세요.
System.out.print(" ");
System.out.print("*");

 	     *
 	    **
 	   ***
 	  ****
 	 *****
*/

public class Test08 {
	public static void main(String[] args) {
		
		for(int i=1;i<=5;i++) {
			for(int j=1;j<=(5-i);j++) {   //5-i만큼 공백
				System.out.print(" ");
			}
			for(int star=1;star<=i;star++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}


//선생님 코드
class HW8 {
	public static void main(String[] args) 	{
		for (int i = 5; i>=1 ; i--){
			for (int j = 1; j<i ; j++ ){
				System.out.print(" ");
			}
			for (int k = i; k<=5 ; k++ ){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
