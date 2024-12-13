package quiz;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//2. 임의의 난수 6개를 발생시켜 배열에 저장하고 출력해 보세요. ( 중복값이 발생되지 않도록 하세요)
//난수의 범위는 1부터 45까지 -> 로또 프로그램(다양하게 만들어 보세요)

public class Test02 {
	public static void main(String[] args) {


		Random rd = new Random();
		Scanner scan = new Scanner(System.in);
		int[] lotto = new int[6];
		int[] inputLotto = new int[6];


		//랜덤 자동생성
		for(int i=0;i<6;i++){
			lotto[i] =rd.nextInt(44)+1;
		}


		//버블정렬
		for(int i=0;i<lotto.length-1;i++){
			for (int j=0;j<lotto.length-1;j++) {
				if (lotto[j]>lotto[j + 1]) {
					int temp = lotto[j];
					lotto[j] = lotto[j + 1];
					lotto[j + 1] = temp;
				}
			}
		}


		System.out.println("로또 출력");
		for(int i=0;i<6;i++) {
			System.out.print(lotto[i] + " ");
		}
		System.out.println();


		//사용자 로또 입력
		System.out.println("사용자 로또 입력");
		for(int i=0;i<6;i++){
			inputLotto[i] = scan.nextInt();
		}
	      
		boolean isPrime = false;
		int cnt=0;
		for(int i=0;i<6;i++){
			if(lotto[i]==inputLotto[i]){
				cnt++;
				isPrime = true;
			}
		}


		if(isPrime){
			System.out.println(cnt+"개 맞췄습니다.");
		}else{
			System.out.println("하나도 맞지 않았습니다.");
		}
	     
	}

}


//선생님 코드	
class HW2 {
	public static void main(String[] args){		
		Random ran=new Random();
		int[] lotto_array=new int[6];
		for(int i=0;i<lotto_array.length;i++){
			lotto_array[i]=ran.nextInt(45)+1;	
			for(int j=0;j<i;j++){
				if(lotto_array[i]==lotto_array[j]){
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto_array);//배열을 정렬하기
		System.out.println("[결과]");
		System.out.println("이번주 로또 번호");
		for(int i=0;i<lotto_array.length;i++){
		System.out.print(lotto_array[i]+" ");		
		}
		System.out.println();
	}
}
