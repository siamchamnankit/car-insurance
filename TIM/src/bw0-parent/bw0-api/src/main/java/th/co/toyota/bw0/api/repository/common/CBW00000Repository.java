/******************************************************
 * Program History
 *
 * Project Name	            :  TIM :
 * Client Name				:  TMAP-EM
 * Package Name             :  th.co.toyota.bw0.repository.common
 * Program ID 	            :  CBW00000Repository.java
 * Program Description	    :  Common Repository
 * Environment	 	        :  Java 7
 * Author					:  Thanapon T.
 * Version					:  1.0
 * Creation Date            :  September 08, 2016
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2013-TOYOTA Motor Asia Pacific. All Rights Reserved.
 ********************************************************/
package th.co.toyota.bw0.api.repository.common;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import th.co.toyota.bw0.api.common.CBW00000Util;
import th.co.toyota.bw0.api.constants.AppConstants;

@Repository
public class CBW00000Repository implements IBW00000Repository {
	
	final Logger logger = LoggerFactory.getLogger(CBW00000Repository.class);

	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;



	@Override
	public Connection getConnection(){
//		try{
//			SessionImpl session = (SessionImpl) (em.getDelegate());
//			return session.getJdbcConnectionAccess().obtainConnection();
//		} catch (SQLException e) {
//			return null;
//		}
		
        Connection connection = null;
   
        System.out.println("-------- MySQL JDBC Connection Testing ------------");

    	try {
    		Class driver_class = Class.forName("com.mysql.jdbc.Driver");
            Driver driver = (Driver) driver_class.newInstance();
            DriverManager.registerDriver(driver);
    	} catch (Exception e) {
    		System.out.println("Where is your MySQL JDBC Driver?");
    		e.printStackTrace();
    	}

    	System.out.println("MySQL JDBC Driver Registered!");

    	try {
    		connection = DriverManager.getConnection("jdbc:mysql://68.183.189.35:3306/insurance","insurance", "P@ssw0rd");

    	} catch (SQLException e) {
    		System.out.println("Connection Failed! Check output console");
    		e.printStackTrace();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    	if (connection != null) {
    		System.out.println("You made it, take control your database now!");
    	} else {
    		System.out.println("Failed to make connection!");
    	}
        return connection;
	}
	
	@Override
	public HashMap<String,Object> getTableMeataData(String tableName) throws Exception {
		String sqlCmd = "SELECT * FROM " + tableName + " WHERE 0 = 1";
		
		Connection conn = null;
		PreparedStatement pp = null;
		ResultSet rs = null;
		
		HashMap<String,Object> hashMetadata = new HashMap<String,Object>();
    	ArrayList<String> alPK = new ArrayList<String>();
    	String[] arrPK = null;
    	int columnNum = 0;
		try {
			SessionImpl session = (SessionImpl)(em.getDelegate());
        	conn = session.getJdbcConnectionAccess().obtainConnection();	
			
			pp = conn.prepareStatement(sqlCmd);
			rs = pp.executeQuery();

	    	ResultSetMetaData rsmd = rs.getMetaData();
	    	DatabaseMetaData dbmd = conn.getMetaData();

	    	rs = null;
	    	rs = dbmd.getPrimaryKeys(null, null, tableName);
	    	while(rs.next()){
	    		alPK.add(rs.getString("COLUMN_NAME"));
	    	}

	    	Object objPK = alPK.toArray();
	    	if(objPK instanceof String){
	    		arrPK = new String[1];
	    		arrPK[0] = objPK.toString();
	    	}else if(objPK instanceof Object[]){
	    		Object[] arrObjPK = (Object[])objPK;
	    		arrPK = new String[arrObjPK.length];
	    		for(int i = 0; i < arrObjPK.length; i++){
	    			arrPK[i] = (String)arrObjPK[i];
	    		}
	    	}else if(objPK instanceof String[]){
	    		arrPK = (String[])objPK;
	    	}
	    	
	    	columnNum = rsmd.getColumnCount();
	    	for(int i = 0; i < columnNum; i++){
	    		HashMap<String,Object> colInfo = new HashMap<String,Object>();
	    		colInfo.put("TYPE", rsmd.getColumnTypeName(i+1));
	    		colInfo.put("PRECISION", new Integer(rsmd.getPrecision(i+1)));
	    		colInfo.put("SCALE", new Integer(rsmd.getScale(i+1)));
	    		colInfo.put("LENGTH", new Integer(rsmd.getColumnDisplaySize(i+1)));
	    		hashMetadata.put(rsmd.getColumnName(i+1), colInfo);
	    	}

	    	hashMetadata.put("TABLE_NAME", tableName);
	    	hashMetadata.put("PK", arrPK);

		} catch (Exception ex) {
			throw ex;
		} finally {
			if ((conn != null) && !conn.isClosed()) {
				if (rs !=null) {
		            rs.close();
		            rs = null;
		        }
				
				if (pp !=null) {
		            pp.close();
		            pp = null;
		        }
				
				conn.close();
				conn = null;
			}
		}

    	return hashMetadata;
	}
	
	@Override
	public int getRowPerPage(String screenId) {
		BigDecimal rowsPerPage = new BigDecimal(10);
        try{
        	StringBuilder sql = new StringBuilder();
			sql.append(" SELECT VALUE ");
			sql.append(" FROM TB_M_SYSTEM ");
			sql.append(" WHERE CATEGORY = 'SCREEN' ");
			sql.append(" AND SUB_CATEGORY = 'ROWS_PER_PAGE' ");
			sql.append(" AND CD = '"+screenId+"' ");
			Query query = em.createNativeQuery(sql.toString());
            String result = (String) query.getSingleResult();
            rowsPerPage = new BigDecimal(result);
        }catch(Exception e){
        	rowsPerPage = new BigDecimal(10);
        }
        return rowsPerPage.intValue();
	}
	
	@Override
	public Object executeQuery(Connection conn, String sql, int totalSelectCol) throws Exception {
		boolean closeConnection = true;
		PreparedStatement pp = null;
		ResultSet rs = null;
		Object result = null;
        try{
			if(conn==null){
	    		SessionImpl session = (SessionImpl)(em.getDelegate());
	    		conn = session.getJdbcConnectionAccess().obtainConnection();
	    	}else{
	    		closeConnection = false;
	    	}
			
			logger.debug(sql.toString());
			pp = conn.prepareStatement(sql.toString());
			rs = pp.executeQuery();
			if(totalSelectCol==1){				
				while(rs.next()){
					result = rs.getObject(1);
				}
			}else{
				while(rs.next()){
					List<Object> obj = new ArrayList<Object>();
					for(int col=1;col<=totalSelectCol; col++){
						obj.add(rs.getObject(col));
					}
					result = obj.toArray();
				}
			}
		}catch(Exception e){
			throw CBW00000Util.handleExceptionToCommonErrorException(e, logger, false);
		} finally {
			try{
				if(conn!=null && !conn.isClosed()){
					if (rs !=null) {
						rs.close();					
			            rs = null;
			        }
					
					if (pp !=null) {
			            pp.close();
			            pp = null;
			        }
					if(closeConnection){
						conn.close();
						conn = null;
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return result;
	}

	@Override
	public int getTotalActiveRecordSize(Connection conn, StringBuilder sql, List<Object> parameter) throws Exception {
		BigDecimal totalRows = new BigDecimal(0);
		boolean closeConnection = true;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
        	if(conn==null){
        		SessionImpl session = (SessionImpl)(em.getDelegate());
        		conn = session.getJdbcConnectionAccess().obtainConnection();
        	}else{
        		closeConnection = false;
        	}
        	
			String sqlCount = "SELECT COUNT(1) AS TOTAL_ROW FROM ( " + sql.toString() + " ) ";
			
			ps = conn.prepareStatement(sqlCount);
			if (parameter != null) {
				int index = 1;
				for (Object obj : parameter) {
					ps.setObject(index, obj);
					index++;
				}
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				totalRows = rs.getBigDecimal("TOTAL_ROW");
			}
		} catch (Exception e) {
			throw CBW00000Util.handleExceptionToCommonErrorException(e, logger, false);
		} finally {
			try {
				if ((conn != null) && !conn.isClosed()) {
					if (rs !=null) {
						rs.close();					
			            rs = null;
			        }
					
					if (ps != null) {
						ps.close();
						ps = null;
					}
					if(closeConnection){
						conn.close();
						conn = null;
					}
				}
			} catch (Exception e1) {
				logger.error(ExceptionUtils.getStackTrace(e1));
			}
		}
		return totalRows.intValue();
	}
	
	@Override
	public HashMap<String, String> getUserInfoForTestOnFTH(String ipAddress) {
		HashMap<String, String> userInfoMap = new HashMap<String, String>();
		Connection conn = null;
		PreparedStatement pp = null;
		ResultSet rs = null;
        try{
        	StringBuilder sql = new StringBuilder();
			sql.append(" SELECT CD, VALUE ");
			sql.append(" FROM TB_M_SYSTEM ");
			sql.append(" WHERE CATEGORY = '"+AppConstants.SYS_CATEGORY_TIM+"' ");
			sql.append(" AND SUB_CATEGORY = '"+ipAddress+"' ");
			
			SessionImpl session = (SessionImpl) (em.getDelegate());
			conn = session.getJdbcConnectionAccess().obtainConnection();
			pp = conn.prepareStatement(sql.toString());
			rs = pp.executeQuery();
			while(rs.next()){
				userInfoMap.put(rs.getString("CD"), rs.getString("VALUE"));
			}
        }catch(Exception e){
        	e.printStackTrace();
        } finally {
        	try{
        		if(conn!=null && !conn.isClosed()){
					if (rs !=null) {
						rs.close();					
			            rs = null;
			        }
					
					if (pp !=null) {
			            pp.close();
			            pp = null;
			        }
					
					conn.close();
					conn = null;
        		}
        	} catch (SQLException e) {
				e.printStackTrace();
			}
		}
        return userInfoMap;
	}
	
}
