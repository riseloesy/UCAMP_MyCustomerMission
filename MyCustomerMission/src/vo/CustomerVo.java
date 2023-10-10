package vo;

public class CustomerVo {
	private int cid;
	private String cname;
	private String cemail;
	private String cage;
	private String centrydate;
	
	public CustomerVo() {
		
	}
	
	public CustomerVo(int cid, String cname, String cemail, String cage, String centrydate) {
		this.cid=cid;
		this.cname=cname;
		this.cemail=cemail;
		this.cage=cage;
		this.centrydate=centrydate;
	}

	public int getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}

	public String getCemail() {
		return cemail;
	}

	public String getCage() {
		return cage;
	}

	public String getCentrydate() {
		return centrydate;
	}
	
	@Override
	public String toString() {
		return "CustomerVo [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cage=" + cage + ", centrydate=" + centrydate
				+ "]";
	}
	

}
