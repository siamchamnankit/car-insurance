/******************************************************
 * Program History
 * 
 * Project Name	            :  st-server-webapp-template
 * Client Name				:  TMAP-EM
 * Package Name             :  th.co.toyota.application.web
 * Program ID 	            :  BaseController.java
 * Program Description	    :  A base controller for ST3-web controllers.
 * Environment	 	        :  Java 7
 * Author					:  danilo
 * Version					:  1.0
 * Creation Date            :  Apr 7, 2014
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2015-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.application.web;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.web.form.IST30000Form;

import th.co.toyota.bw0.api.service.common.UserInfo;

/**
 * Base controller For ST3 web controllers to control there actions. This
 * controller helps to get the following details:
 * <ul>
 * <li>A current user session details.
 * <li>The current user access controls.
 * <li>Populate payload details.
 * <li>Process the validation messages for different screens.
 * <li>Format the message as per the message resource details.
 * 
 * @author danilo
 * 
 */
@Controller
public class BaseController {

	/** A file logger instance. */
	final Logger logger = LoggerFactory.getLogger(this.getClass());

	/** A spring validator. */
	@Autowired
	protected Validator validator;

	/** A application message resource. */
	@Autowired
	protected MessageSource messageSource;
	

	/**
	 * Processes the all validation error messages.
	 * 
	 * @param contraintVaiolationArray {@link ConstraintViolation} array.
	 * @param locale A local 
	 * @param form A Web From
	 * @return List of messages.
	 */
	protected List<String> processErrorMessageFromValidator(
			Object[] contraintVaiolationArray, Locale locale, IST30000Form form) {
		List<String> errorMessages = new ArrayList<String>();
		for (Object obj : contraintVaiolationArray) {
			ConstraintViolation<?> cv = (ConstraintViolation<?>) obj;
			errorMessages.add(reinterpolateMessage(cv, locale, form));
		}

		return errorMessages;
	}

	/**
	 * Format all validation messages as per the application resource
	 * configuration and display on screen.
	 * 
	 * @param cv {@link ConstraintViolation} array.
	 * @param local A local 
	 * @param form A Web From
	 * @return A message.
	 */
	protected String reinterpolateMessage(ConstraintViolation<?> cv,
			Locale local, IST30000Form form) {
		String message = null;

		String errorCode = cv.getMessageTemplate();
		errorCode = errorCode.substring(1, errorCode.length() - 1);

//		// handle empty messages
//		if (CST30000Messages.ERROR_MESSAGE_EMPTY_FIELD.equals(errorCode)) {
//			message = messageSource.getMessage(errorCode, new String[] { form
//					.displayFriendlyField(cv.getPropertyPath().toString()) },
//					local);
//		} else if (CST30000Messages.ERROR_MESSAGE_INVALID_FIELD
//				.equals(errorCode)) {
//			message = messageSource.getMessage(errorCode, new String[] { form
//					.displayFriendlyField(cv.getPropertyPath().toString()) },
//					local);
//		} else if (CST30000Messages.ERROR_MESSAGE_INVALID_FORMAT
//				.equals(errorCode)) {
//			Class<? extends IST30000Form> c = form.getClass();
//			try {
//				Field m = c.getDeclaredField(cv.getPropertyPath().toString());
//				m.setAccessible(true);// Access to Private Field
//				Pattern anno = m.getAnnotation(Pattern.class);
//				String regExpAnnotation = String.valueOf(anno.regexp());
//				message = messageSource
//						.getMessage(
//								errorCode,
//								new String[] {
//										form.displayFriendlyField(cv
//												.getPropertyPath().toString()),
//										regExpAnnotation }, local);
//			} catch (Exception e) {
//				logger.debug("Error Exception {}", e);
//				message = e.toString();
//			}
//		} else {
//			message = messageSource.getMessage(
//					CST30000Messages.ERROR_UNDEFINED_ERROR, new String[] { form
//							.displayFriendlyField(cv.getPropertyPath()
//									.toString()) }, local);
//		}

		return message;

	}

	/**
	 * This method use to populate {@link Payload} details.
	 * 
	 * @param viewName a screen name.
	 * @param payload A {@link Payload} instance.
	 * @param locale A local
	 * @return Same {@link Payload} instance
	 */
	protected Payload populatePayloadForDisplay(String viewName,
			Payload payload, Locale locale) {
		if (payload != null) {
			try {
				payload.setScreenId(viewName);
				payload.setScreenDescription(messageSource.getMessage("ST3."
						+ viewName + ".Description", null, locale));
			} catch (Throwable t) {
				logger.error("Error retrieving Screen ID and Description.", t);
			}
		}

		return payload;
	}

	/**
	 * Returns the current logged in user session.
	 * 
	 * @param request
	 *            A request.
	 * @return A user session {@link CSC22110UserInfo}
	 */
	protected UserInfo getUserInSession(HttpServletRequest request) {
		return new UserInfo();
	}


	protected String getAppIdLink(String moduleId, String functionId, String appId){
		return "<a id='openLogByAppId' class='appIdLink' moduleId='"+moduleId+"' functionId='"+functionId+"' appId='"+appId+"'>"+appId+"</a>";
	}

}
