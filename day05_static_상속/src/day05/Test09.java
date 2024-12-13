package day05;
class Person{
	private String snum;  //주민번호
	private String name;  //이름
	
	public void setPerson(String snum,String name) {
		this.snum=snum;
		this.name=name;
	}
	public void printPerson() {
		System.out.println("주민등록번호:" + snum);
		System.out.println("이름:" + name);
	}
}

class Student extends Person{
	private int num; //학생번호
	private String major;  //전공
	
	public void setStudent(String snum,String name,int num,String major) {
		setPerson(snum,name);
		this.num =num;
		this.major=major;
	}
	
	public void printStudent() {
//		System.out.println("주민등록번호:" + snum);  //에러 -> private멤버는 자식클래스에서도 접근 못함
//		System.out.println("이름:" + name);
		printPerson();
		System.out.println("학생번호:" + num);
		System.out.println("전공:" + major);
	}
}

public class Test09 {
	public static void main(String[] args) {
		//Student객체를 생성하고 정보를 출력해 보세요.
		Student std=new Student();
		std.setStudent("901201-1256451", "이나라", 1, "경영학과");
		std.printStudent();
	}
}
