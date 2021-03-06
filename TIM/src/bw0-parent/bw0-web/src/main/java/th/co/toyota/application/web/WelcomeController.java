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

import java.util.List;
import java.util.Locale;
import java.util.Set;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.google.common.base.Strings;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.form.AuthenForm;
import th.co.toyota.application.web.repository.ISTAuthenRepository;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.api.service.common.UserInfo;
import th.co.toyota.bw0.web.master.form.CST33060Form;

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

	@Autowired
	ISTAuthenRepository repo;
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
	
	@RequestMapping(value="/login", method = {RequestMethod.POST,RequestMethod.GET}, produces = "application/json")
	public @ResponseBody Object searchData(AuthenForm form, HttpServletRequest request, RequestContext context
			, @RequestParam String username, @RequestParam String password) {
		logger.info("Searching Information.");
		
//		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		UserInfo userInfo = repo.authen(username, password);
		return userInfo;
		
	}
	
	
}
