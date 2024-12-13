package test;

public class Member implements Comparable<Member>{
	private String id;
	private String pwd;
	
	public Member() {}

	public Member(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + "]";
	}

	@Override
	public int compareTo(Member o) {
		
		//아이디순으로 오름차순 정렬
		//public int compareTo(String anotherString)
		return id.compareTo(o.id);
		
		//아이디순으로 내림차순 정렬
		//return id.compareTo(o.id)*-1;
	
		
	}
	
	
}
