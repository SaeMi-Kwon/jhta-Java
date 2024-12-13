package day04;

/*
 * 학생성적처리 클래스
 * 
 * 멤버변수 - 학생번호,국어점수,수학점수,총점
 * 멤버메소드 - 값입력,성적계산(총점),데이터출력
 * 
 */

import java.util.Scanner;

class Student{
	private int num; //학생번호
	private int kor;
	private int math;
	private int tot;
	
	//데이터 입력받기
	public void input() {
		Scanner scan = new Scanner(System.in);
		System.out.println("학생번호 입력");
		num=scan.nextInt();  //this.num=scan.nextInt();(this생략되어있다)
		
		System.out.println("국어점수 입력");
		kor=scan.nextInt();
		
		System.out.println("수학점수 입력");
		math=scan.nextInt();
	}
	
	//성적 계산하기
	public void calc() {
		tot=kor+math;
	}
	
	//데이터 출력하기
	public void print() {
		System.out.println("학생정보출력");
		System.out.println("학생번호:" + num);
		System.out.println("국어점수:" + kor);
		System.out.println("수학점수:" + math);
		System.out.println("총점:" + tot);
	}
}

public class Test02 {
	public static void main(String[] args) {
		//Student객체를 생성해서 데이터 저장하고 출력되도록 코드를 작성해 보세요.
		Student std1 = new Student();
		std1.input();
		std1.calc();
		std1.print();
		
		Student std2 = new Student();
		std2.input();
		std2.calc();
		std2.print();
		
	}
}
