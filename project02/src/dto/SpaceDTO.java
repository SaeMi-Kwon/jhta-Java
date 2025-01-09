package dto;

public class SpaceDTO {
	private int sid;
	private String location;
	private String useyn;
	
	
	public SpaceDTO() {}
	
	public SpaceDTO(int sid,String location,String useyn) {
		this.sid=sid;
		this.location=location;
		this.useyn=useyn;
	}

	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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
	
	
}
