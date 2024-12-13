package quiz;

import java.util.Scanner;

/*
 	문제3)
	학생번호,이름,국어,수학점수를 입력받아 총점,평균,학점을 구해서 출력해 보세요.
	학생정보는 클래스로 만든다.
	학생수는 3명 -> 객체를 배열로 만든다.
	
	평균 90이상 A
	    80이상 B
	    ..

 */

class Student{
	private int num;
	private String name;
	private int kor;
	private int math;
	private int tot;
	private double avg;
	private String hak;

	public Student(int num,String name,int kor,int math) {  //생성자
		this.num = num;
	    this.name = name;
	    this.kor = kor;
	    this.math = math;
	    this.tot = kor+math;    //값이 없을때 셋팅값
	    this.avg = tot/2.0;     //값이 없을때 셋팅값
	}

	//평균 90이상 A    80이상 B ...
	public String getHak(){
		if(avg>=90){
			hak="A";
		}else if(avg>=80){
			hak="B";
		}else if(avg>=70){
			hak="C";
		}else if(avg>=60) {
			hak = "D";
		}else {
			hak = "F";
		}
		return hak;
	}

	public void studentInfo() {
		System.out.println("=====학생 정보 출력======");
		System.out.println("학생번호:" + num);
		System.out.println("이름:" + name);
		System.out.println("국어점수:" + kor);
		System.out.println("수학점수:" + math);
		System.out.println("합계:" + tot);
		System.out.println("평균:" + avg);
		System.out.println("학점:" + getHak());
	}

}
public class Test03 {
	public static void main(String[] args) {
		Student[] std = new Student[3];

		//입력처리
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<std.length;i++) {
			System.out.println("학생번호입력");
			int num=scan.nextInt();
			System.out.println("이름입력");
			String name=scan.next();
			System.out.println("국어점수입력");
			int kor=scan.nextInt();
			System.out.println("수학점수입력");
			int math=scan.nextInt();

			std[i]=new Student(num,name,kor,math);
		}

		//정보출력 메소드 호출
		for(int i=0;i<std.length;i++) {
			std[i].studentInfo();
		}

	}
}
