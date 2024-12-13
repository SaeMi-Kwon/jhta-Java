package quiz;

import java.util.Scanner;

/*
문제1)
사원번호,이름,부서,본봉,수당을 입력받아 출력하는 클래스를 만들어 보세요.
급여는 본봉+수당

	[출력결과]
	사원번호:10
	이름:홍길동
	부서:영업부
	본봉:1000000
	수당: 500000
	급여:1500000 만원

*/
class Employee{
	private int num; //사원번호
	private String name;  //이름
	private String dept; //부서
	private int salary; //본봉
	private int bonus;  //수당
	private int pay; //급여

	   //입력 메소드
	public void input() {
		Scanner scan=new Scanner(System.in);

		System.out.print("사원번호입력:");
		num=scan.nextInt();
		System.out.print("이름입력:");
	    name=scan.next();
	    System.out.print("부서입력:");
	    dept=scan.next();
	    System.out.print("본봉입력:");
	    salary=scan.nextInt();
	    System.out.print("수당입력:");
	    bonus=scan.nextInt();
	}

	   //급여계산 메소드
	public int getPay() {
		return salary+bonus;
	}

	   //출력 메소드
	public void showInfo() {
		System.out.println("[출력결과]");
		System.out.println("사원번호:" + num);
	    System.out.println("이름:" + name);
	    System.out.println("부서:" + dept);
	    System.out.println("본봉:" + salary);
	    System.out.println("수당:" + bonus);
	    System.out.println("급여:" + getPay() + "만원");
	}
}
public class Test01 {
	public static void main(String[] args) {
		Employee e=new Employee();
		e.input();
		e.showInfo();
	}

}
