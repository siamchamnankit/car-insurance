package th.co.toyota.bw0.web.customer.form;

public class CustomerExpireForm {

	private String cName = null;
	private String cLastname = null;
	private int iExpirePeriod = 6;
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcLastname() {
		return cLastname;
	}
	public void setcLastname(String cLastname) {
		this.cLastname = cLastname;
	}
	public int getiExpirePeriod() {
		return iExpirePeriod;
	}
	public void setiExpirePeriod(int iExpirePeriod) {
		this.iExpirePeriod = iExpirePeriod;
	}
	
}
