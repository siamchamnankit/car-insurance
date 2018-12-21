package th.co.toyota.bw0.web.customer;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import th.co.toyota.application.config.AppConfig;
import th.co.toyota.application.model.CustomerExpireInfo;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.web.customer.repository.ISTCustomerListRepository;
import th.co.toyota.bw0.web.customer.service.CSTCustomerListService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerListServiceTest {
	@Autowired
	private IBW00000Repository commonRepository;
	
	@Autowired
	private ISTCustomerListRepository repository;
	
	@Autowired
	private CSTCustomerListService service;
	List<CustomerExpireInfo> customerList = new ArrayList<CustomerExpireInfo>();
	String customerName = "" ;
	String curDate      = "";
	int preiod          = 0 ;
	
	Connection conn = null;
	
	@Before
	public void setUp() {
//		conn = commonRepository.getConnection();
//		assertEquals("Open Connection","Open Connection");
	}
	
	
	@Test
	public void TestSearchCustomerExpirePreiodValue0ShowValue0() throws Exception {
		curDate = "15/12/2018";
		preiod  = 0;
		customerList = repository.generateSearchQuery(customerName, curDate, preiod);
		assertEquals("Insurance Expire within should be between 1 and 12 ", "0", Integer.toString(customerList.size()));
	}
	@Test
	public void TestSearchCustomerExpirePreiodValueMoreThen12ShowValue13() throws Exception {
		curDate = "15/12/2018";
		preiod  = 13;
		customerList = repository.generateSearchQuery(customerName, curDate, preiod);
		assertEquals("Insurance Expire within should be between 1 and 12 ", "0", Integer.toString(customerList.size()));
	}
	
	@Test
	public void TestSearchCustomerExpireDateValus15122018To15062018ShowDetail() throws Exception {
		curDate = "15/12/2018";
		preiod  = 6;
		customerList = repository.generateSearchQuery(customerName, curDate, preiod);
		assertNotSame("Found Detail Customer 15/12/2018 - 15/06/2018 (Customer total : "+Integer.toString(customerList.size())+" )", "0", Integer.toString(customerList.size()));
	}
	
//	@Test
//	public void TestSearchCustomerExpireDateValus01122018To01052018ShowDetail() throws Exception {
//		curDate = "01/06/2018";
//		preiod  = 6;
//		customerList = repository.generateSearchQuery(customerName, curDate, preiod);
//		assertEquals("Found Detail Customer 01/12/2018 - 01/05/2018 (Customer total : "+Integer.toString(customerList.size())+" )", "0", Integer.toString(customerList.size()));
//	}
//	
//	@Test
//	public void TestSearchCustomerExpireDateValus31122019To30062019ShowDetail() throws Exception {
//		curDate = "31/12/2019";
//		preiod  = 6;
//		customerList = repository.generateSearchQuery(customerName, curDate, preiod);
//		assertEquals("Found Detail Customer 31/12/2019 - 30/06/2019 (Customer total : "+Integer.toString(customerList.size())+" )", "0", Integer.toString(customerList.size()));
//	}
//	
	@After
	public void close() {
		try {
			if(conn!=null && !conn.isClosed()){
//				conn.close();
//				assertEquals("Closed Connection","Closed Connection");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
