package OctopusConsortium.Core.Transformers.PDS;


import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;
import org.xml.sax.SAXException;

import OctopusConsortium.Core.InvalidMessageException;
import OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10;
import OctopusConsortium.PDSMiniServicesV1.DistributionEnvelopeType;
import OctopusConsortium.PDSMiniServicesV1.PayloadType;

/**
 * 
 * @author stuart.yeates
 * 
 * extracts the payloads into an list of COMTMT000016GB01GetPatientDetailsResponseV10 objects
 */
public class DistributionEnvelopeV2ToGetPatientDetailsResponseV1  extends
		AbstractTransformer {

	@SuppressWarnings("unchecked")
	public DistributionEnvelopeV2ToGetPatientDetailsResponseV1()
	{
		super();
		this.registerSourceType(DataTypeFactory.create(DistributionEnvelopeType.class));
		//this.setReturnDataType(DataTypeFactory.create(COMTMT000016GB01GetPatientDetailsResponseV10.class));
		this.setReturnDataType(DataTypeFactory.create((Class<List<Object>>)(Class<?>)List.class));
	}		
	
	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException  {		
		DistributionEnvelopeType message = (DistributionEnvelopeType) src;
				
		List<COMTMT000016GB01GetPatientDetailsResponseV10> responseList = new ArrayList<COMTMT000016GB01GetPatientDetailsResponseV10>();
		//javax.xml.bind.JAXBContext jaxbContext;
		try {
			//jaxbContext = javax.xml.bind.JAXBContext.newInstance(OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10.class);
			//javax.xml.bind.Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();			
			List<PayloadType> payloads = message.getPayloads().getPayload();			
			if(payloads.size()==0){				
				throw new InvalidMessageException("Invalid payload","DistributionEnvelopeType");		
			}
			
			
			
			for (Iterator<PayloadType> iterator = payloads.iterator(); iterator.hasNext();) {
				PayloadType payloadType = (PayloadType) iterator.next();
				List<Object> content = payloadType.getContent();	
			
				//TODO check the content.get(0) type 
				
				for (Object object : content) {
					if(object instanceof JAXBElement<?>)
					{
						JAXBElement<?> elm = (JAXBElement<?>)object;
						if(elm.getValue() instanceof COMTMT000016GB01GetPatientDetailsResponseV10)
							responseList.add( (COMTMT000016GB01GetPatientDetailsResponseV10)elm.getValue());
					}
				}
			}
		} catch (Exception  e) {			
			e.printStackTrace();
			
			throw new TransformerException(this,e);
		}
		return responseList;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private  JAXBElement<OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10> Unmarshall(org.apache.xerces.dom.ElementNSImpl o ,javax.xml.bind.Unmarshaller jaxbUnmarshaller)
	throws JAXBException, SAXException 
	{
		
		JAXBElement<OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10> returnValue = null;
		
		URL file = getClass().getResource("/schemas/PDSMiniServices/COMT_MT000016GB01.xsd");
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		//don't need the resolver at present as we have recreated the schema location structure in the resources
		//LSResourceResolver resolver = new ResourceResolver(file);
		//factory.setResourceResolver(resolver);
		
		//not specifying a schema will resolve the path form the location specified in the xml doc
		Schema schema = factory.newSchema(file);		
	
		JAXBContext jaxbContext = JAXBContext.newInstance(OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.setSchema(schema);
				
		jaxbUnmarshaller.setSchema(schema);		
	
		returnValue = (JAXBElement<OctopusConsortium.Models.PDS.COMTMT000016GB01GetPatientDetailsResponseV10>)jaxbUnmarshaller.unmarshal(o);
		
		return returnValue;
	}

}
