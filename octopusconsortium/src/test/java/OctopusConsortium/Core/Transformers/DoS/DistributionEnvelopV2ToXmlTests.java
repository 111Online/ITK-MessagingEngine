package OctopusConsortium.Core.Transformers.DoS;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;
import OctopusConsortium.RepeatCallerServiceV1.ObjectFactory;


/**
 * @author stuart.yeates
 *
 */
public class DistributionEnvelopV2ToXmlTests  {

	/**
	 * Test method for {@link OctopusConsortium.Core.Transformers.Dos.EncounterResponseToDosCheckCapacitySummary()}.
	 */
	@Test
	public void testDataTypeSupport() {
		DistributionEnvelopeV2ToXml target = new DistributionEnvelopeV2ToXml();
		assertTrue("input of DistributionEnvelopeType not supported",target.isSourceDataTypeSupported(DataTypeFactory.create(DistributionEnvelopeType.class)));		
		assertTrue("output of String not supported",target.getReturnDataType().equals(DataTypeFactory.STRING));
	}

	
	
	/**
	 * 
	 */
	@Test
	public void testDoTransform() {
		//Arrange
		//########	
		ObjectFactory of = new ObjectFactory();
		DistributionEnvelopeType payload = of.createDistributionEnvelopeType();
		
		payload.setHeader(of.createDistributionHeaderType());
		
	}
	
	
	
}
