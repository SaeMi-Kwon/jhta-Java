package dto;

public class FeeDTO {
	private int fid;
	private double hourly_rate;
	
	public FeeDTO() {}
	
	public FeeDTO(int fid,double hourly_rate) {
		this.fid=fid;
		this.hourly_rate=hourly_rate;
	}

	
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public double getHourly_rate() {
		return hourly_rate;
	}

	public void setHourly_rate(double hourly_rate) {
		this.hourly_rate = hourly_rate;
	}
	
	
	
}
