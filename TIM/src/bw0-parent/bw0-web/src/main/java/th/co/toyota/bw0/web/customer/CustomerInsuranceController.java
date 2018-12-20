package th.co.toyota.bw0.web.customer;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import th.co.toyota.application.model.CustomerInsuranceInfo;
import th.co.toyota.application.model.InsuranceInfo;
import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.api.service.common.CBW00000CommonService;
import th.co.toyota.bw0.api.service.common.UserInfo;
import th.co.toyota.bw0.web.customer.service.CustomerInsuranceService;
import th.co.toyota.bw0.web.master.form.CST33060Form;

@Controller
@RequestMapping("customer/customerInsurance")

public class CustomerInsuranceController extends BaseController {
	final Logger logger = LoggerFactory.getLogger(CustomerInsuranceController.class);
	private static final String VIEW_NAME = "WBW09000";
	
	@Autowired
	protected Validator validator;
	
	@Autowired
	protected CBW00000CommonService commonService;

	
	@Autowired
	private CustomerInsuranceService service;


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initial(HttpServletRequest request, CST33060Form form, @RequestParam String customerId
			, @RequestParam String insuranceType) throws CommonErrorException {
		logger.info("Initial form is initated.");
		
		ModelAndView mv = new ModelAndView(VIEW_NAME);
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		try {
			payload.setStatus(ServiceStatus.OK);
			UserInfo userInfo = getUserInSession(request);
			service.searchAllData(customerId, insuranceType, payload);
			
			CustomerInsuranceInfo custInfo = (CustomerInsuranceInfo)payload.getObjectInfo();
			
			List<InsuranceInfo> insuranceList = payload.getObjectsInfoList();

			
			mv.addObject(AppConstants.MV_USER, userInfo);
			mv.addObject(AppConstants.MV_FORM, form);
			mv.addObject(AppConstants.MV_PAYLOAD, payload);
			mv.addObject("customerInfo", custInfo);
			mv.addObject("insuranceList", insuranceList);

		} catch (Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			status = ServiceStatus.NG;
		}
		payload.setStatus(status);
		return mv;
	}
}
