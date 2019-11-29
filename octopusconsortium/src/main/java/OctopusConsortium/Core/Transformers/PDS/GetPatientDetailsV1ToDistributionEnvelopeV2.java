package OctopusConsortium.Core.Transformers.PDS;


import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.CommonValues;
import OctopusConsortium.Models.PDS.QUPAMT000005GB01GetPatientDetailsV10;
import OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType;

public class GetPatientDetailsV1ToDistributionEnvelopeV2 extends
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
	
	public GetPatientDetailsV1ToDistributionEnvelopeV2()
	{
		super();		
		this.registerSourceType(DataTypeFactory.create(QUPAMT000005GB01GetPatientDetailsV10.class));
		this.setReturnDataType(DataTypeFactory.create(DistributionEnvelopeType.class));
	}
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
			
		PDSMessageFactory ofactory = new OctopusConsortium.Core.Transformers.PDS.PDSMessageFactory(new CommonValues(ods, orgName));
		
		return ofactory.createGetDistributionEnvelopeGetPatientDetailsV10((QUPAMT000005GB01GetPatientDetailsV10)src);
	}
	
}
