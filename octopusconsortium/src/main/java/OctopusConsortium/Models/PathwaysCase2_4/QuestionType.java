package OctopusConsortium.Models.PathwaysCase2_4;

public enum QuestionType {
	PathwaysSelection("PathwaysSelection"),
	MultipleChoice("MultipleChoice"),
	SingleAnswer("SingleAnswer"),
	Disposition("Disposition"),
	HomeCareAdvice("HomeCareAdvice"),
	InterimCareAdvice("InterimCareAdvice"),
	SetVariable("SetVariable"),
	QueryVariable("QueryVariable"),
	CMSLookup("CMS Lookup"),
	UNKNOWN("UNKNOWN");
	
	private String typeString;
	
	QuestionType(String typeString) {
		this.typeString = typeString;
	}
   
	public String toString() {
		return this.typeString;
	}
}
