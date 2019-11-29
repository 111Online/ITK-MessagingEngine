package OctopusConsortium.Core.Transformers.DoS;


import java.io.ByteArrayInputStream;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.mule.api.transformer.TransformerException;
import org.mule.config.i18n.MessageFactory;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.DosService1_5.ArrayOfServices;
import OctopusConsortium.DosService1_5.ServiceDetailsByIdResponse;
import OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10;
import OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType;

@SuppressWarnings("unused")
public class XmlToServiceDetailsResponse  extends
		AbstractTransformer {
	
	 protected JAXBContext jaxbContext ;
	

	public XmlToServiceDetailsResponse() throws JAXBException
	{
		super();
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(ServiceDetailsByIdResponse.class));
		jaxbContext = JAXBContext.newInstance(ServiceDetailsByIdResponse.class);
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		String message = (String) src;
		ServiceDetailsByIdResponse result ;		
		Unmarshaller unmarshaller;
		try {
			unmarshaller = jaxbContext.createUnmarshaller();			
			result= (ServiceDetailsByIdResponse)unmarshaller.unmarshal(new ByteArrayInputStream (message.getBytes()));
		} catch (Exception e) {
			logger.error(e.getMessage()); 
			throw new TransformerException(MessageFactory.createStaticMessage("Error unserialising message"),this, e);
		}
		
		return result;
	}
	
	

}
