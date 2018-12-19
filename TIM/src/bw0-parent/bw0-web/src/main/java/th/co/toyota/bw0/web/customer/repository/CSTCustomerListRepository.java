/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM : 
 * Client Name				:  TDEM
 * Package Name             :  th.co.toyota.bw0.api.model.common
 * Program ID 	            :  CST33060Repository.java
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

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import th.co.toyota.bw0.web.customer.form.CustomerInfoForm;;

@Repository
public class CSTCustomerListRepository implements ISTCustomerListRepository{
	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;
	
	final Logger logger = LoggerFactory.getLogger(CSTCustomerListRepository.class);



	@Override
	public Object[] generateSearchQuery(CustomerInfoForm activeform ,String customerName ,String expireDate) throws Exception {
		CustomerInfoForm form = activeform;
		StringBuilder SQL  = new StringBuilder();
		SQL.append(" SELECT 	");
		SQL.append(" 	customer_id,  ");
		SQL.append(" 	customer_name, ");
		SQL.append(" 	tel, ");
		SQL.append(" 	email, ");
		SQL.append(" 	brand, ");
		SQL.append(" 	province, ");
		SQL.append(" 	model, ");
		SQL.append(" 	insurance_id, ");
		SQL.append(" 	expire_date ");
		SQL.append(" FROM CUSTOMER WHERE 1=1 ");
		
		if(!customerName.isEmpty()){
			SQL.append("AND ? = customer_name");
		}
		
		if(!expireDate.isEmpty()){
			SQL.append("AND ? >= DATE_SUB(expire_date,INTERVAL 6 MONTH)");
		}
		
		List<Object> parameter = new ArrayList<Object>();
		parameter.add(customerName);
		parameter.add(expireDate);
		
		return new Object[]{ SQL, parameter};
	}

	
	
}
