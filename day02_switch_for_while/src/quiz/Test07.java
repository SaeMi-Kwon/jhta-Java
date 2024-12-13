package quiz;

import java.util.Random;
import java.util.Scanner;

/*
7) 가위바위보 게임
예) 가위:1 바위:2 보자기:3
가위바위보를 내세요:1

[결과]
나:가위
컴퓨터:바위
==> 컴퓨터가 이겼습니다.
*/

public class Test07 {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Random rnd = new Random();
		
		while(true) {
			System.out.println("가위:1,바위:2,보:3");
			System.out.print("가위바위보를 내세요:");
			int user=scan.nextInt();
			int com=rnd.nextInt(3)+1;
			
			switch(user) {
				case 1:
					System.out.println("나:가위");
					break;
				case 2:
					System.out.println("나:바위");
					break;
				case 3:
					System.out.println("나:보");
					break;
			}
			
			switch(com) {
			case 1:
				System.out.println("컴퓨터:가위");
				break;
			case 2:
				System.out.println("컴퓨터:바위");
				break;
			case 3:
				System.out.println("컴퓨터:보");
				break;
			}
			
			if(user==com) {
				System.out.println("===> 비겼습니다.");
			}else if((user==1&&com==3)||(user==2&&com==1)||(user==3&&com==2)) {
				System.out.println("===> 사용자가 이겼습니다.");
				break;
			}else {
				System.out.println("===> 컴퓨터가 이겼습니다.");
			}
		}
		
	}
}


//선생님 코드
class HW7 {
	public static void main(String[] args) 	{
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		boolean quit = false;
		while (!quit){
			int com = rnd.nextInt(3)+1;
			System.out.println("가위 : 1, 바위 : 2, 보자기 : 3, 종료 : 4");
			int player = sc.nextInt();
			if (player == 1){
				System.out.println("나 : 가위");
			}
			else if (player == 2){
				System.out.println("나 : 바위");
			}
			else if (player ==3){
				System.out.println("나 : 보자기");
			}
			else {
				break;
			}
			if (com == 1){
				System.out.println("컴퓨터 : 가위");
			}
			else if (com == 2){
				System.out.println("컴퓨터 : 바위");
			}
			else if (com ==3){
				System.out.println("컴퓨터 : 보자기");
			}
			if (com==player) {
				System.out.println("비겼습니다.");
			}else if((player==1&&com==3)||(player==2&&com==1)||(player==3&&com==2)) {
			        System.out.println("당신이 이겼습니다.");
			}else {
			        System.out.println("컴퓨터가 이겼습니다.");		
			}
		}
		System.out.println("종료하엿습니다.");
	}
}

