package OctopusConsortium.Core.Transformers.PDS;


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

import OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10;
import OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType;

@SuppressWarnings("unused")
public class XmlToDistributionEnvelopeV2  extends
		AbstractTransformer {
	
	 protected JAXBContext jaxbContext ;
	

	public XmlToDistributionEnvelopeV2() throws JAXBException
	{
		super();
		this.registerSourceType(DataTypeFactory.STRING);
		this.setReturnDataType(DataTypeFactory.create(DistributionEnvelopeType.class));
		jaxbContext = JAXBContext.newInstance(DistributionEnvelopeType.class,COMTMT000016GB01GetPatientDetailsResponseV10.class);
	}		
	
	@SuppressWarnings("unchecked")
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		String message = (String) src;
		JAXBElement<DistributionEnvelopeType> jax_result ;		
		Unmarshaller unmarshaller;
		try {
			unmarshaller = jaxbContext.createUnmarshaller();			
			//TODO uncomment following lines when needing to validate message against schema
			//SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			//URL file = getClass().getResource("/schemas/PDS/PDSMiniServices/distributionEnvelope-v2-0.xsd");
			//Schema schema = factory.newSchema(file);
			//unmarshaller.setSchema(schema);
			jax_result= (JAXBElement<DistributionEnvelopeType>)unmarshaller.unmarshal(new ByteArrayInputStream (message.getBytes()));
		} catch (Exception e) {
			logger.error(e.getMessage()); 
			throw new TransformerException(MessageFactory.createStaticMessage("Error unserialising message"),this, e);
		}
		
		return jax_result.getValue();
	}
	
	

}
