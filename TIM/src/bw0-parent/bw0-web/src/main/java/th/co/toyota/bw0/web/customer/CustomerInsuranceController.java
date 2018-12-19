package th.co.toyota.bw0.web.customer;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.commons.lang.exception.ExceptionUtils;
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
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.api.repository.common.IBW00000Repository;
import th.co.toyota.bw0.api.service.common.CBW00000CommonService;
import th.co.toyota.bw0.web.master.form.CST33060Form;
import th.co.toyota.bw0.api.service.common.UserInfo;

@Controller
@RequestMapping("customer/insuranceDetailList")
public class CustomerInsuranceController extends BaseController {
	final Logger logger = LoggerFactory.getLogger(CustomerInsuranceController.class);
	private static final String VIEW_NAME = "WBW09000";
	
	@Autowired
	protected Validator validator;
	
	@Autowired
	protected CBW00000CommonService commonService;

	@Autowired
	private IBW00000Repository commonRepository;


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
			
		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			status = ServiceStatus.NG;
		}
		payload.setStatus(status);
		return mv;
	}
	
	
}
