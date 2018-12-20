package th.co.toyota.bw0.web.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import th.co.toyota.application.model.CustomerExpireInfo;
import th.co.toyota.application.model.Payload;
import th.co.toyota.application.model.ServiceStatus;
import th.co.toyota.application.model.XmlPayload;
import th.co.toyota.application.web.BaseController;
import th.co.toyota.bw0.api.constants.AppConstants;
import th.co.toyota.bw0.api.exception.common.CommonErrorException;
import th.co.toyota.bw0.web.customer.form.CustomerExpireForm;
import th.co.toyota.bw0.web.customer.service.CSTCustomerListService;

@Controller
@RequestMapping("customer/customerExpireList")
public class CustomerExpireListController extends BaseController {

	private static final String VIEW_NAME = "WBW08000";
	
	@Autowired
	private CSTCustomerListService service;

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView initial(HttpServletRequest request, CustomerExpireForm form) throws CommonErrorException {
		ModelAndView mv = new ModelAndView(VIEW_NAME);
		Payload payload = new XmlPayload();
		populatePayloadForDisplay(VIEW_NAME, payload, RequestContextUtils.getLocale(request));
		form.setEnableCriteriaName(false);
		
		mv.addObject(AppConstants.MV_FORM, form);
		mv.addObject(AppConstants.MV_PAYLOAD, payload);
		
		return mv;
	}
	
	@RequestMapping(value="/search", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Object searchData(CustomerExpireForm form, HttpServletRequest request, RequestContext context) {
		Payload payload = new XmlPayload();
		ServiceStatus status = ServiceStatus.OK;
		
		List<CustomerExpireInfo> listCustomer = new ArrayList<CustomerExpireInfo>();
		try {
			populatePayloadForDisplay(VIEW_NAME, payload, RequestContextUtils.getLocale(request));
//			service.searchCustomerExpireData(null, form.getcName(), form.getCurrentDate(), null);
			listCustomer = service.searchCustomerExpireData(form.getcName(), form.getCurrentDate(), form.getiExpirePeriod());
			
//			for (int i=1; i<=form.getiExpirePeriod(); i++) {
//				CustomerExpireInfo c = new CustomerExpireInfo();
//				c.setCustomerId("C" + (i));
//				c.setCustomerName("Name " + (i));
//				c.setExpireDate("20/01/2019");
//				c.setInsurnaceId("1");
//				
//				listCustomer.add(c);
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		payload.setStatus(status);
		return listCustomer;
	}
}
