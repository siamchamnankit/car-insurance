package th.co.toyota.bw0.api.repository.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;

import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import th.co.toyota.bw0.api.constants.AppConstants;

import com.google.common.base.Strings;

@Repository
public class CBW03060Repository implements IBW03060Repository {
	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;

	final Logger logger = LoggerFactory.getLogger(CBW03060Repository.class);

	
	
	@Override
	public String findSystemMasterValue(Connection conn, String category, String subCategory, String code){
		boolean closeConnection = true;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String value = "";
        try{
			if(conn==null){
				SessionImpl session = (SessionImpl)(em.getDelegate());
				conn = session.getJdbcConnectionAccess().obtainConnection();
			}else{
				closeConnection = false;
			}
			
        	StringBuilder sql = new StringBuilder();
			sql.append(" SELECT VALUE ");
			sql.append(" FROM TB_M_SYSTEM ");
			sql.append(" WHERE CATEGORY = '"+category+"' ");
			sql.append(" AND SUB_CATEGORY = '"+subCategory+"' ");
			sql.append(" AND CD = '"+code+"' ");
			sql.append(" AND STATUS = 'Y' ");
			
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				value = rs.getString("VALUE");
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
        return value;
	}
}
