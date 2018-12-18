/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM : 
 * Client Name				:  TMAP-EM
 * Package Name             :  th.co.toyota.bw0.api.service.common
 * Program ID 	            :  CBW00000CommonService.java
 * Program Description	    :  <put description>
 * Environment	 	        :  Java 7
 * Author					:  Thanapon T.
 * Version					:  1.0
 * Creation Date            :  July 14, 2016
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2013-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.bw0.api.service.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import th.co.toyota.bw0.api.repository.common.IBW00000Repository;

@Service
public class CBW00000CommonService{

	@Autowired
	private IBW00000Repository repository;

	@Autowired
	protected MessageSource messageSource;

	
	@Value("${projectCode}")
	protected String PROJECT_CODE;
	
	@Value("${pu_phase_test}")
	protected String PU_PHASE_TEST;	
	
	//Index parameter for delete Rundwon Kompo Status
	final int IDX_VERSION = 0;
	final int IDX_GETSUDO_MONTH = 1;
	final int IDX_TIMING = 2;
	final int IDX_VEHICLE_PLANT = 3;
	final int IDX_VEHICLE_MODEL = 4;
	final int IDX_UNIT_PLANT = 5;
	final int IDX_UNIT_TYPE = 6;
	final int IDX_UNIT_MODEL = 7;

	public UserInfo getUserInfo(HttpServletRequest request) {
		UserInfo userInfo = new UserInfo();//(CSC22110UserInfo) request.getSession()				.getAttribute(CSC22110Constant.SESSION_USER_INFO);
		if("true".equalsIgnoreCase(PU_PHASE_TEST)){
			String ipAddress = request.getHeader("X-FORWARDED-FOR");
			if (ipAddress == null) {
				ipAddress = request.getRemoteAddr();
			}
	
			try{
				HashMap<String, String> userMap = repository.getUserInfoForTestOnFTH(ipAddress);
				
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return userInfo;
	}

	



}
