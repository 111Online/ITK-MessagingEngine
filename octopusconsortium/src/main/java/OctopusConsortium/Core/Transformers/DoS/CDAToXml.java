package OctopusConsortium.Core.Transformers.DoS;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument;
import OctopusConsortium.RepeatCallerServiceV1.ObjectFactory;


public class CDAToXml  extends
		AbstractTransformer {

	protected JAXBContext context ;	
	
	public CDAToXml()
	{
		super();
		this.registerSourceType(DataTypeFactory.create(POCDMT000002UK01ClinicalDocument.class));
		this.setReturnDataType(DataTypeFactory.STRING);
		
		
	}		
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		POCDMT000002UK01ClinicalDocument message = (POCDMT000002UK01ClinicalDocument) src;
		JAXBElement<POCDMT000002UK01ClinicalDocument> r = new ObjectFactory().createPOCDMT000002UK01ClinicalDocument(message);
		String value=null;
		try {
			 value = Unmarshall(r);
		} catch (JAXBException e) {			
			throw new TransformerException(this,e);
		}
		return value;
	}
	
	
	private  String Unmarshall(JAXBElement<POCDMT000002UK01ClinicalDocument> jax_message) throws JAXBException	
	{		
		//JAXBContext jaxbContext = JAXBContext.newInstance(DistributionEnvelopeType.class,OctopusConsortium.Models.RCS.POCDMT000002UK01ClinicalDocument.class);
		if(context==null)
		{
			context = JAXBContext.newInstance(POCDMT000002UK01ClinicalDocument.class);
		}
		Marshaller jaxbMarshaller = context.createMarshaller();
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(jax_message, sw);
		
		return sw.toString();
	}

}
