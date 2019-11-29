package OctopusConsortium.Core.Transformers.ITK;

import java.util.UUID;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Core.Transformers.RCS.CDAHelper;
import OctopusConsortium.Models.RCS.II;
import OctopusConsortium.Models.RCS.ObjectFactory;
import OctopusConsortium.Models.RCS.POCDMT000002UK01Authorization;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.Models.RCS.POCDMT000002UK01InformationRecipient;
import OctopusConsortium.Models.RCS.POCDMT000002UK01RecordTarget;
import OctopusConsortium.Models.RCS.XBasicConfidentialityKind;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;

public class SubmitEncounterToServiceToCDA_UK extends AbstractMessageTransformer {
	public SubmitEncounterToServiceToCDA_UK() {	
		super();
		//this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest.class));
		//this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument.class));
	}
	
	CommonValues commonValues;
	CDAHelper cdaHelper;
	protected String pathwaysCaseEncoded;
	protected String ods;
	protected String orgName;
	
	public String getOds() {
		return ods;
	}

	public void setOds(String ods) {
		this.ods = ods;
	}
	
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPathwaysCaseEncoded() {
		return pathwaysCaseEncoded;
	}

	public void setPathwaysCaseEncoded(String pathwaysCaseEncoded) {
		this.pathwaysCaseEncoded = pathwaysCaseEncoded;
	}

	private void validate(SubmitEncounterToServiceRequest payload) throws TransformerException	{
		//need a disposition code, so the call queue knows where to route this to
		if (payload.getCaseDetails().getDispositionCode().isEmpty() || payload.getCaseDetails().getDispositionCode() == null) {
			InvalidMessageException e = new InvalidMessageException("No disposition code provided");
			throw new TransformerException(this, e);
		}
		
		if (payload.getCaseDetails().getJourneyId() != null){
			UUID generateUUID = null;
			try {
				generateUUID = UUID.fromString(payload.getCaseDetails().getJourneyId());
			}
			catch (IllegalArgumentException e){}
			
			if (generateUUID == null){
				InvalidMessageException e = new InvalidMessageException("Journey Id must be a unique identifier");
				throw new TransformerException(this, e);
			}
		}
		
		//dob 
		if (payload.getPatientDetails().getDateOfBirth()==null 
				|| ( payload.getPatientDetails().getDateOfBirth().getDob() == null && payload.getPatientDetails().getDateOfBirth().getYearOfBirth() == null &&  payload.getPatientDetails().getDateOfBirth().getAge() == null )
				|| ( payload.getPatientDetails().getDateOfBirth().getDob() != null && !payload.getPatientDetails().getDateOfBirth().getDob().isValid() ) 
				|| ( payload.getPatientDetails().getDateOfBirth().getYearOfBirth() != null && payload.getPatientDetails().getDateOfBirth().getYearOfBirth() < 1800)) {
			InvalidMessageException e = new InvalidMessageException("Need to provide a valid patient date of birth");
			throw new TransformerException(this, e);
		}
						
		//informant type
		if (payload.getPatientDetails().getInformantType() == null) {
			InvalidMessageException e = new InvalidMessageException("Need to provide patient informant type");
			throw new TransformerException(this, e);
		}
		
		//gender 
		if (payload.getPatientDetails().getGender() == null) {
			InvalidMessageException e = new InvalidMessageException("Need to provide patient gender");
			throw new TransformerException(this, e);
		}
		
		//current address - ensure we have some detail completed
		if ((payload.getPatientDetails().getCurrentAddress() != null) && 
				(payload.getPatientDetails().getCurrentAddress().getPostalCode() == null || 
				payload.getPatientDetails().getCurrentAddress().getPostalCode().isEmpty())) {
			InvalidMessageException e = new InvalidMessageException("Need to provide patients current address");
			throw new TransformerException(this, e);
		}
		
		//validate service details passed back
		if (payload.getServiceDetails() == null || 
				payload.getServiceDetails().getId() < 1 ||
				payload.getServiceDetails().getOdsCode() == null ||
				payload.getServiceDetails().getOdsCode().isEmpty() ||
				payload.getServiceDetails().getName() == null) {
			InvalidMessageException e = new InvalidMessageException("Service to refer encounter on to has incomplete details. odscode, name");
			throw new TransformerException(this, e);
		}
	}

