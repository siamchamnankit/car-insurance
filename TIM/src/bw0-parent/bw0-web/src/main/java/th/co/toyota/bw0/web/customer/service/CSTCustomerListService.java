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

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.toyota.application.model.CustomerExpireInfo;
import th.co.toyota.bw0.web.customer.repository.ISTCustomerListRepository;

@Service
public class CSTCustomerListService {
	final Logger logger = LoggerFactory.getLogger(CSTCustomerListService.class);
		
	@Autowired
	private ISTCustomerListRepository repository;

	public List<CustomerExpireInfo> searchCustomerExpireData(String customerName, String currentDate, int iPeriod) throws Exception {
		return repository.generateSearchQuery(customerName, currentDate, iPeriod);
	}

}
