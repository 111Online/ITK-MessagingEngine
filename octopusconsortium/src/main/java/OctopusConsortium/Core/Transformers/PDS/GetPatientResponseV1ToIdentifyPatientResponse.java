package OctopusConsortium.Core.Transformers.PDS;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Models.PDS.ADNHSAddressType2;
import OctopusConsortium.Models.PDS.ADXP;
import OctopusConsortium.Models.PDS.COMTMT000016GB01GPPractice;
import OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10;
import OctopusConsortium.Models.PDS.COMTMT000016GB01Patient;
import OctopusConsortium.Models.PDS.EnFamily;
import OctopusConsortium.Models.PDS.EnGiven;
import OctopusConsortium.Models.PDS.EnPrefix;
import OctopusConsortium.Models.PDS.TEL;
import OctopusConsortium.Service.Models.Address;
import OctopusConsortium.Service.Models.GPPractice;
import OctopusConsortium.Service.Models.Gender;
import OctopusConsortium.Service.Models.IdentifyPatientResponse;
import OctopusConsortium.Service.Models.IdentifyPatientResponseOverallStatus;
import OctopusConsortium.Service.Models.Patient;


public class GetPatientResponseV1ToIdentifyPatientResponse extends
		AbstractTransformer {

	public GetPatientResponseV1ToIdentifyPatientResponse()
	{
		super();
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10.class));
		this.setReturnDataType(DataTypeFactory.create(IdentifyPatientResponse.class));
	}
	

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {				
		
		COMTMT000016GB01GetPatientDetailsResponseV10 msg = (COMTMT000016GB01GetPatientDetailsResponseV10) src;
		IdentifyPatientResponse result = new IdentifyPatientResponse();
		
		//check if the response contains a match
		if(PDSResponseValid(msg) && PDSResponseContainsPatient(msg))
		{
			result.setPatient(new Patient());
			COMTMT000016GB01Patient patient = msg.getSubject().getValue().getPatient();
			
			if (patient != null) {
				ExtractNhsNumber(patient,result);
				ExtractGPPractice(patient,result);
				ExtractAddress(patient,result);
								
				result.setOverallStatus(IdentifyPatientResponseOverallStatus.PATIENT_IDENTIFIED);
				
				return result;
			}				
		}	
		
		result.setOverallStatus(IdentifyPatientResponseOverallStatus.UNABLE_TO_IDENTIFY_PATIENT);
		
		return result;
	}

	private boolean PDSResponseContainsPatient(COMTMT000016GB01GetPatientDetailsResponseV10 msg)
	{
		return (msg.getSubject() != null && msg.getSubject().getValue() != null);
	}
	
	private boolean PDSResponseValid(COMTMT000016GB01GetPatientDetailsResponseV10 msg)
	{
		// The codes can be used to identify the status.
		// At present we don't care about the reason only that the patient match is not valid for any reason
		// e.g. code DEMOG-0007 = more than one match
		// e.g. code DEMOG-0001 = no match found
	
		if (msg.getValue() == null || msg.getValue().getCode() == null)
			return true;
	
		List<String> unMatchedErrorCodes = new ArrayList<String>();
		unMatchedErrorCodes.add("DEMOG-0001");
		unMatchedErrorCodes.add("DEMOG-0007");
		unMatchedErrorCodes.add("DEMOG-0017");
		unMatchedErrorCodes.add("DEMOG-0022");
		unMatchedErrorCodes.add("DEMOG-0040");
		unMatchedErrorCodes.add("DEMOG-0042");
		unMatchedErrorCodes.add("DEMOG-9999");
		
		return !unMatchedErrorCodes.contains(msg.getValue().getCode());
	}
	
	/**
	 * 
	 * @param patient
	 * @param value
	 */
	@SuppressWarnings("unused")
	private void ExtractTel(COMTMT000016GB01Patient patient, IdentifyPatientResponse value) {
		if(patient.getTelecom() != null){
			for (TEL tel : patient.getTelecom()) {
				//check if type has been specified a populate
				if(tel.getNullFlavor() == null){
					if(tel.getUse() != null && tel.getUse().get(0) != null){
						if(tel.getUse().get(0).value().contains("H")){
							value.getPatient().setTelephoneHome(tel.getValue().replace("tel:", ""));
						}else if(tel.getUse().get(0).value().contains("MC")){
							value.getPatient().setTelephoneMobile(tel.getValue().replace("tel:", ""));
						}
					}else if(value.getPatient().getTelephoneHome().isEmpty()){
						//if we don't have a home number assume this is a home number
						value.getPatient().setTelephoneHome(tel.getValue().replace("tel:", ""));
					}
				}
			}
		}
	}
	
	private void ExtractNhsNumber(COMTMT000016GB01Patient patient,IdentifyPatientResponse value) {
		if(patient.getId().size()>0)
			value.getPatient().setNhsNumber(patient.getId().get(0).getExtension());
	}
	
	private void ExtractGPPractice(COMTMT000016GB01Patient patient,
			IdentifyPatientResponse value) {
		COMTMT000016GB01GPPractice gp = null;
		if(patient.getPatientPerson().getValue().getGPPractice()!=null)
		{
			gp = patient.getPatientPerson().getValue().getGPPractice().getValue();
		}
		else
			return ;
		
		GPPractice gpPractice = new GPPractice();
		gpPractice.setAddress(ExtractAddress(gp.getAddr()));
		
		if(gp.getLocationOrganization()!=null
				&& gp.getLocationOrganization().getValue().getName().getContent().size()==1)
		{
			gpPractice.setName(gp.getLocationOrganization().getValue().getName().getContent().get(0).toString());
			if(gp.getLocationOrganization().getValue().getId() != null)
				gpPractice.setODS(gp.getLocationOrganization().getValue().getId().getExtension());
		}
		if(gp.getTelecom()!=null)
		{
			gpPractice.setTelephone( gp.getTelecom().getValue());
		}
			
		value.getPatient().setGPPractice(gpPractice);
	}
	
	@SuppressWarnings("unused")
	private void ExtractName(List<Serializable> nameContent,IdentifyPatientResponse value)
	{
		for (Iterator<Serializable> iterator = nameContent.iterator(); iterator.hasNext();) {
			Serializable serializable = (Serializable) iterator.next();	
			try {
				if(serializable instanceof JAXBElement)
				{
					JAXBElement<?> elm = (JAXBElement<?>)serializable;
					Class<? extends Object> c = elm.getValue().getClass();			
					if(c==  EnGiven.class)
					{
						if(value.getPatient().getForename() == null || value.getPatient().getForename().isEmpty())
							value.getPatient().setForename(((EnGiven)elm.getValue()).getContent());
					}
					else if(c ==  EnFamily.class)
						value.getPatient().setSurname(((EnFamily)elm.getValue()).getContent());
					else if(c == EnPrefix.class)
						value.getPatient().setTitle(((EnPrefix)elm.getValue()).getContent());	
				}
			} catch (Exception e) {				
				logger.error(e);
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	private void ExtractDOB(COMTMT000016GB01Patient patient, IdentifyPatientResponse value) 
	{
		if (patient.getPatientPerson().getValue().getBirthTime() == null) {
			value.getPatient().setDOB(null);
			return;
		}
		
		String dobStr = patient.getPatientPerson().getValue().getBirthTime().getValue();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(dobStr);
		} catch (ParseException e1) {
			logger.error(e1);
			e1.printStackTrace();
		}

		GregorianCalendar c = new GregorianCalendar();
		c.setTime(date);
		XMLGregorianCalendar dob;
		try {
			dob = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			value.getPatient().setDOB( dob);
		} catch (DatatypeConfigurationException e) {
			logger.error(e);
			e.printStackTrace();
		}		
	}
	
	@SuppressWarnings("unused")
	private void ExtractGender(COMTMT000016GB01Patient patient,IdentifyPatientResponse value)
	{		
		String genderCode = patient.getPatientPerson().getValue().getAdministrativeGenderCode().getCode();
		Gender gender = Gender.NOT_KNOWN;
		if(genderCode.equals("1")) {
			gender = Gender.MALE;
		} else if( genderCode.equals("2")){			
			gender = Gender.FEMALE;
		} else if(genderCode.equals("9")){		
			gender = Gender.NOT_SPECIFIED;
		}		
		value.getPatient().setGender(gender);
	}
	
	private void ExtractAddress(COMTMT000016GB01Patient patient,IdentifyPatientResponse value) {
		//if more than one address find home address 
		Address address = null;
		List<ADNHSAddressType2> addList = patient.getAddr();
		int addindex = -1;
		ADNHSAddressType2 adnhsAddressType2;
		for (int i = 0; i < addList.size(); i++) {
			adnhsAddressType2 = addList.get(i);
			if(adnhsAddressType2!=null && addindex ==-1)
			{
				addindex = i;
			}else if(adnhsAddressType2!=null && adnhsAddressType2.getUse().contains("H"))
			{
				addindex = i;
			}
		}
		if(addindex>-1)
		{
			address = ExtractAddress(addList.get(addindex));
		}
		value.getPatient().setAddress(address);
	}
	
	private Address ExtractAddress(ADNHSAddressType2 adnhsAddressType2)
	{		
		Address address = new Address();
		List<Serializable> addEmls = adnhsAddressType2.getContent();
		int addline = 0;
		for (Serializable serializable : addEmls) {				
			if(serializable instanceof JAXBElement<?>)
			{
				JAXBElement<?> jaxEml = (JAXBElement<?>)serializable;
				ADXP adxp = (ADXP)jaxEml.getValue();
				if(jaxEml.getName().getLocalPart().toLowerCase().equals("postalcode"))
				{
					address.setPostalCode(adxp.getContent());
				}
				if(jaxEml.getName().getLocalPart().toLowerCase().equals("streetaddressline"))
				{
					if(addline==0)
						address.setStreetAddressLine1(adxp.getContent());
					else if(addline==1)
						address.setStreetAddressLine2(adxp.getContent());
					else if(addline==2)
						address.setStreetAddressLine3(adxp.getContent());
					else if(addline==3)
						address.setStreetAddressLine4(adxp.getContent());
					else if(addline==4)
						address.setStreetAddressLine5(adxp.getContent());
					
					addline++;
				}										
			}
		}		
		return address;		
	}

}
