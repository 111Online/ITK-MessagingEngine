package OctopusConsortium.Models.DOS.Proxy.Response;

import org.codehaus.jackson.annotate.JsonProperty;

import OctopusConsortium.DosService1_3.ContactType;

public class ContactDetailsField {
	
	private ContactType tagField;
	
	private String nameField;
	
	private String valueField;
	
	private Integer orderField;

	@JsonProperty("PropertyChanged")
	private Object propertyChanged;
	
	public ContactType getTagField() {
		return tagField;
	}

	
	public void setTagField(ContactType tagField) {
		this.tagField = tagField;
	}

	
	public String getNameField() {
		return nameField;
	}

	
	public void setNameField(String nameField) {
		this.nameField = nameField;
	}

	
	public String getValueField() {
		return valueField;
	}

	
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}

	
	public Integer getOrderField() {
		return orderField;
	}

	
	public void setOrderField(Integer orderField) {
		this.orderField = orderField;
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