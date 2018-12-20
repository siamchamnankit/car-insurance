package th.co.toyota.bw0.web.customer.repository;

import java.sql.Connection;
import java.util.List;

import th.co.toyota.application.model.CustomerInsuranceInfo;
import th.co.toyota.application.model.InsuranceInfo;


public interface ISTCustomerInsuranceRepository {

	public CustomerInsuranceInfo searchCustomerInsurance(Connection conn, String customerId);
	public List<InsuranceInfo> searchInsuranceListForRenew(Connection conn, String insuranceType);
	
}