	protected Address convertAddress(String address){ 

		Address convertedAddress = new Address();
		
		if (address == null) {
			return convertedAddress;
		}
		
		//split by comma
		String[] addressList = address.split("\\,",-1); 

		//I'm sure there's a more efficient way of doing this...
		if (addressList.length > 0) {
			convertedAddress.setStreetAddressLine1(addressList[0]);
		
			if (addressList.length > 1) {
				convertedAddress.setStreetAddressLine2(addressList[1]);
			
				if (addressList.length > 2) {
					convertedAddress.setStreetAddressLine3(addressList[2]);
				
					if (addressList.length > 3) {
						convertedAddress.setStreetAddressLine4(addressList[3]);
					
						if (addressList.length > 4) {
							convertedAddress.setStreetAddressLine5(addressList[4]);
						}
					}
				}
			}
		}
		
		return convertedAddress;
	}
	
	public Object transformMessage(MuleMessage message, String enc) throws TransformerException {
		Object src = message.getPayload();
		commonValues = new CommonValues(ods,orgName);
		cdaHelper = new CDAHelper(commonValues);
		
		if (src instanceof SubmitEncounterToServiceRequest)
		{
			SubmitEncounterToServiceRequest payload = (SubmitEncounterToServiceRequest)src;

			validate(payload);
			
			if (message.getInvocationProperty("pathwaysCaseEncoded") != null && message.getInvocationProperty("pathwaysCaseEncoded") instanceof String){
				setPathwaysCaseEncoded((String)message.getInvocationProperty("pathwaysCaseEncoded"));
			}
			
			POCDMT000002UK01ClinicalDocument cda = new POCDMT000002UK01ClinicalDocument();
			
			ObjectFactory of = new ObjectFactory();		
			
			try {
				cda.setClassCode("DOCCLIN");
				cda.getMoodCode().add("EVN");
				
				cda.setCode(of.createCE());
				cda.getCode().setCode("819551000000100");
				cda.getCode().setCodeSystem("2.16.840.1.113883.2.1.3.2.4.15");
				cda.setConfidentialityCode(of.createCE());
				cda.getConfidentialityCode().setCode(XBasicConfidentialityKind.N.toString());
				cda.getConfidentialityCode().setCodeSystem("2.16.840.1.113883.1.11.16926");
				cda.getConfidentialityCode().setDisplayName("normal");
				
				cda.setEffectiveTime(of.createTS());
				cda.getEffectiveTime().setValue(CDAHelper.ClinicalDocumentEffectiveTimeString());
				
				cda.setId(of.createII());
				cda.getId().setRoot(UUID.randomUUID().toString().toUpperCase());		
				cda.setMessageType(of.createMessageType());
				cda.getMessageType().setRoot("2.16.840.1.113883.2.1.3.2.4.18.17");
				cda.getMessageType().setExtension("POCD_MT200001GB02");		
				cda.setSetId(of.createII());
				cda.getSetId().setRoot(UUID.randomUUID().toString().toUpperCase());
				cda.setTitle(of.createST());
				cda.getTitle().setContent("NHS 111 Report");
				cda.setTypeId(of.createPOCDMT000002UK01InfrastructureRootTypeId());
				cda.getTypeId().setRoot("2.16.840.1.113883.1.3");
				cda.getTypeId().setExtension("POCD_HD000040");
				cda.setVersionNumber(of.createINT());
				cda.getVersionNumber().setValue(CommonValues.HASC_VERSION);
				
				cda.getAuthor().add(cdaHelper.CreateNamedAuthor(of, commonValues.getOrganisation_Name()));
				
				byte[] summary = new byte[0];
				if (pathwaysCaseEncoded != null && !pathwaysCaseEncoded.isEmpty()){
					summary = pathwaysCaseEncoded.getBytes();
				}
				
				//StructuredBody
				cda.setComponent(of.createPOCDMT000002UK01Component2());
				cda.getComponent().setTypeCode("COMP");
				cda.getComponent().setContextConductionInd(true);
				cda.getComponent().setStructuredBody(CDAHelper.createStructuredBody(of,payload.getCaseDetails(), summary, payload.getServiceDetails()));
				
				//encompassingEncounter
				cda.setComponentOf(of.createPOCDMT000002UK01Component1());
				cda.getComponentOf().setTypeCode("COMP");
				cda.getComponentOf().setContentId(of.createTemplateContent());
				cda.getComponentOf().getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
				cda.getComponentOf().getContentId().setExtension("COCD_TP146232GB01#EncompassingEncounter");		
				cda.getComponentOf().setEncompassingEncounter(CallQueueHelper.CreateEncompassingEncounter(of,payload.getCaseDetails(),payload.getPatientDetails()));
				
				//Custodian
				cda.setCustodian(cdaHelper.CreateCustodian(of));
				
				//TODO update the DocumentationOf list from  information in the hasc using 'INFRM' class code
				//cda.getDocumentationOf().add(e)
					
				POCDMT000002UK01InformationRecipient informationRecipient = of.createPOCDMT000002UK01InformationRecipient();
				
				informationRecipient.setTypeCode("PRCP");
				informationRecipient.setContentId(of.createTemplateContent());
				informationRecipient.getContentId().setRoot("2.16.840.1.113883.2.1.3.2.4.18.16");
				//TODO check what template to use. At present its only Organization:
				//	RecipientOrganizationUniversal (COCD_TP145203GB03)
				//	RecipientPersonUniversal (COCD_TP145202GB02)
				//	RecipientWorkgroupUniversal (COCD_TP145204GB03)

				GPPractice recipientDetails = new GPPractice();
				Address recipientAddress = convertAddress(payload.getServiceDetails().getAddress());
				
				//recipientAddress.setStreetAddressLine1(payload.getServiceDetails().getAddress());
				//recipientAddress.setStreetAddressLine2(getRecipientAddress2());
				//recipientAddress.setStreetAddressLine3(getRecipientAddress3());
				//recipientAddress.setStreetAddressLine4(getRecipientAddress4());
				//recipientAddress.setStreetAddressLine5(getRecipientAddress5());
				recipientAddress.setPostalCode(payload.getServiceDetails().getPostcode());
				recipientDetails.setAddress(recipientAddress);
				
				String recipientId = payload.getServiceDetails().getOdsCode();
				recipientDetails.setODS(payload.getServiceDetails().getOdsCode());
				recipientDetails.setName(payload.getServiceDetails().getName());
				
				informationRecipient.getContentId().setExtension("COCD_TP145203GB03#IntendedRecipient");				
				informationRecipient.setIntendedRecipient(CDAHelper.CreateInformationRecipientOrganizationUniversal(of, recipientDetails, recipientId));
			
				cda.getInformationRecipient().add(informationRecipient);
				
				//patient
				POCDMT000002UK01RecordTarget patient = cdaHelper.CreateRecordTarget(of,payload.getPatientDetails(), payload.getCaseDetails().getExternalReference(), payload.getCaseDetails().getJourneyId());
				cda.getRecordTarget().add(patient);
				
				
				//An informant is a person who informed the author about information contained in the CDA document. 
				cda.getInformant().add(CDAHelper.createInformant(of,payload.getPatientDetails()));
				
				//authorization
				POCDMT000002UK01Authorization authorization = CDAHelper.CreateAuthorizationSection(of);
				cda.getAuthorization().add(authorization);
				
			} catch (Exception e) {		
				throw new TransformerException(this,e);
			}

			message.setPayload(cda);
		}

		return message;
	}
}