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
package th.co.toyota.bw0.web.master.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import th.co.toyota.application.model.Payload;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.web.master.form.CST33060Form;
import th.co.toyota.bw0.web.master.repository.IST33060Repository;

@Service
public class CST33060Service {
	final Logger logger = LoggerFactory.getLogger(CST33060Service.class);
		
	@Autowired
	private IST33060Repository repository;
	
	@Autowired
	private IBW00000Repository commonRepository;



	@SuppressWarnings("unchecked")
	public boolean searchAllData(CST33060Form form, Payload payload, HttpServletRequest request) throws Exception {
		boolean foundData = false;
		Connection conn = null;
		try{
			conn = commonRepository.getConnection();
			Object[] query = repository.generateSearchQuery(form);
			StringBuilder sql = (StringBuilder) query[0];
			List<Object> parameter = (List<Object>) query[1];
			int totalRows = commonRepository.getTotalActiveRecordSize(conn, sql, parameter);
			int firstResult = form.getFirstResult();
			int rowsPerPage = form.getRowsPerPage();
			int first = firstResult - (firstResult % rowsPerPage);
			if (first >= totalRows) {
				first = totalRows - rowsPerPage;
				if (first < 0) {
					first = 0;
				}
			}
			firstResult = first;
			if (totalRows > 0) {				
				List ls = repository.searchObjectList(conn, sql, parameter, firstResult, rowsPerPage);
				payload.setObjectForm(form);
				if ((ls != null) && (!ls.isEmpty())) {
					payload.setObjectsInfoList(ls);
					foundData = true;
				} else {
					payload.setObjectsInfoList(null);
				}
			}
			payload.setFirstResult(firstResult);
			payload.setRowsPerPage(rowsPerPage);
			payload.setTotalRows(totalRows);
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
