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
package th.co.toyota.bw0.web.master.repository;

import java.sql.Connection;
import java.util.List;

import th.co.toyota.bw0.web.master.form.CST33060Form;
import th.co.toyota.st3.api.model.SystemInfo;

public interface IST33060Repository {
	Object[] generateSearchQuery(CST33060Form form) throws Exception;
	List<SystemInfo> searchObjectList(Connection conn, StringBuilder sql, List<Object> parameter, int firstResult, int rowsPerPage) throws Exception;
}
