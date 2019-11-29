package OctopusConsortium.Core;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import OctopusConsortium.Models.PostCodes.OOHPreferredProvider;
import OctopusConsortium.Models.PostCodes.Records;
import OctopusConsortium.Models.PostCodes.Records.Row;

public class OOHPostcodeCache {
	
	public HashMap<String, Row> getPostCodeRecords() {
		return _postCodeRecords;
	}
	
	public void setXmlPath(String value) throws IOException, JAXBException, SAXException{
		_xmlPath = value;	
		_postCodeRecords = ParseFile();
	}
	
	public String getXmlPath(){
		return _xmlPath;
	}
	
	public InputStream getXmlFileStream() {
		if (_xmlFile != null)
			return _xmlFile;
		if(_xmlPath != null)
			return _xmlFile = this.getClass().getResourceAsStream(_xmlPath);
		return null;
	}

	public OOHPostcodeCache()
			throws IOException, JAXBException, SAXException {
		this(null);
	}
		
	public OOHPostcodeCache(InputStream value)
			throws IOException, JAXBException, SAXException {
		
		_xmlFile = value;
		
		_postCodeRecords = ParseFile();
	}
	
	public Schema getSchema()
			throws SAXException {
		
		if (_schema != null)
			return _schema;
		
		return _schema = LoadSchema();
	}
	
	public void setSchema(Schema value) {
		_schema = value;
	}
	
	private HashMap<String, Row> ParseFile()
			throws IOException, JAXBException, SAXException {
				
		InputStream in = getXmlFileStream();
		if (in == null)
			return null; //we are disabling postcode override

		Schema schema = getSchema();
		
		JAXBContext jc = JAXBContext.newInstance(Records.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
        unmarshaller.setSchema(schema);
        
		Records records = (Records)unmarshaller.unmarshal(in);
		
		HashMap<String, Row> map = new HashMap<String, Row>();
		for (Row record : records.getRow()) {
			map.put(record.getPostcode().replaceAll("\\s+", "").toLowerCase(), record);
		}
		
		return map;
	}
	
	private Schema LoadSchema() throws SAXException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		return factory.newSchema(getClass().getResource("/providerServicePostcodes/postcodeList.xsd"));
	}
	
	public OOHPreferredProvider searchForService(String postcode) {

		if (_postCodeRecords == null)
			return null; //if we have no postcodes then assume postcode override is disabled
		
		postcode = postcode.replaceAll("\\s+", "").toLowerCase();
		Row row = _postCodeRecords.get(postcode);
		
		if (row == null)
			return null;

		OOHPreferredProvider result = new OOHPreferredProvider();
		result.setServiceId(row.getServiceId());
		result.setOdsCode(row.getOdsCode());
		result.setName(row.getName());
		result.setAddress(row.getAddress());
		result.setServicePostcode(row.getServicePostcode());
		return result;
	}

	private String _xmlPath;
	private Schema _schema;
	private HashMap<String, Row> _postCodeRecords;
	private InputStream _xmlFile;
}
