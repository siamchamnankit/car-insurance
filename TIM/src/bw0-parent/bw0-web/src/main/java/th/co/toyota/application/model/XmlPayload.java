package th.co.toyota.application.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import th.co.toyota.bw0.form.common.CBW01000BaseForm;

@XmlRootElement
public class XmlPayload implements Payload, Serializable {
	private static final long serialVersionUID = -6515504143197214112L;

	private String screenId;
	private String screenDescription;
	private ServiceStatus serviceStatus;

	private List<String> errorMessages;
	private List<String> infoMessages;
	private List<String> warningMessages;

	// Log Monitoring

    private List<List<String[]>> groupLogsDisplay;
	private String focusId;


	// Batch Status
	private List<?> listBatchStatus;
	private String appLogURL;


	// Excen Download

	private int totalRecord;
	// about screen
	private String enhancement;
	// Data Table
	private List<List<String>> dataList;
	
	private List objectsInfoList;
	private List objectsInfo2List;
	private CBW01000BaseForm objectForm;
	
	//Common Operation Screen
	private List<String> errorHighlight;
	
	/*
	 * Operation Common screen
	 */
	private String screenMode;
	private String jsonProcessCurrent;
	
	// pagination
	private int firstResult;
	private int rowsPerPage;
	private int totalRows;
	
	private String appId;
	private String appId2;
	private Map<String, String> fields;

