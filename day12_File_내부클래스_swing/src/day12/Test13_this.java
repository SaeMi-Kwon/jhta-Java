package day12;

/*
 * [ this ]
 * - 객체 자신을 의미(객체 자신의 주소값)
 * - this의 용도
 * 	1) 멤버변수와 매개변수 이름이 같을때 멤버변수앞에 this를 붙여서 구분
 * 	2) 다른생성자를 호출할때
 * 	3) 객체 자신을 다른 메소드의 파라미터값으로 전달할때
 */

class User{
	private String id;
	private String pwd;
	
	public User() {
		this("user1","1234");  //2) 다른 생성자를 호출할때
	}
	public User(String id,String pwd) {
		this.id=id;  //1) 멤버변수와 매개변수 이름이 같을때 멤버변수앞에 this를 붙여서 구분
		this.pwd=pwd;
	}
	public String getId() {
		return this.id;
	}
	public String getPwd() {
		return this.pwd;
	}
	public void print() {
		System.out.println("id:" + this.id);
		System.out.println("pwd:" + this.pwd);
	}
	public void printerUser() {
		//this는 new로 생성된 자기 자신의 주소값
		Test13_this.printer(this);
	}
}

public class Test13_this {
	public static void main(String[] args) {
		User user=new User();
		user.printerUser();
		
		User user1=new User("test","1111");
		user1.printerUser();
	}
	
	public static void printer(User u) {
		System.out.println("<<프린터로 정보를 출력>>");
		System.out.println("아이디:" + u.getId());
		System.out.println("비밀번호:" + u.getPwd());
	}
	
}
