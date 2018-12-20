package th.co.toyota.bw0.web.customer.form;

public class CustomerExpireForm {

	private String cName = null;
	private String currentDate = null;
	private int iExpirePeriod = 6;
	
	private boolean isEnableCriteriaName = false;
	
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}	
	public int getiExpirePeriod() {
		return iExpirePeriod;
	}
	public void setiExpirePeriod(int iExpirePeriod) {
		this.iExpirePeriod = iExpirePeriod;
	}
	public boolean isEnableCriteriaName() {
		return isEnableCriteriaName;
	}
	public void setEnableCriteriaName(boolean isEnableCriteriaName) {
		this.isEnableCriteriaName = isEnableCriteriaName;
	}
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}

}
