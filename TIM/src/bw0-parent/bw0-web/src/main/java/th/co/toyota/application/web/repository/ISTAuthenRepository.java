package th.co.toyota.application.web.repository;

import th.co.toyota.bw0.api.service.common.UserInfo;


public interface ISTAuthenRepository {

	public UserInfo authen(String userName, String password);
	
}
