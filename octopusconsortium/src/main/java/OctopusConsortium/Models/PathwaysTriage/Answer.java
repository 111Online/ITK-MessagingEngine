package OctopusConsortium.Models.PathwaysTriage;

import org.codehaus.jackson.annotate.JsonProperty;

public class Answer {
    @JsonProperty
    private String dispoDisplayText;
    @JsonProperty
    private String excludeKeywords;
    @JsonProperty
    private String keywords;
    @JsonProperty
    private Integer order;
    @JsonProperty
    private String reportText;
    @JsonProperty
    private String supportingInfo;
    @JsonProperty
    private String symptomDiscriminator;
    @JsonProperty
    private String title;
    @JsonProperty
    private String titleWithoutSpaces;
    @JsonProperty
    private boolean isPositive;
    @JsonProperty
    private String specifyText;

	public String getDispoDisplayText() {
        return dispoDisplayText;
    }

    public void setDispoDisplayText(String dispoDisplayText) {
        this.dispoDisplayText = dispoDisplayText;
    }

    public String getExcludeKeywords() {
        return excludeKeywords;
    }

    public void setExcludeKeywords(String excludeKeywords) {
        this.excludeKeywords = excludeKeywords;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getReportText() {
        return reportText;
    }

    public void setReportText(String reportText) {
        this.reportText = reportText;
    }

    public String getSupportingInfo() {
        return supportingInfo;
    }

    public void setSupportingInfo(String supportingInfo) {
        this.supportingInfo = supportingInfo;
    }

    public String getSymptomDiscriminator() {
        return symptomDiscriminator;
    }

    public void setSymptomDiscriminator(String symptomDiscriminator) {
        this.symptomDiscriminator = symptomDiscriminator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleWithoutSpaces() {
        return titleWithoutSpaces;
    }

    public void setTitleWithoutSpaces(String titleWithoutSpaces) {
        this.titleWithoutSpaces = titleWithoutSpaces;
    }
    
    public boolean getIsPositive() {
		return isPositive;
	}

	public void setIsPositive(boolean isPositive) {
		this.isPositive = isPositive;
	}
	
	public String getSpecifyText() {
		return specifyText;
	}

	public void setSpecifyText(String specifyText) {
		this.specifyText = specifyText;
	}
}