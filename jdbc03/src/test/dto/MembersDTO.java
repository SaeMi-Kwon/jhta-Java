package test.dto;

import java.sql.Date;

/*
 * DTO(Data Transfer Object) 클래스
 * - 하나의 row를 담는 역할
 * 
 * - 만드는 규칙
 * 	 컬럼명과 멤버변수명을 같은 이름으로 만든다
 * 	 멤버변수값을 담는 setter메소드를 만든다
 * 	 멤버변수값을 리턴하는 getter메소드를 만든다.
 * 
 */

public class MembersDTO {
	//멤버변수명을 컬럼명과 동일하게 만들기
	private int num;
	private String name;
	private String phone;
	private String addr;
	private Date regdate;
	
	
	public MembersDTO() {}  //new MembersDTO();
	
	public MembersDTO(int num,String name,String phone,String addr,Date regdate) {
		this.num=num;
		this.name=name;
		this.phone=phone;
		this.addr=addr;
		this.regdate=regdate;
	}
	
	//setter메소드 만들기 --> 만드는 규칙 : set + 멤버변수명(변수시작문자는 대문자로)
	public void setNum(int num) {
		this.num=num;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPhone(String phone) {
		this.phone=phone;
	}
	
	public void setAddr(String addr) {
		this.addr=addr;
	}
	
	public void setRegdate(Date regdate) {
		this.regdate=regdate;
	}
	
	
	//getter메소드 만들기 --> 만드는 규칙 : get + 멤버변수명(변수시작문자는 대문자로)
	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public Date getRegdate() {
		return regdate;
	}
}
