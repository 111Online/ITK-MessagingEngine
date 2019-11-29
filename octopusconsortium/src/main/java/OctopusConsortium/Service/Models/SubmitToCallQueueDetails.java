package OctopusConsortium.Service.Models;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubmitToCallQueueDetails", propOrder = {	    
	    "externalReference",
	    "journeyId",
	    "source",
	    "conditionTitle",
	    "conditionId",
	    "conditionType",
	    "dispositionCode",
	    "dispositionName",	    
	    "caseSummaryItems",
	    "caseStepItems",
	    "provider",
	    "unstructuredData"
	})
public class SubmitToCallQueueDetails {
	
	//protected String caseSummary;
	@XmlElementWrapper(name = "CaseSummary")
	@XmlElement(name = "SummaryItem", required = true)
	protected List<OctopusConsortium.Service.Models.DataInstance> caseSummaryItems;	
	@XmlElement(name = "ExternalReference", required = false)
	protected String externalReference;
	@XmlElement(name = "JourneyId", required = true)
	protected String journeyId;
	@XmlElement(name = "Source", required = false)
	protected String source;
	@XmlElement(name = "conditionTitle", required = false)
	protected String conditionTitle;
	@XmlElement(name = "conditionId", required = false)
	protected String conditionId;
	@XmlElement(name = "conditionType", required = false)
	protected String conditionType;
	@XmlElement(name = "DispositionName", required = true)
	protected String dispositionName;	
	@XmlElement(name = "DispositionCode", required = true)
	protected String dispositionCode;
	@XmlElement(name = "Provider", required = false)
	protected String provider;
	@XmlElement(name = "UnstructuredData", required = false)
	protected String unstructuredData;
	
	@XmlElementWrapper(name = "CaseSteps")
	@XmlElement(name = "StepItem", required = true)
	protected List<OctopusConsortium.Service.Models.StepInstance> caseStepItems;
	
	public List<OctopusConsortium.Service.Models.DataInstance> getCaseSummary(){
		return caseSummaryItems;
	}
	public void setCaseSummary(List<OctopusConsortium.Service.Models.DataInstance> dataItems ){
		caseSummaryItems = dataItems;
	}
	
	public List<OctopusConsortium.Service.Models.StepInstance> getCaseSteps(){
		return caseStepItems;
	}
	public void setCaseSteps(List<OctopusConsortium.Service.Models.StepInstance> stepItems ){
		caseStepItems = stepItems;
	}
	
	public String getUnstructuredData()
	{
		return unstructuredData;
	}
	public void setUnstructuredData(String value)
	{
		unstructuredData = value;
	}
	
	public String getExternalReference()
	{
		return externalReference;
	}
	public void setExternalReference(String value)
	{
		externalReference = value;
	}
	
	//deprecated in v2.0.0
	/*public String getSource()
	{
		return source;
	}
	public void setSource(String value)
	{
		source = value;
	}*/	
	
	public String getDispositionName() {
		return dispositionName;
	}
	public void setDispositionName(String dispositionName) {
		this.dispositionName = dispositionName;
	}
	public String getDispositionCode() {
		return dispositionCode;
	}
	public void setDispositionCode(String dispositionCode) {
		this.dispositionCode = dispositionCode;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public void setConditionTitle(String conditionTitle) {
		this.conditionTitle = conditionTitle;
	}
	public String getConditionTitle(){
		return conditionTitle;
	}
	public void setConditionId(String conditionId) {
		this.conditionId = conditionId;
	}
	public String getConditionId(){
		return conditionId;
	}
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType;
	}
	public String getConditionType(){
		return conditionType;
	}
	public String getJourneyId() {
		return journeyId;
	}
	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}
}
