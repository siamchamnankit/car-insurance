package th.co.toyota.bw0.web.customer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.toyota.application.model.CustomerInsuranceInfo;
import th.co.toyota.application.model.InsuranceInfo;
import th.co.toyota.application.model.Payload;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.web.customer.repository.ISTCustomerInsuranceRepository;

@Service
public class CustomerInsuranceService {
	final Logger logger = LoggerFactory.getLogger(CustomerInsuranceService.class);
		
	@Autowired
	private ISTCustomerInsuranceRepository repository;
	
	@Autowired
	private IBW00000Repository commonRepository;

	public boolean searchAllData(String customerId, String insuranceType, Payload payload) throws Exception {
		boolean foundData = false;
		Connection conn = null;
		try{
			conn = commonRepository.getConnection();
			CustomerInsuranceInfo customerInsurance = repository.searchCustomerInsurance(conn, customerId);
			if(customerInsurance != null) {
				List<InsuranceInfo> insuranceList = repository.searchInsuranceListForRenew(conn, insuranceType);
				payload.setObjectInfo(customerInsurance);
			}
			
		}finally{
			try {
				if(conn!=null && !conn.isClosed()){
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return foundData;
	}

}
