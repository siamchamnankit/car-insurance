/******************************************************
 * Program History
 * 
 * Project Name	            :  TIM 
 * Client Name				:  TDEM
 * Package Name             ;  th.co.toyota.bw0.form.master
 * Program ID 	            ;  CBW01000BaseForm.java
 * Program Description	    ;  Base Master Form
 * Environment	 	        ;  Java 7
 * Author					:  Thanapon T.
 * Version					:  1.0
 * Creation Date            :  August 9, 2017
 *
 * Modification History	    ;
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2013-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.bw0.form.common;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;

import com.google.common.base.Strings;

import th.co.toyota.application.model.Payload;
import th.co.toyota.application.web.form.IST30000Form;
import th.co.toyota.bw0.api.constants.MessagesConstants;
import th.co.toyota.bw0.util.FormatUtil;

public class CBW01000BaseForm implements IST30000Form {

	String updateKeySet = "";//Separate by |
	public int firstResult = 0;
	public int rowsPerPage = 10;
	
	public String getUpdateKeySet() {
		return updateKeySet;
	}

	public void setUpdateKeySet(String updateKeySet) {
		this.updateKeySet = updateKeySet;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	@Override
	public String displayFriendlyField(String field) {
		return null;
	}
	
	public List<String> validateBigDecimal(String focus, String value, String max, String textName, List<String> errors, MessageSource messageSource, Locale locale, Payload payload) {

		BigDecimal data = FormatUtil.convertStringToBigDecimal(value);
		BigDecimal maxData = FormatUtil.convertStringToBigDecimal(max);
		if (data != null && maxData !=null) {
			if (data.compareTo(maxData)>0) {
				errors.add(messageSource.getMessage(MessagesConstants.A_ERROR_MUST_LESSTHAN_OR_EQUAL,
						new String[]{messageSource.getMessage(textName , null, null), max},
							locale));
				if (Strings.isNullOrEmpty(payload.getFocusId())) {
					payload.setFocusId(focus);
				}
			}
		}
		return errors;
	}
}
