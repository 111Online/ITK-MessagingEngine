package OctopusConsortium.Models.PathwaysTriage;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class QuestionWithAnswers {  
	@JsonProperty("Answered")
    private Answer answered;
	@JsonProperty("Answers")
    private List<Answer> answers;
	@JsonProperty("Group")
    private Object group;
    @JsonProperty("Labels")
    private List<String> labels;
    @JsonProperty("NonQuestionExcludeKeywords")
    private Object nonQuestionExcludeKeywords;
    @JsonProperty("NonQuestionKeywords")
    private Object nonQuestionKeywords;
    @JsonProperty("Question")
    private Question question;
    @JsonProperty("State")
    private Object state;
	@JsonProperty("AssociatedPathway")
	private AssociatedPathway associatedPathway;
    
    public Answer getAnswered() {
        return answered;
    }

    public void setAnswered(Answer answered) {
        this.answered = answered;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public Object getNonQuestionExcludeKeywords() {
        return nonQuestionExcludeKeywords;
    }

    public void setNonQuestionExcludeKeywords(Object nonQuestionExcludeKeywords) {
        this.nonQuestionExcludeKeywords = nonQuestionExcludeKeywords;
    }

    public Object getNonQuestionKeywords() {
        return nonQuestionKeywords;
    }

    public void setNonQuestionKeywords(Object nonQuestionKeywords) {
        this.nonQuestionKeywords = nonQuestionKeywords;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }
	
    public AssociatedPathway getAssociatedPathway() {
		return associatedPathway;
	}

	public void setAssociatedPathway(AssociatedPathway associatedPathway) {
		this.associatedPathway = associatedPathway;
	}
}
