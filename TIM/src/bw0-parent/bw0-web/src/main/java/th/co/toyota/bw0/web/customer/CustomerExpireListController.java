package th.co.toyota.bw0.web.customer;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.web.master.form.CST33060Form;

public class CustomerExpireListController extends BaseController {

	private static final String VIEW_NAME = "CustomerList";
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initial(HttpServletRequest request, CST33060Form form) throws CommonErrorException {
		ModelAndView mv = new ModelAndView(VIEW_NAME);
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		
		return mv;
	}
}
