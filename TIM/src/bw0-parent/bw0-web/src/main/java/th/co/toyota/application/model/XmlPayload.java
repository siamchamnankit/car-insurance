package th.co.toyota.application.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	private String focusId;




	// Data Table
	private List<List<String>> dataList;
	
	private Object objectInfo;
	private List objectsInfoList;
	private CBW01000BaseForm objectForm;
	
	//Common Operation Screen
	private List<String> errorHighlight;
	
	/*
	 * Operation Common screen
	 */
	private String screenMode;
	private String jsonProcessCurrent;
	


	public XmlPayload() {
		errorMessages = new ArrayList<String>();
		infoMessages = new ArrayList<String>();
		warningMessages = new ArrayList<String>();
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



	
	@Override
	public List<List<String>> getDataList() {
		return dataList;
	}

	@Override
	public void setDataList(List<List<String>> dataList) {
		this.dataList = dataList;
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
	public Object getObjectInfo() {
		return this.objectInfo;
	}

	@Override
	public void setObjectInfo(Object objectInfo) {
		this.objectInfo = objectInfo;
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
	public Map<Character, String> getReportStatusData() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReportStatusData(Map<Character, String> reportStatusData) {
		// TODO Auto-generated method stub
	}
}