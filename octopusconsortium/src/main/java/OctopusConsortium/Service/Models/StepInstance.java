package OctopusConsortium.Service.Models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stepInstance", propOrder = {
	    "questionId",
	    "questionNo",
	    "answerOrder"    
	})
public class StepInstance {

	@XmlElement(name = "QuestionId", required = true)
	protected String questionId;
	@XmlElement(name = "QuestionNo", required = true)
	protected String questionNo;
	@XmlElement(name = "AnswerOrder", required = true, type = Integer.class)
	protected Integer answerOrder;
		
	public String getQuestionId(){
		return this.questionId;
	}
	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}
	public String getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}	
	public Integer getAnswerOrder(){
		return this.answerOrder;
	}
	public void setAnswerOrder(Integer answerOrder){
		this.answerOrder = answerOrder;
	}
}
