/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM : 
 * Client Name				:  TDEM
 * Package Name             :  th.co.toyota.bw0.web.master.service
 * Program ID 	            :  CST33060Service.java
 * Program Description	    :  <put description>
 * Environment	 	        :  Java 7
 * Author					:  Thanapon T.
 * Version					:  1.0
 * Creation Date            :  October 10, 2018
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2013-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.bw0.web.customer.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.toyota.application.model.CustomerExpireInfo;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.web.customer.repository.ISTCustomerListRepository;

@Service
public class CSTCustomerListService {
	final Logger logger = LoggerFactory.getLogger(CSTCustomerListService.class);
		
	@Autowired
	private ISTCustomerListRepository repository;
	
	@Autowired
	private IBW00000Repository commonRepository;



	@SuppressWarnings("unchecked")
	public List<CustomerExpireInfo> searchCustomerExpireData(String customerName, String currentDate, int iPeriod) throws Exception {
		Connection conn = null;
		List<CustomerExpireInfo> listResult = new ArrayList<CustomerExpireInfo>();
		try{
			conn = commonRepository.getConnection();
			Object[] objAll = repository.generateSearchQuery(customerName , currentDate , iPeriod);
			
			
			for (Object objArr : objAll) {
				Object[] obj = (Object[]) objArr;
				CustomerExpireInfo customer = new CustomerExpireInfo();
				customer.setCustomerId((String)obj[0]);
				customer.setCustomerName((String) obj[1]);
				customer.setInsurnaceId((String) obj[2]);
				customer.setExpireDate((String) obj[3]);
				
				listResult.add(customer);
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
		return listResult;
	}

}
