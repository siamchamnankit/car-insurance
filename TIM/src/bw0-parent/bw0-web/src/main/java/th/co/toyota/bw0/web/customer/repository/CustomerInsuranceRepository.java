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

import th.co.toyota.application.model.CustomerInsuranceInfo;
import th.co.toyota.application.model.InsuranceInfo;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;

@Repository
public class CustomerInsuranceRepository implements ISTCustomerInsuranceRepository {
	@NotNull
	@PersistenceContext(unitName = "entityManagerFactory")
	private EntityManager em;

	final Logger logger = LoggerFactory.getLogger(CustomerInsuranceRepository.class);

	@Autowired
	protected IBW00000Repository commonRepo;
	
	@Override
	public CustomerInsuranceInfo searchCustomerInsurance(Connection conn, String customerId) {
		boolean closeConnection = true;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustomerInsuranceInfo customer = null;
        try{
        	if(conn == null) {
				conn = commonRepo.getConnection();
				closeConnection = true;
        	}else {
        		closeConnection = false;
        	}
			
        	StringBuilder sql = new StringBuilder();
			sql.append(" SELECT cus.customer_id, cus.customer_name, cus.tel, cus.email, cus.brand, cus.province, cus.model ");
			sql.append(" , cus.insurance_id, DATE_FORMAT(cus.expire_date, '%d/%m/%Y') as expire_date , ins.insurance_name, ins.insurance_type ");
			sql.append(" FROM customer cus, insurance ins ");
			sql.append(" WHERE cus.insurance_id  = ins.insurance_id  ");
			sql.append(" AND cus.customer_id = '"+customerId+"' ");
			
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				customer = new CustomerInsuranceInfo();
				
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setTel(rs.getString("tel"));
				customer.setEmail(rs.getString("email"));
				customer.setBrand(rs.getString("brand"));
				customer.setProvince(rs.getString("province"));
				customer.setModel(rs.getString("model"));
				customer.setInsurnaceId(rs.getString("insurance_id"));
				customer.setInsuranceName(rs.getString("insurance_name"));
				customer.setInsuranceType(rs.getString("insurance_type"));
				customer.setExpireDate(rs.getString("expire_date"));
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
        return customer;
	}

	@Override
	public List<InsuranceInfo> searchInsuranceListForRenew(Connection conn, String insuranceType) {
		boolean closeConnection = true;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<InsuranceInfo> list = new ArrayList<InsuranceInfo>();
        try{
        	if(conn == null) {
				conn = commonRepo.getConnection();
				closeConnection = true;
        	}else {
        		closeConnection = false;
        	}
        	
        	StringBuilder sql = new StringBuilder();
			sql.append(" SELECT insurance_id, insurance_name, insurance_type, box1, box2, box3, box4, remark ");
			sql.append(" FROM insurance  ");
			sql.append(" WHERE   ");
			if("1".equals(insuranceType)) {
				sql.append(" insurance_id in (1) ");
			}else if("2".equals(insuranceType)) {
				sql.append(" insurance_id in (1,2) ");
			}else if("3".equals(insuranceType)) {
				sql.append(" insurance_id in (1,2,3) ");
			}
			sql.append(" order by insurance_id ");
			
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while(rs.next()){
				InsuranceInfo ins = new InsuranceInfo();
				
				ins.setInsuranceId(rs.getString("insurance_id"));
				ins.setInsuranceName(rs.getString("insurance_name"));
				ins.setInsuranceType(rs.getString("insurance_type"));
				ins.setBox1(rs.getString("box1"));
				ins.setBox2(rs.getString("box2"));
				ins.setBox3(rs.getString("box3"));
				ins.setBox4(rs.getString("box4"));
				ins.setRemark(rs.getString("remark"));
				list.add(ins);
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
        return list;
	}
}
