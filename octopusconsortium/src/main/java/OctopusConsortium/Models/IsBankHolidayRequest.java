package OctopusConsortium.Models;

import javax.xml.datatype.XMLGregorianCalendar;

public class IsBankHolidayRequest {

	public XMLGregorianCalendar getDate() {
		return _date;
	}
	public void setDate(XMLGregorianCalendar value) {
		_date = value;
	}

	public String getDivision() {
		return _division;
	}
	public void setDivision(String value) {
		_division = value;
	}

	private XMLGregorianCalendar _date;
	private String _division;
}
