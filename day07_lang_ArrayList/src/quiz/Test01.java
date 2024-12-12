package quiz;

import java.util.ArrayList;

import test.Person;

/*
	과제1)
	Person클래스를 상속받아 학번과 학과정보가 추가되는 Student클래스를 만들고
	ArrayList에 저장후 전체 학생정보가 출력되도록 해보세요
 */

class Student extends Person{
	private String name;  //이름
	private int age;  //나이	
	private int num;  //학번
	private String major;  //학과
	Student(String name,int age, int num,String major) {
		super(name,age);
		this.num=num;
		this.major=major;
	}
	@Override
	public void print() {
		super.print();
		System.out.println("학번:" + num);
		System.out.println("학과:" + major);
	}
}

public class Test01 {
	public static void main(String[] args) {
		ArrayList<Student> std=new ArrayList<>();
		std.add(new Student("홍길동",20,1,"경영학과"));
		std.add(new Student("이길동",22,2,"회계학과"));
		std.add(new Student("삼길동",23,3,"패션학과"));
		
		System.out.println("");
		for(int i=0;i<std.size();i++) {
			Student s=std.get(i);
			s.print();
		}
	}

}
