package OctopusConsortium.Models.DOS.Proxy.Response;

import org.codehaus.jackson.annotate.JsonProperty;


public class ServiceEndpoints {
	
	private String addressField;
	
	private String businessScenarioField;
	
	private String commentField;
	
	private String compressionField;
	
	private Integer endpointOrderField;
	
	private String formatField;
	
	private String interactionField;
	
	private Integer transportField;
	
	@JsonProperty("PropertyChanged")
	private Object propertyChanged;
	

	public void setAddressField(String addressField) {
		this.addressField = addressField;
	}

	
	public String getAddressField() {
		return addressField;
	}

	
	public void setBusinessScenarioFieldd(String businessScenarioField) {
		this.businessScenarioField = businessScenarioField;
	}

	
	public String getBusinessScenarioField() {
		return businessScenarioField;
	}

	
	public void setCommentField(String commentField) {
		this.commentField = commentField;
	}

	
	public String getCommentField() {
		return commentField;
	}
	
	public void setCompressionField(String compressionField) {
		this.compressionField = compressionField;
	}

	
	public String getCompressionField() {
		return compressionField;
	}

	public Integer getEndpointOrderField() {
		return endpointOrderField;
	}
	
	public void setEndpointOrderField(Integer endpointOrderField) {
		this.endpointOrderField = endpointOrderField;
	}
	

	public void setFormatField(String formatField) {
		this.formatField = formatField;
	}

	
	public String getFormatField() {
		return formatField;
	}
	
	public void setInteractionField(String interactionField) {
		this.interactionField = interactionField;
	}

	
	public String getInteractionField() {
		return interactionField;
	}
	
	public void setTransportField(Integer transportField) {
		this.transportField = transportField;
	}

	
	public Integer getTransportField() {
		return transportField;
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
