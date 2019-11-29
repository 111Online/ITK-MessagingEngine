package OctopusConsortium.Core.Transformers.PDS;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10;
import OctopusConsortium.Service.Models.IdentifyPatientRequest;


public class PatientDetailsToGetPatientDetailsRequestV1 extends
		AbstractTransformer {
	
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
	
	public PatientDetailsToGetPatientDetailsRequestV1()
	{
		super();		
		this.registerSourceType(DataTypeFactory.create(IdentifyPatientRequest.class));
		this.setReturnDataType(DataTypeFactory.create(QUPAMT000005GB01GetPatientDetailsV10.class));
	}
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
		
		IdentifyPatientRequest patientDetails  = (IdentifyPatientRequest)src;
		PDSMessageFactory of = new OctopusConsortium.Core.Transformers.PDS.PDSMessageFactory(new CommonValues(ods,orgName));
		QUPAMT000005GB01GetPatientDetailsV10 getPatientDetails;
		try {
			getPatientDetails = of.createGetPatientDetailsV10(patientDetails);
		} catch (Exception e) {
			throw new TransformerException(this,e);
		}
		//GetPatientDetailsV10 getPatientDetailsPayload = of.GetPatientDetailsV10XML(getPatientDetails);
		
		return getPatientDetails;		
	}
}
