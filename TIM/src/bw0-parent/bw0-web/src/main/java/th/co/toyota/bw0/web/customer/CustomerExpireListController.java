package th.co.toyota.bw0.web.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;

import th.co.toyota.application.model.CustomerExpireInfo;
import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.web.customer.form.CustomerExpireForm;
import th.co.toyota.bw0.web.master.form.CST33060Form;

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
	
	@RequestMapping(value="/search", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object searchData(CustomerExpireForm form, HttpServletRequest request, RequestContext context) {
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		
		payload.setStatus(status);
//		return payload;
		
		List<CustomerExpireInfo> listCustomer = new ArrayList<CustomerExpireInfo>();
		for (int i=0; i<=5; i++) {
			CustomerExpireInfo c = new CustomerExpireInfo();
			c.setCustomerId("C" + (i+1));
			c.setCustomerName("Name " + (i+1));
			c.setExpireDate("20/01/2019");
			c.setInsurnaceId("1");
			
			listCustomer.add(c);
		}
		return listCustomer;
	}
}
