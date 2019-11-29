package OctopusConsortium.Core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.XMLGregorianCalendar;


public class DateAdapterOoHTimeString extends XmlAdapter<String, XMLGregorianCalendar> {
		
	public static final String ALLOWED_DATE_PATTERN_DATETIME = "yyyy-MM-dd'T'HH:mm:ss";
	public static final String ALLOWED_DATE_PATTERN_DATE = "yyyy-MM-dd";
	public static final String ALLOWED_DATE_PATTERN_TIME = "HH:mm:ss";
	
    private SimpleDateFormat dateFormat = new SimpleDateFormat(ALLOWED_DATE_PATTERN_DATETIME);

    @Override
    public String marshal(XMLGregorianCalendar v) throws Exception {
        return dateFormat.format(v.toGregorianCalendar().getTime());
    }

    @Override
    public XMLGregorianCalendar unmarshal(String value) throws InvalidMessageException  {
    	SimpleDateFormat format = (SimpleDateFormat)DateFormat.getDateInstance();
    	//format.applyPattern(ALLOWED_DATE_PATTERN_DATETIME);
    	//format.applyPattern(ALLOWED_DATE_PATTERN_DATE);
    	//format.applyPattern(ALLOWED_DATE_PATTERN_TIME);
    	
    	try {
    		try{
    			format.applyPattern(ALLOWED_DATE_PATTERN_DATETIME);
    			format.parse(value);
    		}catch (ParseException e) {
    			format.applyPattern(ALLOWED_DATE_PATTERN_TIME);
    			format.parse(value);
    		}
		
			XMLGregorianCalendar returnDate = org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl.newInstance().newXMLGregorianCalendar(value);
			//check if we only have the time set to todays date
			Calendar c = Calendar.getInstance();     	    	
	    	if( returnDate.getYear() == Integer.MIN_VALUE )
	    		returnDate.setYear(c.get(Calendar.YEAR));
			if( returnDate.getMonth() == Integer.MIN_VALUE)
				returnDate.setMonth(c.get(Calendar.MONTH)+1);
			if( returnDate.getDay() == Integer.MIN_VALUE )
				returnDate.setDay(c.get(Calendar.DAY_OF_MONTH));	    	
	    	if( returnDate.getYear() > (c.get(Calendar.YEAR) + 1) ||
	    		returnDate.getYear() < (c.get(Calendar.YEAR) - 1) )
	    	{    		
	    		throw new InvalidMessageException(String.format("Year out of allowed range '%d'", returnDate.getYear()));
	    	}
	    	return returnDate;
		} catch (ParseException e) {			
			throw new InvalidMessageException(String.format("Invalid date '%s'. Expected pattern '%s' or '%s.'", value, ALLOWED_DATE_PATTERN_DATETIME, ALLOWED_DATE_PATTERN_TIME));
		}
        catch (DatatypeConfigurationException e) {
			throw new InvalidMessageException(String.format("Invalid date '%s'. Expected pattern '%s' or '%s.'", value, ALLOWED_DATE_PATTERN_DATETIME, ALLOWED_DATE_PATTERN_TIME));
		}
    	catch(InvalidMessageException ime){
    		throw ime;
    	}
    }
         
}