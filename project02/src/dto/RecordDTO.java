package dto;

import java.sql.Date;

public class RecordDTO {
	private int rcid;
	private String usid;
	private int sid;
	private int fid;
	private Date start_time;
	private Date end_time; 
	private double total_fee;
	
	
	public RecordDTO() {}
	
	public RecordDTO(int rcid,String usid,int sid,int fid,
				Date start_time,Date end_time,double total_fee) {
		this.rcid=rcid;
		this.usid=usid;
		this.sid=sid;
		this.fid=fid;
		this.start_time=start_time;
		this.end_time=end_time;
		this.total_fee=total_fee;
	}
	

	public int getRcid() {
		return rcid;
	}

	public void setRcid(int rcid) {
		this.rcid = rcid;
	}

	public String getUsid() {
		return usid;
	}

	public void setUsid(String usid) {
		this.usid = usid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
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

	public double getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(double total_fee) {
		this.total_fee = total_fee;
	}
	
	
	
	
	
}
