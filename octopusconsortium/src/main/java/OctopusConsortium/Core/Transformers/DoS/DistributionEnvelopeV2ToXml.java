package OctopusConsortium.Core.Transformers.DoS;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.ITKNamespacePrefixMapper;
import OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType;
import OctopusConsortium.RepeatCallerServiceV1.ObjectFactory;


public class DistributionEnvelopeV2ToXml  extends
		AbstractTransformer {

	protected JAXBContext context ;	
	
	public DistributionEnvelopeV2ToXml()
	{
		super();
		this.registerSourceType(DataTypeFactory.create(DistributionEnvelopeType.class));
		this.setReturnDataType(DataTypeFactory.STRING);
		
		
	}		
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		DistributionEnvelopeType message = (DistributionEnvelopeType) src;
		JAXBElement<DistributionEnvelopeType> r = new ObjectFactory().createDistributionEnvelope(message);
		String value=null;
		try {
			 value = Unmarshall(r);
		} catch (JAXBException e) {			
			throw new TransformerException(this,e);
		}
		return value;
	}
	
	
	private  String Unmarshall(JAXBElement<DistributionEnvelopeType> jax_message) throws JAXBException	
	{		
		if(context==null)
		{
			context = JAXBContext.newInstance(DistributionEnvelopeType.class,OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument.class);
		}
		Marshaller jaxbMarshaller = context.createMarshaller();
		StringWriter sw = new StringWriter();
		jaxbMarshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new ITKNamespacePrefixMapper());
		jaxbMarshaller.marshal(jax_message, sw);
		
		return sw.toString();
	}

}
