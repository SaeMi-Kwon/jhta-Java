package test;

public class Member{
	private String id;
	private String pwd;
		
	public Member() {} //디폴트생성자
		
	public Member(String id,String pwd) {  //생성자
		this.id=id;
		this.pwd=pwd;
	}
	@Override
	public String toString() {
		String s="id===>" + id + ",pwd===>" + pwd;
		return s; 
	}
	@Override
	public boolean equals(Object obj) {		
		if(obj instanceof Member) {
			Member m = (Member)obj;
		
			if(id.equals(m.id) && pwd.equals(m.pwd)) {
				return true;
			}
		}
		return false;

	}
		
	//값 변경 메소드
	public void editInfo(String id,String pwd) {
		this.id=id;
		this.pwd=pwd;
	}
		
	public String getId() {
		return id;
	}
		
	public String getPwd() {
		return pwd;
	}
	
}
