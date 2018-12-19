package th.co.toyota.application.web.repository;

import java.sql.Connection;

import th.co.toyota.bw0.api.service.common.UserInfo;


public interface ISTAuthenRepository {

	public UserInfo authen(Connection conn, String userName, String password);
	
}
