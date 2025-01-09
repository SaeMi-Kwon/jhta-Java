package dto;

import java.sql.Date;

public class UserReservDTO {
	private String usid;
	private String uname;
	private String phone;
	
	private String location;
	private String useyn;

	private Date start_time;
	private Date end_time;
	private String status;
	
	
	public UserReservDTO() {}
	
	public UserReservDTO(String usid, String uname, String phone, 
				String location, String useyn, Date start_time,
				Date end_time, String status) {
		this.usid = usid;
		this.uname = uname;
		this.phone = phone;
		this.location = location;
		this.useyn = useyn;
		this.start_time = start_time;
		this.end_time = end_time;
		this.status = status;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUseyn() {
		return useyn;
	}

	public void setUseyn(String useyn) {
		this.useyn = useyn;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
