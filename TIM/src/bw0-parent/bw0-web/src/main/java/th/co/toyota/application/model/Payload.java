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
	

	// End Log Monitoring


	// End System Master


	// End System Master

	// Start Batch Status
	List<?> getBatchStatusList();

	void setBatchStatusList(List<?> listBatchStatus);

	String getAppLogURL();

	void setAppLogURL(String appLogURL);

	// End System Status

	// Start Excel Download Monitoring


	Map<Character, String> getReportStatusData();

	void setReportStatusData(Map<Character, String> reportStatusData);

	// End Excel Download Monitoring

	// about screen
	String getEnhancement();

	void setEnhancement(String enhancement);

	// end about screen.
	
	// START: data table
	void setDataList(List<List<String>> dataList);
	List<List<String>> getDataList();
	// END: data table



	int getTotalRecord();

	void setTotalRecord(int totalRecord);

	// START: pagination
	int getFirstResult();

	void setFirstResult(int firstResult);

	int getRowsPerPage();

	void setRowsPerPage(int rowsPerPage);

	int getTotalRows();

	void setTotalRows(int totalRows);
	// END: pagination
	List getObjectsInfoList();
	void setObjectsInfoList(List objectsInfoList);
	
	CBW01000BaseForm getObjectForm();
	void setObjectForm(CBW01000BaseForm form);
	
	List getObjectsInfo2List();
	void setObjectsInfo2List(List objectsInfo2List);
	
	/*
	 * For Operation Common screen
	 */
	void setScreenMode(String screenMode);
	String getScreenMode();

	List<String> getErrorHighlight();
	void setErrorHighlight(List<String> errorHighlight);
	
	String getJsonProcessCurrent();
	void setJsonProcessCurrent(String jsonProcessCurrent);
	public String getAppId();
	public void setAppId(String aplid);
	public String getAppId2();
	public void setAppId2(String aplid2);
	
	
	public void setFields(Map<String, String> params);
	public Map<String, String> getFields();
}
