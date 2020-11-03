package OctopusConsortium.Core.Transformers.RCS;


import java.math.BigInteger;
import java.util.UUID;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery;
import OctopusConsortium.RepeatCallerServiceV1.AddressListType;
import OctopusConsortium.RepeatCallerServiceV1.AddressType;
import OctopusConsortium.RepeatCallerServiceV1.AuditIdentityType;
import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;
import OctopusConsortium.RepeatCallerServiceV1.DistributionHeaderType;
import OctopusConsortium.RepeatCallerServiceV1.HandlingSpecType;
import OctopusConsortium.RepeatCallerServiceV1.IdentityType;
import OctopusConsortium.RepeatCallerServiceV1.ManifestItemType;
import OctopusConsortium.RepeatCallerServiceV1.ManifestType;
import OctopusConsortium.RepeatCallerServiceV1.PayloadType;
import OctopusConsortium.RepeatCallerServiceV1.PayloadsType;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;

public class ToDistributionEnvelope extends AbstractMessageTransformer {
	
	private CommonValues commonValues;
	private String interactionId;
	private int recipientId;
	private String businessDeliveryAddressUri;
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
	
	public String getInteractionId() {
		return interactionId;
	}

	public void setInteractionId(String interactionId) {
		this.interactionId = interactionId;
	}

	public int getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(int recipientId) {
		this.recipientId = recipientId;
	}
	
	public String getBusinessDeliveryAddressUri() {
		return businessDeliveryAddressUri;
	}

	public void setBusinessDeliveryAddressUri(String value) {
		this.businessDeliveryAddressUri = value;
	}

