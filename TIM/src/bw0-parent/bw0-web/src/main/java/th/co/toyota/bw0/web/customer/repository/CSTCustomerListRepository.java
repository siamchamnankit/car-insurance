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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.common.base.Strings;

import th.co.toyota.application.model.CustomerExpireInfo;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;

@Repository
public class CSTCustomerListRepository implements ISTCustomerListRepository{
	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;
	
	@Autowired
	protected IBW00000Repository commonRepo;
	
	final Logger logger = LoggerFactory.getLogger(CSTCustomerListRepository.class);



	@Override
	public List<CustomerExpireInfo> generateSearchQuery(String customerName ,String curDate,int preiod) throws Exception {	
		
		boolean closeConnection = true;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection conn = null;
		List<CustomerExpireInfo> listResult = new ArrayList<CustomerExpireInfo>();
        try{
				conn = commonRepo.getConnection();

			
				StringBuilder SQL  = new StringBuilder();

				SQL.append(" SELECT   ");
				SQL.append(" customer.customer_id,  ");
				SQL.append(" customer.customer_name,   ");
				SQL.append(" insurance.insurance_name,   ");
				SQL.append(" customer.expire_date   ");
				SQL.append(" FROM customer    ");
				SQL.append(" inner JOIN insurance    ");
				SQL.append(" on customer.insurance_id = insurance.insurance_id   ");
				SQL.append(" where STR_TO_DATE('"+curDate+"', '%d/%m/%Y') >= DATE_SUB(expire_date,INTERVAL "+preiod+" MONTH)  ");
				
				List<Object> parameter = new ArrayList<Object>();
				if (Strings.isNullOrEmpty(customerName) == false) {
					SQL.append("AND customer_name LIKE ? ");
					parameter.add(customerName);
				}
				
				SQL.append(" order by customer.expire_date  ");
				
			
			ps = conn.prepareStatement(SQL.toString());
			if (parameter.isEmpty() == false) {
				ps.setString(1, (String) parameter.get(0));
			}
			
			rs = ps.executeQuery();
			
			while(rs.next()){				
				CustomerExpireInfo customer = new CustomerExpireInfo();
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setInsurnaceId(rs.getString("insurance_name"));
				customer.setExpireDate(rs.getString("expire_date"));
				
				listResult.add(customer);
			}
        }catch(Exception e){
        	e.printStackTrace();
        } finally {
        	try{
				if (rs !=null) {
					rs.close();					
		            rs = null;
		        }
				
				if (ps !=null) {
		            ps.close();
		            ps = null;
		        }
				
				if(conn!=null && !conn.isClosed() && closeConnection){
					conn.close();
					conn = null;
				}
        	} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return listResult;
	}
	
	

	
	
}
