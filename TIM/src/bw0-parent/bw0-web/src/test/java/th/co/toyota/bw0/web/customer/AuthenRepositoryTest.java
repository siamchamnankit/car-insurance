package th.co.toyota.bw0.web.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.base.Strings;

import th.co.toyota.application.config.AppConfig;
import th.co.toyota.application.web.repository.ISTAuthenRepository;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.api.service.common.UserInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class AuthenRepositoryTest {
	
	@Autowired
	private ISTAuthenRepository repository;
	
	@Autowired
	private IBW00000Repository commonRepository;
	

	String username = "prathan";
	String password = "3Nj0Y8319";
	Connection conn = null;
	
	@Before
	public void setUp() {
//		conn = commonRepository.getConnection();
//		assertEquals("Open Connection","Open Connection");
	}
	
	@Test
	public void getUserAuthenWithCorrectUsernameAndPasswordDataShouldBeHaveData() {
		UserInfo userInfo = repository.authen(username, password);
		
		assertEquals("ประธาน ด่านสกุลเจริญกิจ", userInfo.getName());
		assertEquals("prathan", userInfo.getUserName());
		assertEquals("3Nj0Y8319", userInfo.getUserPass());
	}
	
	@Test
	public void getUserAuthenWithIncorrectUsernameDataShouldBeNull() {
		username = "prathanxxx";
		
		UserInfo userInfo = repository.authen(username, password);

		assertTrue(Strings.isNullOrEmpty(userInfo.getName()));
		assertTrue(Strings.isNullOrEmpty(userInfo.getUserName()));
		assertTrue(Strings.isNullOrEmpty(userInfo.getUserPass()));
	}

	@Test
	public void getUserAuthenWithIncorrectPasswordDataShouldBeNull() {
		password = "incorrectPassword";
		
		UserInfo userInfo = repository.authen(username, password);
		
		assertTrue(Strings.isNullOrEmpty(userInfo.getName()));
		assertTrue(Strings.isNullOrEmpty(userInfo.getUserName()));
		assertTrue(Strings.isNullOrEmpty(userInfo.getUserPass()));
	}
	
	@Test
	public void getUserAuthenWithIncorrectUsernameAndPasswordDataShouldBeNull() {
		username = "prathanxxxxx";
		password = "incorrectPassword";
		
		UserInfo userInfo = repository.authen(username, password);
		
		assertTrue(Strings.isNullOrEmpty(userInfo.getName()));
		assertTrue(Strings.isNullOrEmpty(userInfo.getUserName()));
		assertTrue(Strings.isNullOrEmpty(userInfo.getUserPass()));
	}

	
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
