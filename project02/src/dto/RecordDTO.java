package dto;

public class RecordDTO {
	private int rcid;   
	private int rvid;   
	private String usid;  
	private String location;   
	private String start_time;    
	private String end_time;
	private double total_fee;
	
	
	public RecordDTO() {}
	
	public RecordDTO(int rcid, int rvid, String usid, String location, 
			String start_time, String end_time, double total_fee) {
		this.rcid = rcid;
		this.rvid = rvid;
		this.usid = usid;
		this.location = location;
		this.start_time = start_time;
		this.end_time = end_time;
		this.total_fee = total_fee;
	}

	
	public int getRcid() {
		return rcid;
	}

	public void setRcid(int rcid) {
		this.rcid = rcid;
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

	public double getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}
	
}
