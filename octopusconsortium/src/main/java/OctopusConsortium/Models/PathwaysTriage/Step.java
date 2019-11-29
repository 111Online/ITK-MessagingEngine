package OctopusConsortium.Models.PathwaysTriage;

import org.codehaus.jackson.annotate.JsonProperty;

public class Step {
	  @JsonProperty
	    private Answer answer;
	  @JsonProperty
	    private Boolean jtbs;
	  @JsonProperty
	    private String questionId;
	  @JsonProperty
	    private String questionNo;
	  @JsonProperty
	    private String questionTitle;
	  @JsonProperty
	    private String state;

	    public Answer getAnswer() {
	        return answer;
	    }

	    public void setAnswer(Answer answer) {
	        this.answer = answer;
	    }

	    public Boolean getJtbs() {
	        return jtbs;
	    }

	    public void setJtbs(Boolean jtbs) {
	        this.jtbs = jtbs;
	    }

	    public String getQuestionId() {
	        return questionId;
	    }

	    public void setQuestionId(String questionId) {
	        this.questionId = questionId;
	    }

	    public String getQuestionNo() {
	        return questionNo;
	    }

	    public void setQuestionNo(String questionNo) {
	        this.questionNo = questionNo;
	    }

	    public String getQuestionTitle() {
	        return questionTitle;
	    }

	    public void setQuestionTitle(String questionTitle) {
	        this.questionTitle = questionTitle;
	    }

	    public String getState() {
	        return state;
	    }

	    public void setState(String state) {
	        this.state = state;
	    }
}
