package OctopusConsortium.Core;

import java.util.Date;
import java.util.Iterator;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.commons.lang.time.DateFormatUtils;
import org.codehaus.jackson.JsonNode;
import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.module.json.JsonData;
import org.mule.transformer.AbstractMessageTransformer;

public class QueryBankHolidayJson extends AbstractMessageTransformer {

	
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding)
			throws TransformerException {

		setJsonData(message.getPayload());
		Date date = XMLGregorianCalendarConversionUtil.asDate((XMLGregorianCalendar) message.getOutboundProperty("date"));
		
		String division = "england-and-wales";
		JsonNode[] divisions = _json.toArray();
		
		try {
			
			for (int d = 0; d < divisions.length; ++d) {
				
				JsonNode events = divisions[d].get("events");
				Iterator<JsonNode> it = events.getElements();
				
				while (it.hasNext()) {
					
					JsonNode node = it.next();
					
					
					if (divisions[d].get("division").asText() == division && 
							node.get("date").asText() == DateFormatUtils.format(date, "yyyy-MM-dd"))
						return true;
				}
			}
		
		} catch (Exception e) {
			throw new TransformerException(this, e);
		}
		
		return false;
	}

	private JsonData _json;
	private void setJsonData(Object src) throws TransformerException {
		if (!(src instanceof JsonData))
			throw new TransformerException(this, new Exception("src needs to be of type org.mule.module.json.JsonData"));
		
		_json = (JsonData)src;
	}


	
}
