/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM : 
 * Client Name				:  TDEM
 * Package Name             :  th.co.toyota.bw0.api.model.common
 * Program ID 	            :  IST33060Repository.java
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
package th.co.toyota.bw0.web.customer.repository;

import java.util.List;

import th.co.toyota.application.model.CustomerExpireInfo;

public interface ISTCustomerListRepository {
	List<CustomerExpireInfo> generateSearchQuery(String customerName, String curDate, int preiod) throws Exception;
}
