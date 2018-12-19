/******************************************************
 * Program History
 * 
 * Project Name	            :  st-server-webapp-template
 * Client Name				:  TMAP-EM
 * Package Name             :  th.co.toyota.application.web
 * Program ID 	            :  WelcomeController.java
 * Program Description	    :  Welcome Controller.
 * Environment	 	        :  Java 7
 * Author					:  danilo
 * Version					:  1.0
 * Creation Date            :  Aug 2, 2013
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2013-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.application.web;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.bw0.api.service.common.UserInfo;

/**
 * A welcome controller to display the welcome login screen.
 * 
 * @author Manego
 * 
 */
@Controller
@RequestMapping(value = "/")
public class WelcomeController extends BaseController {
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	/**
	 * THis is the first operation executed for every user session, when user
	 * login to ST3 web application.
	 * <p>
	 * It willDisplaythe welcome message on screen.
	 * 
	 * @param request A http request object.
	 * @return A {@link Payload} object.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
		logger.debug("Welcome view will be renedered.");
		
		String viewName = "WBW00000";
		Payload payload = new XmlPayload();
		payload = populatePayloadForDisplay(viewName, payload,
				RequestContextUtils.getLocale(request));
		payload.setStatus(ServiceStatus.OK);
		
		UserInfo userInfo = new UserInfo();
		
//		EmployeeInfoId empId = new EmployeeInfoId();
//		empId.setCompanyCode(this.getUserCompany(userInfo));
//		empId.setEmployeeCode(userInfo.getEmployeeNo());		
//		EmployeeInfo emp = commonService.findEmployee(empId);
//		
		boolean isExistEmployee = true;
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		
//		int effEndDate = 99991231;
//		int currentDate = Integer.parseInt(sdf.format(FormatUtil.getCurrentDateTime()));
//		if (emp != null && emp.getEffectiveEndDate() != null) {
//			effEndDate = Integer.parseInt(emp.getEffectiveEndDate());
//		}
//				
//		if (emp != null && emp.getActiveFlag() == CBW00000CommonConstants.ACTIVE && currentDate <= effEndDate){
//			isExistEmployee = true;
//		}

		ModelAndView mv = new ModelAndView(viewName);
		mv.addObject("payload", payload);
		mv.addObject("isApplicationUser", isExistEmployee);

		return mv;
	}
	

	
}
