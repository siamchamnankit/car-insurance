/******************************************************
 * Program History
 * 
 * Project Name	            :  st3-web-template
 * Client Name				:  TMAP-EM
 * Package Name             :  th.co.toyota.application.model
 * Program ID 	            :  Payload.java
 * Program Description	    :  A applcation data load.
 * Environment	 	        :  Java 7
 * Author					:  danilo
 * Version					:  1.0
 * Creation Date            :  Feb 28, 2014
 *
 * Modification History	    :
 * Version	   Date		   Person Name		Chng Req No		Remarks
 *
 * Copyright(C) 2015-TOYOTA Motor Asia Pacific. All Rights Reserved.             
 ********************************************************/
package th.co.toyota.application.model;

import java.util.List;
import java.util.Map;

import th.co.toyota.bw0.form.common.CBW01000BaseForm;

/**
 * API is load by every controller request to set up or initialize the screen.
 * 
 * @author danilo
 * 
 */
public interface Payload {
	String getDateTimeNow();

	String getDateTimeNowSec();

	String getScreenId();

	void setScreenId(String id);

	String getScreenDescription();

	void setScreenDescription(String desc);

	ServiceStatus getStatus();

	void setStatus(ServiceStatus status);

	List<String> getErrorMessages();

	void addErrorMessage(String message);

	void addErrorMessages(List<String> messages);

	List<String> getInfoMessages();

	void addInfoMessage(String message);

	void addInfoMessages(List<String> messages);

	List<String> getWarningMessages();

	void addWarningMessage(String message);

	void addWarningMessages(List<String> messages);

	Boolean getHaveMessages();

	String getFocusId();

	void setFocusId(String id);
	

	Map<Character, String> getReportStatusData();

	void setReportStatusData(Map<Character, String> reportStatusData);


	// end about screen.
	
	// START: data table
	void setDataList(List<List<String>> dataList);
	List<List<String>> getDataList();
	// END: data table

	List getObjectsInfoList();
	void setObjectsInfoList(List objectsInfoList);
	
	CBW01000BaseForm getObjectForm();
	void setObjectForm(CBW01000BaseForm form);
	
	Object getObjectInfo();
	void setObjectInfo(Object objectInfo);
	
	/*
	 * For Operation Common screen
	 */
	void setScreenMode(String screenMode);
	String getScreenMode();

	List<String> getErrorHighlight();
	void setErrorHighlight(List<String> errorHighlight);
	
	String getJsonProcessCurrent();
	void setJsonProcessCurrent(String jsonProcessCurrent);
}
