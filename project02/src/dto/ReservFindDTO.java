package dto;

public class ReservFindDTO {
	private int rvid;
	private String usid;
	private String location;
	private String start_time;
	private String end_time;
	private String status;
	
	
	public ReservFindDTO() {}

	public ReservFindDTO(int rvid, String usid, String location, 
			String start_time, String end_time, String status) {
		this.rvid = rvid;
		this.usid = usid;
		this.location = location;
		this.start_time = start_time;
		this.end_time = end_time;
		this.status = status;
	}

	
	public int getRvid() {
		return rvid;
	}

	public void setRvid(int rvid) {
		this.rvid = rvid;
	}

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