	public XmlPayload() {
		errorMessages = new ArrayList<String>();
		infoMessages = new ArrayList<String>();
		warningMessages = new ArrayList<String>();
		fields = new HashMap<String, String>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getScreenId()
	 */
	@Override
	@XmlElement
	public String getScreenId() {
		return this.screenId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#setScreenId(java.lang.String)
	 */
	@Override
	public void setScreenId(String id) {
		this.screenId = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getScreenDescription()
	 */
	@Override
	@XmlElement
	public String getScreenDescription() {
		return this.screenDescription;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#setScreenDescription(java.lang
	 * .String)
	 */
	@Override
	public void setScreenDescription(String desc) {
		this.screenDescription = desc;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getStatus()
	 */
	@Override
	@XmlElement
	public ServiceStatus getStatus() {
		return this.serviceStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#setStatus(th.co.toyota.application
	 * .model.ServiceStatus)
	 */
	@Override
	public void setStatus(ServiceStatus status) {
		this.serviceStatus = status;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getDateTimeNow()
	 */
	@Override
	@XmlElement
	public String getDateTimeNow() {
		return new SimpleDateFormat("dd MMM yyyy HH:mm").format(new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getDateTimeNowSec()
	 */
	@Override
	@XmlElement
	public String getDateTimeNowSec() {
		return new SimpleDateFormat("dd MMM yyyy HH:mm:ss").format(new Date());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getHaveMessages()
	 */
	@Override
	@XmlElement
	public Boolean getHaveMessages() {
		if (!infoMessages.isEmpty() || !errorMessages.isEmpty()
				|| !warningMessages.isEmpty()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#addErrorMessage(java.lang.String)
	 */
	@Override
	public void addErrorMessage(String message) {
		this.errorMessages.add(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#addInfoMessage(java.lang.String)
	 */
	@Override
	public void addInfoMessage(String message) {
		this.infoMessages.add(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#addWarningMessage(java.lang.String
	 * )
	 */
	@Override
	public void addWarningMessage(String message) {
		this.warningMessages.add(message);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getErrorMessages()
	 */
	@Override
	@XmlElement
	public List<String> getErrorMessages() {
		return errorMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#addErrorMessages(java.util.List)
	 */
	public void addErrorMessages(List<String> messages) {
		if (messages != null) {
			this.errorMessages.addAll(messages);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getInfoMessages()
	 */
	@Override
	@XmlElement
	public List<String> getInfoMessages() {
		return infoMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#addInfoMessages(java.util.List)
	 */
	@Override
	public void addInfoMessages(List<String> messages) {
		if (messages != null) {
			this.infoMessages.addAll(messages);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getWarningMessages()
	 */
	@Override
	@XmlElement
	public List<String> getWarningMessages() {
		return warningMessages;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#addWarningMessages(java.util.List)
	 */
	@Override
	public void addWarningMessages(List<String> messages) {
		if (messages != null) {
			this.warningMessages.addAll(messages);
		}
	}



	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getFocusId()
	 */
	@Override
	public String getFocusId() {
		return this.focusId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#setFocusId(java.lang.String)
	 */
	@Override
	public void setFocusId(String id) {
		this.focusId = id;
	}

	// End Log Monitoring





	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#setTotalRecord(int)
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}




	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getEnhancement()
	 */
	public String getEnhancement() {
		return enhancement;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#setEnhancement(java.lang.String)
	 */
	public void setEnhancement(String enhancement) {
		this.enhancement = enhancement;
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getBatchStatusList()
	 */
	@Override
	public List<?> getBatchStatusList() {
		return listBatchStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#setBatchStatusList(java.util.List)
	 */
	@Override
	public void setBatchStatusList(List<?> listBatchStatus) {
		this.listBatchStatus = listBatchStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see th.co.toyota.application.model.Payload#getAppLogURL()
	 */
	@Override
	public String getAppLogURL() {
		return appLogURL;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * th.co.toyota.application.model.Payload#setAppLogURL(java.lang.String)
	 */
	@Override
	public void setAppLogURL(String appLogURL) {
		this.appLogURL = appLogURL;
	}

	
	@Override
	public List<List<String>> getDataList() {
		return dataList;
	}

	@Override
	public void setDataList(List<List<String>> dataList) {
		this.dataList = dataList;
	}

	@Override
	public int getFirstResult() {
		return firstResult;
	}

	@Override
	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	@Override
	public int getRowsPerPage() {
		return rowsPerPage;
	}

	@Override
	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	@Override
	public int getTotalRows() {
		return totalRows;
	}

	@Override
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	@Override
	public void setScreenMode(String screenMode) {
		this.screenMode = screenMode;
	}

	@Override
	public String getScreenMode() {
		return screenMode;
	}

	
	@Override
	public List<String> getErrorHighlight() {
		return errorHighlight;
	}
	
	@Override
	public void setErrorHighlight(List<String> errorHighlight) {
		this.errorHighlight = errorHighlight;
	}

	@Override
	public List getObjectsInfoList() {
		return this.objectsInfoList;
	}

	@Override
	public void setObjectsInfoList(List objectsInfoList) {
		this.objectsInfoList = objectsInfoList;
	}
	
	@Override
	public List getObjectsInfo2List() {
		return this.objectsInfo2List;
	}

	@Override
	public void setObjectsInfo2List(List objectsInfo2List) {
		this.objectsInfo2List = objectsInfo2List;
	}

	public String getJsonProcessCurrent() {
		return jsonProcessCurrent;
	}

	public void setJsonProcessCurrent(String jsonProcessCurrent) {
		this.jsonProcessCurrent = jsonProcessCurrent;
	}

	@Override
	public CBW01000BaseForm getObjectForm() {
		return this.objectForm;
	}

	@Override
	public void setObjectForm(CBW01000BaseForm form) {
		this.objectForm = form;		
	}
	
	@Override
	public String getAppId() {
		return this.appId;
	}

	@Override
	public void setAppId(String aplid) {
		this.appId = aplid;
	}

	@Override
	public String getAppId2() {
		return this.appId2;
	}

	@Override
	public void setAppId2(String aplid2) {
		this.appId2 = aplid2;
	}


	/**
	 * @return the fields
	 */
	public Map<String, String> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	public void setFields(Map<String, String> fields) {
		this.fields = fields;
	}



	@Override
	public Map<Character, String> getReportStatusData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReportStatusData(Map<Character, String> reportStatusData) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}