package quiz;

//3) 1부터 100까지 수중 3의 배수의 갯수를 출력해 보세요.
//결과:3의배수 갯수:XX개

public class Test03 {
	public static void main(String[] args) {
		int count=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0) {
				count++;
			}
		}
		System.out.println("3의 배수 갯수:" + count + "개");
	}

}
