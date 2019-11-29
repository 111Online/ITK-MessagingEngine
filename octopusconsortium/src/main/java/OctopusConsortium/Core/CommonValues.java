package OctopusConsortium.Core;

import java.math.BigInteger;

public class CommonValues {
	
	public CommonValues(String ods, String name){
		ODS_ORGANISATION_CODE = ods;
		MANUFACTURER_NAME = name;
		
		ODS_URI = "urn:nhs-uk:identity:ods:" + ODS_ORGANISATION_CODE;
		ODS_ADDRESSING_URI = ODS_ADDRESS_BLANK + ODS_ORGANISATION_CODE;
		if (MANUFACTURER_NAME != null && !(MANUFACTURER_NAME.isEmpty())){
			ODS_ASSIGNING_AUTHORITY_NAME = MANUFACTURER_NAME.toUpperCase() + " NHS TRUST";
		}
		else{
			ODS_ASSIGNING_AUTHORITY_NAME = "";
		}
			
	}
	
	public String ODS_ORGANISATION_CODE;
	public String MANUFACTURER_NAME;
	public String ODS_URI;
	public String ODS_ADDRESSING_URI;
    public static final String ODS_ADDRESS_BLANK = "urn:nhs-uk:addressing:ods:";
	
	//From here: http://www.connectingforhealth.nhs.uk/systemsandservices/data/ods/datafiles/tr.csv/view
	public String ODS_ASSIGNING_AUTHORITY_NAME;
	public static final String PATIENTDETAILS_REQUEST_SERVICE = "urn:nhs-itk:services:201005:getPatientDetails-v1-0";
	public static final String PATIENTDETAILS_REQUEST_PROFILE = "urn:nhs-en:profile:getPatientDetailsRequest-v1-0";
	
	public static final String SOFTWARE_NAME = "Message Engine ESB";
	
	//Repeat caller	
	public static final BigInteger HASC_VERSION = BigInteger.valueOf(1);
	public static final String REPEATCALLER_REPORT_SERVICE = "urn:nhs-itk:services:201005:SendNHS111Report-v2-0";
	public static final String REPEATCALLER_REPORT_PROFILE = "urn:nhs-en:profile:nhs111CDADocument-v2-0";
	
	public static final String REPEATCALLER_QUERY_SERVICE = "NHS111RepeatCallerSyncQueryResp-v1-0";
	public static final String REPEATCALLER_QUERY_PROFILE = "urn:nhs-en:profile:nhs111RepeatCallerQuery-v1-0";
	
	public static final String PATIENTDETAILS_REQUEST_OID = "2.16.840.1.113883.2.1.3.2.4.17.284";
	public String getOrganisation_Name()
	{
		return MANUFACTURER_NAME + " Message Engine";
	}
	
	public static final String APP_MAJOR_VERSION  = "2";
	public static final String APP_MINOR_VERSION  = "5";
	public static final String APP_REVISION_VERSION  = "0";
	public static final String APP_VERSION = APP_MAJOR_VERSION + "." + APP_MINOR_VERSION + "." + APP_REVISION_VERSION;

	public static final String WSDL_MAJOR_VERSION  = "2";
	public static final String WSDL_MINOR_VERSION  = "5";
	public static final String WSDL_REVISION_VERSION  = "0";
	public static final String WSDL_VERSION = WSDL_MAJOR_VERSION + "." + WSDL_MINOR_VERSION + "." + WSDL_REVISION_VERSION;
}