	public ToDistributionEnvelope() throws JAXBException
	{
		super();
		//this.registerSourceType(DataTypeFactory.STRING);
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Models.RCS.QUPAMT000001GB01RepeatCallerQuery.class));	
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument.class));
		this.setReturnDataType(DataTypeFactory.create(DistributionEnvelopeType.class));
	}
	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {
		DistributionEnvelopeType returnObj = null;
		OctopusConsortium.Models.RCS.ObjectFactory modelFactory = new OctopusConsortium.Models.RCS.ObjectFactory();
		Object src = message.getPayload();	
		commonValues = new CommonValues(ods,orgName);
		
		JAXBElement<?> jax_payload;
		if(src instanceof QUPAMT000001GB01RepeatCallerQuery)
		{	
			jax_payload = modelFactory.createRepeatCallerQuery((QUPAMT000001GB01RepeatCallerQuery)src);			
			
			returnObj = createEnvelope(CommonValues.REPEATCALLER_QUERY_SERVICE,
					CommonValues.REPEATCALLER_QUERY_PROFILE,
					"urn:nhs-itk:interaction:nhs111RepeatCallerSyncQueryResp-v1-0",
					"application/cda+xml",
					"",
					null,
					0,
					jax_payload);
		}
		else if(src instanceof POCDMT000002UK01ClinicalDocument)
		{
			//TODO if interaction missing throw exception? according to spec it is optional			
			if(message.getOutboundPropertyNames().contains("interactionId"))
				interactionId = message.getOutboundProperty("interactionId");

			if(message.getOutboundPropertyNames().contains("recipientId"))
				recipientId = message.getOutboundProperty("recipientId");
			
			jax_payload = modelFactory.createClinicalDocument((POCDMT000002UK01ClinicalDocument)src);
			
			POCDMT000002UK01ClinicalDocument cda = (POCDMT000002UK01ClinicalDocument)src;
			String recipientODS = "";
			
			if (cda.getInformationRecipient() != null && cda.getInformationRecipient().size() > 0) {
				if (cda.getInformationRecipient().get(0).getIntendedRecipient() != null && 
					cda.getInformationRecipient().get(0).getIntendedRecipient().getReceivedOrganization() != null &&
					cda.getInformationRecipient().get(0).getIntendedRecipient().getReceivedOrganization().getId()!=null &&
					cda.getInformationRecipient().get(0).getIntendedRecipient().getReceivedOrganization().getId().size() > 0 &&
					cda.getInformationRecipient().get(0).getIntendedRecipient().getReceivedOrganization().getId().get(0).getExtension() != null) {
					recipientODS = cda.getInformationRecipient().get(0).getIntendedRecipient().getReceivedOrganization().getId().get(0).getExtension();
					
				}
			}
		
			returnObj = createEnvelope(CommonValues.REPEATCALLER_REPORT_SERVICE,
					CommonValues.REPEATCALLER_REPORT_PROFILE,
					interactionId,
					//"application/cda+xml",//mimetype = 
					"text/xml",
					recipientODS,
					null,
					recipientId,
					jax_payload);
		}
		
		return returnObj;
	}
		
	private DistributionEnvelopeType createEnvelope(String service,String profile,String interactionId, String mimetype, String recipientODS, String customPayloadId, int recipientId, JAXBElement<?> jax_payload)
	{
		
		OctopusConsortium.RepeatCallerServiceV1.ObjectFactory serviceFactory = new OctopusConsortium.RepeatCallerServiceV1.ObjectFactory();
	
		DistributionEnvelopeType envelope = serviceFactory.createDistributionEnvelopeType();
		DistributionHeaderType header = serviceFactory.createDistributionHeaderType();
		
		header.setService(service);
				
		PayloadType payloadType = serviceFactory.createPayloadType();	
		if(customPayloadId != null)
		{
			payloadType.setId("uuid_" + UUID.fromString(customPayloadId).toString().toUpperCase());
		}
		else {
			payloadType.setId("uuid_" + UUID.randomUUID().toString().toUpperCase());
		}
		payloadType.getAny().add(jax_payload);
		
		PayloadsType payloads  = serviceFactory.createPayloadsType();
		payloads.getPayload().add(payloadType);
		payloads.setCount(new BigInteger( Integer.toString(payloads.getPayload().size()) ));
		envelope.setPayloads(payloads);
				
		header.setTrackingid(UUID.randomUUID().toString().toUpperCase());
		
		//add address list to header of distribution envelope
		AddressListType addressType = serviceFactory.createAddressListType();
		if (recipientODS != "") {
			
			AddressType address1 = serviceFactory.createAddressType();
			address1.setUri(CommonValues.ODS_ADDRESS_BLANK + recipientODS);
			addressType.getAddress().add(address1);
		}
		if (recipientId != 0) {
			AddressType address2 = serviceFactory.createAddressType();
			address2.setUri(String.valueOf(recipientId));
			address2.setType("2.16.840.1.113883.2.1.3.2.4.18.44");
			addressType.getAddress().add(address2);
			
		}
		if (!addressType.getAddress().isEmpty()){
			header.setAddresslist(addressType);
		}
		
		AuditIdentityType auditIdentityType = serviceFactory.createAuditIdentityType();
		IdentityType identityType = serviceFactory.createIdentityType();
		identityType.setUri(commonValues.ODS_URI);
		auditIdentityType.getId().add(identityType);
		header.setAuditIdentity(auditIdentityType);
		
		//should be an itemType for each payload item but we only have one..
		ManifestItemType manifestItemType = serviceFactory.createManifestItemType();
		manifestItemType.setMimetype(mimetype);
		
		ManifestType manifestType = serviceFactory.createManifestType();		
		manifestType.setCount(new BigInteger( Integer.toString(payloads.getPayload().size()) ) );		
		PayloadType payloadT = (PayloadType)payloads.getPayload().get(0);
		manifestItemType.setId( payloadT);		
		manifestItemType.setProfileid(profile);
		manifestType.getManifestitem().add(manifestItemType);
		
		header.setManifest(manifestType);	
		
		if(interactionId!=null && interactionId.trim()!="")
		{
			header.setHandlingSpecification(serviceFactory.createHandlingType());
			HandlingSpecType handlingSpec = serviceFactory.createHandlingSpecType();
			handlingSpec.setKey("urn:nhs-itk:ns:201005:interaction");
			handlingSpec.setValue(interactionId);
			header.getHandlingSpecification().getSpec().add(handlingSpec);
		}
		envelope.setHeader(header);		
		
		return envelope;
	}

	
}
