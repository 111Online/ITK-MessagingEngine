package OctopusConsortium.Core.Transformers.ITK;

import javax.xml.bind.JAXBElement;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;


public class CDA_UK_RemoveSensitiveInformation extends AbstractTransformer {
	public CDA_UK_RemoveSensitiveInformation() {	
		super();
		this.registerSourceType(DataTypeFactory.create(OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType.class));

		this.setReturnDataType(DataTypeFactory.create(OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType.class));
	}
	
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		try
		{
			if (src instanceof OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType)
			{		
				DistributionEnvelopeType payload = (DistributionEnvelopeType)src;
				
				JAXBElement<POCDMT000002UK01ClinicalDocument> cdaElement = (JAXBElement<POCDMT000002UK01ClinicalDocument>)payload.getPayloads().getPayload().get(0).getAny().get(0);
				POCDMT000002UK01ClinicalDocument cda = cdaElement.getValue();
			
				String nhsNumberRootCode = "2.16.840.1.113883.2.1.4.1";
				
				if (!cda.getRecordTarget().isEmpty() && 
					!cda.getRecordTarget().get(0).getPatientRole().getId().isEmpty() &&
					cda.getRecordTarget().get(0).getPatientRole().getId().get(0).getRoot().equals(nhsNumberRootCode))
				{
					cda.getRecordTarget().get(0).getPatientRole().getId().get(0).setExtension("REDACTED");
				}
				
				return payload;
			}
			
			return src;
		}
		catch (Exception e)
		{
			return src;
		}
	}
}