package th.co.toyota.bw0.web.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.web.customer.form.CustomerExpireForm;

@Controller
@RequestMapping("customer/customerExpireList")
public class CustomerExpireListController extends BaseController {

	private static final String VIEW_NAME = "CustomerList";
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initial(HttpServletRequest request, CustomerExpireForm form) throws CommonErrorException {
		ModelAndView mv = new ModelAndView(VIEW_NAME);
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		
		mv.addObject(AppConstants.MV_FORM, form);
		mv.addObject(AppConstants.MV_PAYLOAD, payload);
		
		return mv;
	}
}
