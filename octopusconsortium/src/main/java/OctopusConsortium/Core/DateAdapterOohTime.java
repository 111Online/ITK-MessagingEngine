package OctopusConsortium.Core;

import java.util.Calendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


public class DateAdapterOohTime extends XmlAdapter<XMLGregorianCalendar, XMLGregorianCalendar> {
		
	//public static final String ALLOWED_DATE_PATTERN_DATETIME = "yyyy-MM-dd'T'HH:mm:ss";
	//public static final String ALLOWED_DATE_PATTERN_DATE = "yyyy-MM-dd";
	
    //private SimpleDateFormat dateFormat = new SimpleDateFormat(ALLOWED_DATE_PATTERN_DATETIME);

    @Override
    public XMLGregorianCalendar marshal(XMLGregorianCalendar v) throws Exception {
        return v;
    }

    @Override
    public XMLGregorianCalendar unmarshal(XMLGregorianCalendar value) throws InvalidMessageException  {
    	
    	Calendar c = Calendar.getInstance();     	    	
    	if( value.getYear() == Integer.MIN_VALUE )
    		value.setYear(c.get(Calendar.YEAR));
		if( value.getMonth() == Integer.MIN_VALUE)
			value.setMonth(c.get(Calendar.MONTH)+1);
		if( value.getDay() == Integer.MIN_VALUE )
    		value.setDay(c.get(Calendar.DAY_OF_MONTH));
    	
    	if( value.getYear() > (c.get(Calendar.YEAR) + 1) ||
    		value.getYear() < (c.get(Calendar.YEAR) - 1) )
    	{    		
    		throw new InvalidMessageException(String.format("Year out of allowed range '%d'", value.getYear()));
    	}
    	return value;
    }
         
}