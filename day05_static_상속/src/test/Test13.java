package test;
class Person{
	private String snum;  //주민번호
	private String name;  //이름
	
	public Person(String snum,String name) {
		this.snum=snum;
		this.name=name;
	}
	public void print() {
		System.out.println("주민등록번호:" + snum);
		System.out.println("이름:" + name);
	}
}
//위의 클래스를 상속받아 학번과 학과가 저장되는 Student클래스를 만들고 사용해 보세요.
class Student extends Person{
	private int num;
	private String major;
	
	public Student(String snum,String name,int num,String major) {
		super(snum,name);
		this.num=num;
		this.major=major;
	}
	
	public void print() {   //오버라이딩(리턴타입,메소드명,매개변수 전부 똑같은 조건)
		super.print();   //부모가 갖는 print메소드 호출
		System.out.println("학번:" + num);
		System.out.println("학과:" + major);
	}
}

public class Test13 {
	public static void main(String[] args) {
		Student std=new Student("990412-2366841","김가연",16,"회계과");
		std.print();
	}
}
