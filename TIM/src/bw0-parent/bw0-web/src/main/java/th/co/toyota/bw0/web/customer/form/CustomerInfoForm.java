package th.co.toyota.bw0.web.customer.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import th.co.toyota.application.model.Payload;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.form.common.CBW01000BaseForm;
import th.co.toyota.bw0.util.ComboValue;

public class CustomerInfoForm extends CBW01000BaseForm{	
	private int customer_id;
	private String customer_name;
	private String tel;
	private String email;
	private String brand;
	private String province;
	private String model;
	private String insurance_id;
	private String expire_date;
	
	List<ComboValue> customerList;
	
	private String messageResult;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getInsurance_id() {
		return insurance_id;
	}

	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}

	public String getExpire_date() {
		return expire_date;
	}

	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	public List<ComboValue> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<ComboValue> customerList) {
		this.customerList = customerList;
	}

	public String getMessageResult() {
		return messageResult;
	}

	public void setMessageResult(String messageResult) {
		this.messageResult = messageResult;
	}
	
	
}
