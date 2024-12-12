package test;

public class Member {
	private String id;
	private String pwd;
	private String email;
	
	public Member(String id,String pwd,String email) {
		this.id=id;
		this.pwd=pwd;
		this.email=email;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPwd() {
		return pwd;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "[id]"+ id + ", [pwd]"+ pwd + ", [email]"+ email;
	}
	
	public void print() {
		System.out.println("id:" + id);
		System.out.println("pwd:" + pwd);
		System.out.println("email:" + email);
	}
	
}
