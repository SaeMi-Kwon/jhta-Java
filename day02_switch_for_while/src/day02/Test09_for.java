package day02;

//for 문의 여러행태
//break: for문을 강제로 빠져나감

public class Test09_for {
	public static void main(String[] args) {
		char a='A';  //초기식
		for(;a<='Z';) {
			System.out.print(a + " ");
			a++;      //증감식
		}
		System.out.println();
		
		
		char b='a';  //초기식
		for(;;) {   //무한루프
			System.out.print(b + " ");
			b++;    //증감식
			if(b>'z') {    //조건식
				break;   //for문을 빠져나감
			}
		}
		
		
	}
}
