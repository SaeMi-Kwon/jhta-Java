package dto;

public class UserDTO {
	private String usid;
	private String uname;
	private String phone;
	private String car_number;
	
	
	public UserDTO() {}
	
	
	public UserDTO(String usid,String uname,String phone,String car_number) {
		this.usid=usid;
		this.uname=uname;
		this.phone=phone;
		this.car_number=car_number;
	}


	public String getUsid() {
		return usid;
	}


	public void setUsid(String usid) {
		this.usid = usid;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getCar_number() {
		return car_number;
	}


	public void setCar_number(String car_number) {
		this.car_number = car_number;
	}
	
}
