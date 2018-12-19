package th.co.toyota.application.web.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotNull;

import org.hibernate.internal.SessionImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import th.co.toyota.bw0.api.service.common.UserInfo;

@Repository
public class CSTAuthenRepository implements ISTAuthenRepository {
	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;

	final Logger logger = LoggerFactory.getLogger(CSTAuthenRepository.class);

	
	
	@Override
	public UserInfo authen(Connection conn, String userName, String password){
		boolean closeConnection = true;
		PreparedStatement ps = null;
		ResultSet rs = null;

		UserInfo user = new UserInfo();
        try{
			if(conn==null){
				SessionImpl session = (SessionImpl)(em.getDelegate());
				conn = session.getJdbcConnectionAccess().obtainConnection();
			}else{
				closeConnection = false;
			}
			
        	StringBuilder sql = new StringBuilder();
			sql.append(" SELECT name_lastname ");
			sql.append(" FROM TB_M_SYSTEM ");
			sql.append(" WHERE username = '"+userName+"' ");
			sql.append(" AND password = '"+password+"' ");
			
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				user.setUserName(userName);
				user.setUserPass(password);
				user.setName(rs.getString("name_lastname"));
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
        return user;
	}
}
