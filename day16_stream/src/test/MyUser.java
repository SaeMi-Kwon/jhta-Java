package test;

public class MyUser {
	private String id;
	private String name;
	private String email;
	private int savedMoney;
	public MyUser(String id, String name, String email, int savedMoney) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.savedMoney = savedMoney;  //적립금
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSavedMoney() {
		return savedMoney;
	}
	public void setSavedMoney(int savedMoney) {
		this.savedMoney = savedMoney;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", name=" + name + ", email=" + email + ", savedMoney=" + savedMoney + "]";
	}
	
	
	
	
}
