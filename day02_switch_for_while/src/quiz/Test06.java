package quiz;

//6) 1부터 50까지 수 중에서 모든 소수를 출력하세요
//출력결과 > 2 3 5 7 ...  47

public class Test06 {
	public static void main(String[] args) {
		
		for (int i = 2; i <= 50; i++) {
			for (int j = 2; j <= i; j++) {
				if ( i % j == 0) {
					if (i != j) {
						break;
               		}
					System.out.print(i + " ");
				}	
			}
		}
		
	}

}


//선생님 코드
class HW6_1 {
	public static void main(String[] args) 	{
		for(int i=2;i<=50;i++) {
			boolean isPrime = true;
			for (int j = 2 ;j<i ; j++){
				if (i%j==0)	{
					isPrime = false;
					break;
				}
			}
			if (isPrime){
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}


class HW6_2 {
	public static void main(String[] args) 	{
		for(int i=1;i<=50;i++) {
			int cnt=0;
			for (int j = 1 ;j<=i ; j++){
				if (i%j==0)	{ 
					cnt++;//나누어지는 수의 갯수 세기
				}
				if(cnt>2) break;
			}
			if (cnt==2){ //1부터 자기자신까지 나누어봤을때 나누어진 수가 2개(1과 자기자신)인 경우 소수로 출력
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}
}