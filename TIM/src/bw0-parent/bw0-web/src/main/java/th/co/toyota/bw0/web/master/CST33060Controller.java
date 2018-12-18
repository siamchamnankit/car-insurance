/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM : 
 * Client Name				:  TDEM
 * Package Name             :  th.co.toyota.bw0.web.master
 * Program ID 	            :  CST33060Controller.java
 * Program Description	    :  <put description>
 * Environment	 	        :  Java 7
 * Author					:  Thanapon T.
 * Version					:  1.0
 * Creation Date            :  October 10, 2018
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2013-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.bw0.web.master;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.codehaus.jackson.map.ObjectMapper;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.api.service.common.CBW00000CommonService;
import th.co.toyota.bw0.util.ComboValue;
import th.co.toyota.bw0.util.JsonStringToObjectConverter;
import th.co.toyota.bw0.web.master.form.CST33060Form;
import th.co.toyota.bw0.web.master.service.CST33060Service;
import th.co.toyota.bw0.api.service.common.UserInfo;
import th.co.toyota.st3.api.constants.CST30000Messages;
import th.co.toyota.st3.api.exception.SystemDoesNotExistsException;
import th.co.toyota.st3.api.exception.UnableToCreateExcelForDowloadException;

import com.google.common.base.Strings;

@Controller
@RequestMapping("master/systemMaster")
public class CST33060Controller extends BaseController {
	final Logger logger = LoggerFactory.getLogger(CST33060Controller.class);
	private static final String VIEW_NAME = "WST33060";
	
	@Value("${projectCode}")
	protected String PROJECT_CODE;
	
	@Autowired
	protected Validator validator;
	
	@Autowired
	protected CBW00000CommonService commonService;

	@Autowired
	private IBW00000Repository commonRepository;

	@Autowired
	private JsonStringToObjectConverter jsonConverter;
	
	@Autowired
	private CST33060Service service;
	
	
	/** A report name use by this screen. */
	final String reportName = "SystemMaster";
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initial(HttpServletRequest request, CST33060Form form) throws CommonErrorException {
		logger.info("Initial form is initated.");
		
		ModelAndView mv = new ModelAndView(VIEW_NAME);
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		try {	
			payload = populatePayloadForDisplay(VIEW_NAME, payload, RequestContextUtils.getLocale(request));
			payload.setStatus(ServiceStatus.OK);
			UserInfo userInfo = getUserInSession(request);
			
			//mv.addObject(AppConstants.MV_USER_COMPANY, this.getUserCompany(userInfo));
			mv.addObject(AppConstants.MV_USER, userInfo);
			mv.addObject(AppConstants.MV_FORM, form);
			mv.addObject(AppConstants.MV_PAYLOAD, payload);
			
			int rowsPerPage = commonRepository.getRowPerPage(VIEW_NAME);
			form.setRowsPerPage(rowsPerPage);
			
			//service.loadCombobox(userInfo, form);
		//}catch (CommonErrorException e){
		//	logger.error(ExceptionUtils.getStackTrace(e));
		//	status = ServiceStatus.NG;
		//	payload.addErrorMessage(messageSource.getMessage(e.getMessageCode(), e.getMessageArg(), Locale.getDefault()));
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			status = ServiceStatus.NG;
			payload.addErrorMessage(messageSource.getMessage(CST30000Messages.ERROR_UNDEFINED_ERROR, new String[] { e.getMessage() },
					RequestContextUtils.getLocale(request)));
		}
		payload.setStatus(status);
		return mv;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object searchData(CST33060Form form, HttpServletRequest request, RequestContext context) {
		logger.info("Searching Information.");
		
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		try{
			Set<ConstraintViolation<CST33060Form>> errors = validator.validate(form);
			List<String> errorList = form.validate(messageSource, RequestContextUtils.getLocale(request), AppConstants.ACTION_SEARCH, payload);

			if ((!errors.isEmpty()) || (!errorList.isEmpty())) {
				errorList.addAll(processErrorMessageFromValidator(errors.toArray(), RequestContextUtils.getLocale(request), new CST33060Form()));
				status = ServiceStatus.NG;
				payload.addErrorMessages(errorList);
			}else{	
				payload = populatePayloadForDisplay(VIEW_NAME, payload, RequestContextUtils.getLocale(request));
				boolean isFound = service.searchAllData(form, payload, request);
				
				UserInfo userInfo = getUserInSession(request);
				//service.loadCombobox(userInfo, form);
				//List<ComboValue> subCategoryList = service.loadSubCategory(form.getCategorySearch());
				//form.setSubCategoryList(subCategoryList);
				payload.setObjectForm(form);
				
				form.setMessageResult(request.getParameter("messageResult"));
				if (!isFound && Strings.isNullOrEmpty(form.getMessageResult())) {
					status = ServiceStatus.NG;
					payload.addErrorMessage(messageSource.getMessage(CST30000Messages.ERROR_MESSAGE_DATA_NOT_FOUND, new String[] {},
							Locale.getDefault()));
				}
			}
		} catch (CommonErrorException e){
			logger.error(ExceptionUtils.getStackTrace(e));
			status = ServiceStatus.NG;
			payload.addErrorMessage(messageSource.getMessage(e.getMessageCode(), e.getMessageArg(), Locale.getDefault()));
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			status = ServiceStatus.NG;
			payload.addErrorMessage(messageSource.getMessage(CST30000Messages.ERROR_UNDEFINED_ERROR, new String[] { e.getMessage() },
					RequestContextUtils.getLocale(request)));
		}
		payload.setStatus(status);
		return payload;
		
	}
	
	
}
