package help.nic.model;

public class hostel {
	private String hostelid;
	private String hostelname;
	
	private String type;
	private String warden;
	private String phone;
	private String email;
	private String photograph;
	
	public String getHostelid() {
		return hostelid;
	}
	public void setHostelid(String hostelid) {
		this.hostelid = hostelid;
	}
	public String getHostelname() {
		return hostelname;
	}
	public void setHostelname(String hostelname) {
		this.hostelname = hostelname;
	}
	public String getWarden() {
		return warden;
	}
	public void setWarden(String warden) {
		this.warden = warden;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotograph() {
		return photograph;
	}
	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}
}
