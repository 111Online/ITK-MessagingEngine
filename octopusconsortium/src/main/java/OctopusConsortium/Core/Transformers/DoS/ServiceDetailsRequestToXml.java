package OctopusConsortium.Core.Transformers.DoS;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService1_5.ServiceDetailsById;


public class ServiceDetailsRequestToXml  extends
		AbstractTransformer {

	protected JAXBContext context ;	
	
	public ServiceDetailsRequestToXml()
	{
		super();
		this.registerSourceType(DataTypeFactory.create(ServiceDetailsById.class));
		this.setReturnDataType(DataTypeFactory.STRING);
		
		
	}		
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		ServiceDetailsById message = (ServiceDetailsById) src;

		String value=null;
		try {
			 value = Unmarshall(message);
		} catch (JAXBException e) {			
			throw new TransformerException(this,e);
		}
		return value;
	}
	
	
	private  String Unmarshall(ServiceDetailsById message) throws JAXBException	
	{		
		if(context==null)
		{
			context = JAXBContext.newInstance(ServiceDetailsById.class);
		}
		Marshaller jaxbMarshaller = context.createMarshaller();
		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(message, sw);
		
		return sw.toString();
	}

}
