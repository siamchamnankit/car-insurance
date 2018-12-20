package th.co.toyota.bw0.web.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.toyota.application.config.AppConfig;
import th.co.toyota.application.model.InsuranceInfo;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.web.customer.repository.ISTCustomerInsuranceRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerInsuranceRepositoryTest {
	
	@Autowired
	private ISTCustomerInsuranceRepository repository;
	
	@Autowired
	private IBW00000Repository commonRepository;
	

	Connection conn = null;
	
	@Before
	public void setUp() {
		conn = commonRepository.getConnection();
		assertEquals("Open Connection","Open Connection");
	}

	@Test
	public void listAllInsuranceForRenewOfInsuranceType1() {
		String insuranceType = "1";
		List<InsuranceInfo> insuranceList = repository.searchInsuranceListForRenew(conn, insuranceType);
		assertNotNull("Found insurance ",insuranceList);
		assertEquals(1, insuranceList.size());
		for(int i = 0; i < insuranceList.size(); i++) {
			InsuranceInfo insRenew = insuranceList.get(i);
			assertEquals("1", insRenew.getInsuranceType());
		}
	}
	
	@Test
	public void listAllInsuranceForRenewOfInsuranceType2() {
		String insuranceType = "2";
		List<InsuranceInfo> insuranceList = repository.searchInsuranceListForRenew(conn, insuranceType);
		assertNotNull("Found insurance ",insuranceList);
		assertEquals(2, insuranceList.size());
		for(int i = 0; i < insuranceList.size(); i++) {
			InsuranceInfo insRenew = insuranceList.get(i);
			if(i == 0) {
				assertEquals("1", insRenew.getInsuranceType());
			}else if(i == 1) {
				assertEquals("2", insRenew.getInsuranceType());
			}
		}
	}
	
	@Test
	public void listAllInsuranceForRenewOfInsuranceType3() {
		String insuranceType = "3";
		List<InsuranceInfo> insuranceList = repository.searchInsuranceListForRenew(conn, insuranceType);
		assertNotNull("Found insurance ",insuranceList);
		assertEquals(3, insuranceList.size());
		for(int i = 0; i < insuranceList.size(); i++) {
			InsuranceInfo insRenew = insuranceList.get(i);
			if(i == 0) {
				assertEquals("1", insRenew.getInsuranceType());
			}else if(i == 1) {
				assertEquals("2", insRenew.getInsuranceType());
			}else if(i == 2) {
				assertEquals("3", insRenew.getInsuranceType());
			}
		}
	}
	
	@After
	public void close() {
		try {
			if(conn!=null && !conn.isClosed()){
				conn.close();
				assertEquals("Closed Connection","Closed Connection");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
