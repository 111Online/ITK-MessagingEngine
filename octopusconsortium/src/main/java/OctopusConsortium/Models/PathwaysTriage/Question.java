package OctopusConsortium.Models.PathwaysTriage;

import org.codehaus.jackson.annotate.JsonProperty;

public class Question {

	@JsonProperty
    private String dispositionUrgencyText;
	@JsonProperty
    private String id;
	@JsonProperty
    private String jtbs;
	@JsonProperty
    private String jtbsText;
	@JsonProperty
    private int order;
	@JsonProperty
    private String questionNo;
	@JsonProperty
    private String rationale;
	@JsonProperty
    private Long timeFrame;
	@JsonProperty
    private String timeFrameText;
	@JsonProperty
    private String title;
	@JsonProperty
    private String topic;
	@JsonProperty
    private String waitTimeText;
	@JsonProperty
    private String reportText;
	@JsonProperty
    private String careAdviceId;
	@JsonProperty
	private String keywords;
	@JsonProperty
	private String excludeKeywords;
	@JsonProperty
	private String content;
	@JsonProperty
	private String buttonText;

	public String getDispositionUrgencyText() {
        return dispositionUrgencyText;
    }

    public void setDispositionUrgencyText(String dispositionUrgencyText) {
        this.dispositionUrgencyText = dispositionUrgencyText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJtbs() {
        return jtbs;
    }

    public void setJtbs(String jtbs) {
        this.jtbs = jtbs;
    }

    public Object getJtbsText() {
        return jtbsText;
    }

    public void setJtbsText(String jtbsText) {
        this.jtbsText = jtbsText;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    public String getRationale() {
        return rationale;
    }

    public void setRationale(String rationale) {
        this.rationale = rationale;
    }

    public Long getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(Long timeFrame) {
        this.timeFrame = timeFrame;
    }

    public Object getTimeFrameText() {
        return timeFrameText;
    }

    public void setTimeFrameText(String timeFrameText) {
        this.timeFrameText = timeFrameText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Object getWaitTimeText() {
        return waitTimeText;
    }

    public void setWaitTimeText(String waitTimeText) {
        this.waitTimeText = waitTimeText;
    }

    public String getReportText() {
 		return reportText;
 	}

 	public void setReportText(String reportText) {
 		this.reportText = reportText;
 	}

 	public String getCareAdviceId() {
 		return careAdviceId;
 	}

 	public void setCareAdviceId(String careAdviceId) {
 		this.careAdviceId = careAdviceId;
 	}
 	
 	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getExcludeKeywords() {
		return excludeKeywords;
	}

	public void setExcludeKeywords(String excludeKeywords) {
		this.excludeKeywords = excludeKeywords;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getButtonText() {
		return buttonText;
	}

	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}
}
