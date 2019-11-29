package OctopusConsortium.Models.DOS.Proxy.Response;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Service {
	
	private String idField;
	private String odsCodeField;
	private List<ContactDetailsField> contactDetailsField = null;
	
	@JsonProperty("PropertyChanged")
	private Object propertyChanged;
	
	
	public String getIdField() {
		return idField;
	}

	
	public void setIdField(String idField) {
		this.idField = idField;
	}

	
	public String getOdsCodeField() {
		return odsCodeField;
	}

	
	public void setOdsCodeField(String odsCodeField) {
		this.odsCodeField = odsCodeField;
	}

	
	public List<ContactDetailsField> getContactDetailsField() {
		return contactDetailsField;
	}

	
	public void setContactDetailsField(List<ContactDetailsField> contactDetailsField) {
		this.contactDetailsField = contactDetailsField;
	}
	
	@JsonProperty("PropertyChanged")
	public Object getPropertyChanged() {
		return propertyChanged;
	}
	@JsonProperty("PropertyChanged")
	public void setPropertyChanged(Object propertyChanged) {
		this.propertyChanged = propertyChanged;
	}
	
}