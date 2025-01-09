package dto;

import java.sql.Date;

public class ReservDTO {
	private int rvid;
	private String usid;
	private int sid;
	private Date start_time;
	private Date end_time;
	private String status;
	
	
	public ReservDTO() {}
	
	public ReservDTO(int rvid,String usid,int sid,
				Date start_time,Date end_time,String status) {
		this.rvid=rvid;
		this.usid=usid;
		this.sid=sid;
		this.start_time=start_time;
		this.end_time=end_time;
		this.status=status;
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

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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
