package OctopusConsortium.Core.Transformers.NhsdWebservices;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Models.CDA.InformantType;
import OctopusConsortium.Service.Models.DataInstance;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.SubmitToCallQueueEnquiryRequest;

public class SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheck extends
//AbstractMessageTransformer
AbstractTransformer {

	/**
	 * 
	 */
	public SubmitToCallEnquiryToSubmitEnquiryWithoutAvailabilityCheck() {	
		super();		
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitToCallQueueEnquiryRequest.class));
		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.NhsdWebservices.OesEnquiry.class));		
	}
	
	@Override
	protected Object doTransform(Object payload, String enc)
			throws TransformerException {
		SubmitToCallQueueEnquiryRequest EnquiryRequest = (SubmitToCallQueueEnquiryRequest)payload;
		OctopusConsortium.NhsdWebservices.OesEnquiry result = new OctopusConsortium.NhsdWebservices.OesEnquiry();
		
		String gender = "";
		if(EnquiryRequest.getPatientDetails().getGender()==Gender.MALE){
			gender = "M";
		}else if(EnquiryRequest.getPatientDetails().getGender()==Gender.FEMALE){
			gender = "F";
		}else{
			throw new TransformerException(this, new InvalidMessageException("unsupported gender for NhsdWebservices.OesEnquiry"));
		}
		
		String enquiryText;
		String medsInfoText;
		
		try {
			enquiryText = getEnquiryText(EnquiryRequest);
			medsInfoText = getMedsInfoText(EnquiryRequest);
		} 		
		catch (Exception e) {			
			e.printStackTrace();
			throw new TransformerException(this,e);
			//throw new TransformerException(this, new InvalidMessageException("invalid CaseSummary NhsdWebservices.OesEnquiry.CaseDetails"));
		}	
		
		result.setSecure(false);
		result.setPartner("NHSDirect");
		result.setPartnerPassword("Mu4uyaZ9");
		
		result.setEmailAddress(EnquiryRequest.getPatientDetails().getEmailAddress());
		
		if(EnquiryRequest.getPatientDetails().getDateOfBirth()!=null){
			if(EnquiryRequest.getPatientDetails().getDateOfBirth().getDob()!=null){
				result.setDob(EnquiryRequest.getPatientDetails().getDateOfBirth().getDob());	
			}else if(EnquiryRequest.getPatientDetails().getDateOfBirth().getYearOfBirth()!=null){
				XMLGregorianCalendar dob;
				try {
					GregorianCalendar today = new GregorianCalendar();
					//subtract one day to avoid validation failure when submitting to the service
					today.add(Calendar.DAY_OF_MONTH, -1);
					dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(today);
					dob.setYear(EnquiryRequest.getPatientDetails().getDateOfBirth().getYearOfBirth());
					result.setDob(dob);	
				} catch (DatatypeConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}
		
		result.setGender(gender);
		
		if(EnquiryRequest.getPatientDetails().getCurrentAddress() != null) {
			result.setPostcode(EnquiryRequest.getPatientDetails().getCurrentAddress().getPostalCode()==null ? "" : EnquiryRequest.getPatientDetails().getCurrentAddress().getPostalCode());
		}
		
		try
		{
			if (result.getPostcode() == null || result.getPostcode().length() == 0)
			{
				//try and fetch it from summary
				List<DataInstance> caseItems = EnquiryRequest.getCaseDetails().getCaseSummary();
				for (int i = 0; i < caseItems.size(); i++) {
					if(caseItems.get(i).getName().equals("Display_Location")){
						result.setPostcode(caseItems.get(i).getValues().get(0));
					}				
				} 
				
				if (result.getPostcode() == null || result.getPostcode().length() == 0)
				{
					throw new InvalidMessageException("missing postcode from current address or Display_Location from case summary.");
				}
			}
			//TA: Hack ahoy!
			//the old, creaky nhsd web service was designed to accept a "full" post code - or near as we could get.
			//if we don't get passed a long enough post code, add a space to the end so it passes.
			else if (result.getPostcode().length() <= 2)
			{
				result.setPostcode(result.getPostcode() + "  ");
			}
			
			if(result.getPostcode().length() > 10){
				if(result.getPostcode().indexOf(",") > -1){
					String pst = result.getPostcode().substring(0,result.getPostcode().indexOf(","));
					result.setPostcode(pst);
				}else{
					result.setPostcode(result.getPostcode().substring(0,9));
				}
			}
		} 		
		catch (Exception e) {			
			e.printStackTrace();
			throw new TransformerException(this,e);
			//throw new TransformerException(this, new InvalidMessageException("invalid CaseSummary NhsdWebservices.OesEnquiry.CaseDetails"));
		}
		
				
		result.setEthnicity("Prefer not to say");
		result.setEnquiry(enquiryText);
		result.setLevelOfInfo("Advanced");
		result.setMedsInfo(medsInfoText);
		result.setPassword("");
		result.setSubject("Self");
		
		return result;
	}
	
	private String getEnquiryText(SubmitToCallQueueEnquiryRequest enquiryRequest)  {
		//create the text
		//added checks for nulls so we don't pass nulls on to the web service.
		StringBuffer sb = new StringBuffer (100000);
		if (enquiryRequest.getCaseDetails().getConditionTitle() != null) {
			sb.append(enquiryRequest.getCaseDetails().getConditionTitle());	
		}
		if (enquiryRequest.getCaseDetails().getExternalReference() != null) {
			sb.append("\nHASC reference: ").append(enquiryRequest.getCaseDetails().getExternalReference());
		}
		if (enquiryRequest.getCaseDetails().getDispositionName() != null) {
			sb.append("\nDisposition: ").append(enquiryRequest.getCaseDetails().getDispositionName());
		}
		if (enquiryRequest.getCaseDetails().getDispositionCode() != null) {
			sb.append("\nDisposition Code: ").append(enquiryRequest.getCaseDetails().getDispositionCode());
		}
		//user details
		if (enquiryRequest.getPatientDetails().getForename() != null) {		
			sb.append("\n\nForename: ").append(enquiryRequest.getPatientDetails().getForename());
		}
		if (enquiryRequest.getPatientDetails().getSurname() != null) {
			sb.append("\nSurname: ").append(enquiryRequest.getPatientDetails().getSurname());
		}
		if(enquiryRequest.getPatientDetails().getCurrentAddress() != null){
			sb.append("\nCurrent address: ").append(enquiryRequest.getPatientDetails().getCurrentAddress().toString());
		}
		if(enquiryRequest.getPatientDetails().getHomeAddress() != null){
			sb.append("\nHome address: ").append(enquiryRequest.getPatientDetails().getHomeAddress().toString());	
		}
		if(enquiryRequest.getPatientDetails().getTelephoneNumber() != null) {
		sb.append("\nTelephone: ").append(enquiryRequest.getPatientDetails().getTelephoneNumber());
		}
		if (enquiryRequest.getPatientDetails().getNhsNumber() != null) {
		sb.append("\nNHS Number : ").append(enquiryRequest.getPatientDetails().getNhsNumber());
		}
		
		if(enquiryRequest.getPatientDetails().getInformantType() != InformantType.Self){
			sb.append("\nInformant Type : ").append(enquiryRequest.getPatientDetails().getInformantType().toString());
			sb.append("\nInformant Name : ").append(enquiryRequest.getPatientDetails().getInformantContactName());
		}
		
		if(enquiryRequest.getCaseDetails().getCaseSummary() != null){
			for(DataInstance dataI : enquiryRequest.getCaseDetails().getCaseSummary()){
				if(dataI.getCaption()!=null){
					sb.append( dataI.getCaption() ).append(": ");
					for (String value : dataI.getValues()) {
						sb.append(value).append("\n");
					}
				}
			}
		}
		return sb.toString();
	}
/*
	private String getEnguireTextXml(SubmitToCallQueueEnquiryRequest enquiryRequest)  {
	
		 
        //create the text
		StringBuffer sb = new StringBuffer (100000);
		sb.append(enquiryRequest.getCaseDetails().getQueryType());	
		sb.append("\n\nCall reason: ").append(enquiryRequest.getCaseDetails().getCallReason());
		sb.append("\nHASC title: ").append(enquiryRequest.getCaseDetails().getExternalReference());
		//user details
		sb.append("\n\nForename: ").append(enquiryRequest.getPatientDetails().getForename());
		sb.append("\nSurname: ").append(enquiryRequest.getPatientDetails().getSurname());
		sb.append("\nCurrent address: ").append(enquiryRequest.getPatientDetails().getCurrentAddress().toString());			
		sb.append("\nTelephone: ").append(enquiryRequest.getPatientDetails().getTelephoneNumber());	
		sb.append("\nNHS Number : ").append(enquiryRequest.getPatientDetails().getNhsNumber());
		
				
		org.dom4j.Document doc = null;
		
		try {
			doc = DocumentHelper.parseText(enquiryRequest.getCaseDetails().getCaseSummary().trim());
			//SAXReader reader = new SAXReader(); 
			//doc = reader.read( new InputSource( new StringReader( enquiryRequest.getCaseDetails().getCaseSummary() ) ) );
		} catch (DocumentException e) {			
			//e.printStackTrace();
			return enquiryRequest.getCaseDetails().getCaseSummary();
		}	
		
		List<org.dom4j.Node> nodes = doc.selectNodes( "/ArrayOfDataInstance/DataInstance" );
		sb.append("\n");
		for (org.dom4j.Node node : nodes) {			
			org.dom4j.Node val = (org.dom4j.Node) node.selectSingleNode("Caption");
			if( val!=null && val.getText().length() > 0 ){
				sb.append( val.getText() ).append(": ");
						
				List<org.dom4j.Node> values = node.selectNodes("Values/Value");
				for (org.dom4j.Node value : values) {
					sb.append(value.getText()).append("\n");
				}	
			}
        }
		
		return sb.toString();
	}
	*/
	/*
	private String getEnguireTextByName_(SubmitToCallQueueEnquiryRequest enquiryRequest) throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
		factory.setNamespaceAware(true); // never forget this!
	    DocumentBuilder builder; 
	    Document document = null;
	    	    	      
        builder = factory.newDocumentBuilder();  
        try{
        	document = builder.parse( new InputSource( new StringReader( enquiryRequest.getCaseDetails().getCaseSummary() ) ) ); 
            document.getDocumentElement().normalize();
        }
        catch(Exception e){
        	return enquiryRequest.getCaseDetails().getCaseSummary();
        }
        
        xPathfactory = XPathFactory.newInstance();
        xpath = xPathfactory.newXPath(); 
		
	    //create the text
		StringBuffer sb = new StringBuffer (100000);
		sb.append(enquiryRequest.getCaseDetails().getQueryType());
		sb.append(enquiryRequest.getCaseDetails().getQueryType());
		sb.append("\nHASC title: ").append(getStringValue("HASC", document));
		//user details
		sb.append("\n\nForename: ").append(enquiryRequest.getPatientDetails().getForename());
		sb.append("\nSurname: ").append(enquiryRequest.getPatientDetails().getSurname());
		sb.append("\nHome address: ").append(getStringValue("Home_address", document));
		sb.append("\nHome postcode: ").append(getStringValue("Postcode", document));
		//sb.append("\nHome postcode: ").append(enquiryRequest.getPatientDetails().getPostcode());//in object or key value pair?
		
		sb.append("\nCurrent address: ").append(enquiryRequest.getPatientDetails().getCurrentAddress());
		sb.append("\nCurrent postcode: ").append(enquiryRequest.getPatientDetails().getCurrentAddress().getPostalCode());		
		sb.append("\nCurrent location identifier: ").append(getStringValue("Current_location_Identifier", document));
		sb.append("\nTelephone: ").append(enquiryRequest.getPatientDetails().getTelephoneNumber());	
		sb.append("\nRelationship to patient: ").append(getStringValue("Relationship_To_Patient", document));	
		//enquiryRequest.getPatientDetails().getInformantType() == InformantType.SELF
		
		//details
		sb.append("\n\nQuery: ").append(getStringValue("Query", document));
		//sb.append("\n\nCall reason: ").append(getStringValue("Call_Reason", document));
		sb.append("\n\nCall reason: ").append(enquiryRequest.getCaseDetails().getCallReason());
		sb.append("\nGP care provider: ").append(getStringValue("GP_Care_Provider", document));
		sb.append("\nService provider ID : ").append(getStringValue("Service_Provider_ID", document));
		sb.append("\nNHS Number : ").append(enquiryRequest.getPatientDetails().getNhsNumber());
		sb.append("\n\nAllergies: ").append(getStringValue("Allergies", document));
		sb.append("\nBreast Feeding: ").append(getStringValue("Breast_Feeding", document));
		sb.append("\nBreastfeeding age: ").append(getStringValue("Breastfeeding_Age", document));
		sb.append("\nAge of baby (weeks): ").append(getStringValue("Age_Baby", document));
		sb.append("\nWeeks since period: ").append(getStringValue("LMP_Weeks", document));
		sb.append("\nPregnant: ").append(getStringValue("Pregnant", document));
		sb.append("\nMedical conditions: ").append(getStringValue("Medical_Conditions", document));
		sb.append("\nContact option: ").append(getStringValue("Contact_Option", document));
		sb.append("\nDisposition Code: ").append(getStringValue("DispositionCode", document));
		sb.append("\nSymptom discriminators: ").append(getStringValue("SymptomDiscriminatorList", document));
		sb.append("\nSymptom group: ").append(getStringValue("SymptomGroup", document));
		sb.append("\nSymptom choice: ").append(getStringValue("Symptom_choice", document));
		sb.append("\nTravel destination: ").append(getStringValue("Travel_Destination", document));
		sb.append("\nTravel timing: ").append(getStringValue("Travel_Timing", document));
		sb.append("\nTravel type: ").append(getStringValue("Travel_Type", document));
		sb.append("\nTravel accommodation: ").append(getStringValue("Travel_Accommodation", document));
		sb.append("\nOther information: ").append(getStringValue("Information_Other", document));
		sb.append("\nHASC reference: ").append(getStringValue("Journey_ID", document));
		
		return sb.toString();
	}
	*/
	
	private String getMedsInfoText(SubmitToCallQueueEnquiryRequest enquiryRequest) {
		StringBuffer sb = new StringBuffer();
		if(enquiryRequest.getCaseDetails().getCaseSummary() != null){
			for (DataInstance dataI : enquiryRequest.getCaseDetails().getCaseSummary()){
				if(dataI.getName()=="Medical_Conditions"){
					for(String value : dataI.getValues()){
						sb.append(value).append("\n");
					}
				}
			}
		}
		return sb.toString();
	}
	/*
	private String getMedsInfoTextXml(SubmitToCallQueueEnquiryRequest enquiryRequest) {
				
		org.dom4j.Document doc = null;		
		try {
			doc = DocumentHelper.parseText(enquiryRequest.getCaseDetails().getCaseSummary().trim());
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			return "";
		}
	    //create the text
		StringBuffer sb = new StringBuffer (100000);		
		sb.append(getStringValue("Medical_Conditions", doc));
		
		return sb.toString();
	}
	*/
	

	/*
	XPathFactory xPathfactory;
	XPath xpath;
	private String getStringValue_(String key, Document doc) throws XPathExpressionException {
		
		StringBuffer result = new StringBuffer();		
		Node eml = (Node) xpath.evaluate("/ArrayOfDataInstance/DataInstance[Name/text()= '" + key + "']", doc, XPathConstants.NODE);
		if(eml!=null){
			Node val = (Node) xpath.evaluate("Caption", eml, XPathConstants.NODE);			
			if(val!=null){
				result.append(val.getTextContent().trim());
			}
			
			NodeList vals = (NodeList) xpath.evaluate("Values", eml, XPathConstants.NODESET);
			for(int v = 0; v < vals.getLength(); v++){
				Node value = vals.item(v);
				result.append(value.getTextContent().trim()).append("\n");
			}			
		}
		return result.toString();
	}
*/
	
}
