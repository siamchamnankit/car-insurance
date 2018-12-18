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
package th.co.toyota.bw0.web.master.repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.google.common.base.Strings;

import th.co.toyota.bw0.web.master.form.CST33060Form;

@Repository
public class CST33060Repository implements IST33060Repository{
	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;
	
	final Logger logger = LoggerFactory.getLogger(CST33060Repository.class);



	@Override
	public Object[] generateSearchQuery(CST33060Form activeform) throws Exception {
		CST33060Form form = activeform;
		StringBuilder SQL  = new StringBuilder();
		SQL.append(" SELECT 	");
		SQL.append(" 	CATEGORY,  ");
		SQL.append(" 	SUB_CATEGORY, ");
		SQL.append(" 	CD, ");
		SQL.append(" 	VALUE, ");
		SQL.append(" 	REMARK, ");
		SQL.append(" 	STATUS, ");
		SQL.append(" 	CREATE_BY, ");
		SQL.append(" 	CREATE_DT, ");
		SQL.append(" 	UPDATE_BY, ");
		SQL.append(" 	UPDATE_DT, ");
		SQL.append(" 	 ROW_NUMBER() OVER(ORDER BY CATEGORY, SUB_CATEGORY, CD ) AS ROW_NUM ");
		SQL.append(" FROM TB_M_SYSTEM ");
		SQL.append(" WHERE UPPER(CATEGORY) = ? ");
		
		List<Object> parameter = new ArrayList<Object>();
		parameter.add(form.getCategorySearch().toUpperCase());
		if (!Strings.isNullOrEmpty(activeform.getSubCategorySearch())) {
			SQL.append(" AND UPPER(SUB_CATEGORY) = ? ");
			parameter.add(form.getSubCategorySearch());
		}
		if (!Strings.isNullOrEmpty(activeform.getCodeSearch())) {
			if (!activeform.getCodeSearch().contains("*")) {
				SQL.append(" AND UPPER(CD) = ? ");
				parameter.add(form.getCodeSearch().toUpperCase());
			} else {
				SQL.append(" AND UPPER(CD) LIKE ? ");
				parameter.add(activeform.getCodeSearch().replace("*", "%").toUpperCase());
			}
			
		}
		return new Object[]{ SQL, parameter};
	}

	@Override
	public List searchObjectList(Connection conn, StringBuilder sql, List<Object> parameter,
			int firstResult, int rowsPerPage) throws Exception {
		List listResult = new ArrayList();
		
		return listResult;
	}
}
