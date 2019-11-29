package OctopusConsortium.Core.Transformers.PathwaysCase;

import java.util.Iterator;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import OctopusConsortium.Models.PathwaysCase2_4.PathwayTriage;
import OctopusConsortium.Models.PathwaysCase2_4.PathwayTriageDetails;
import OctopusConsortium.Models.PathwaysCase2_4.PathwaysCase;
import OctopusConsortium.Models.PathwaysCase2_4.QuestionType;
import OctopusConsortium.Models.PathwaysCase2_4.TriageLine;
import OctopusConsortium.Models.PathwaysCase2_4.TriageLineDetails;

public class TimeManipulation {
	
	private DateTime workingDate;
	private DatatypeFactory datatypeFactory;
	
	public TimeManipulation() throws DatatypeConfigurationException {
		datatypeFactory = DatatypeFactory.newInstance();
	}
	
	public PathwaysCase SetTimeStamps(PathwaysCase pathwaysCase){
		workingDate = new DateTime(DateTimeZone.UTC);

		//set end time
		XMLGregorianCalendar documentGeneratedEndDateTime = datatypeFactory.newXMLGregorianCalendar(workingDate.toGregorianCalendar());
		pathwaysCase.setCaseReceiveEnd(documentGeneratedEndDateTime);

		//set start time
		workingDate = BackInTime(workingDate, CountTimeStepsForTriage(pathwaysCase.getPathwayDetails().getPathwayTriageDetails()));
		XMLGregorianCalendar documentGeneratedStartDateTime = datatypeFactory.newXMLGregorianCalendar(workingDate.toGregorianCalendar());
		pathwaysCase.setCaseReceiveStart(documentGeneratedStartDateTime);
		
		//set triage lines	
		XMLGregorianCalendar dispositionTime = documentGeneratedEndDateTime;//use end time as default
		
		for (Iterator<PathwayTriage> pt = pathwaysCase.getPathwayDetails().getPathwayTriageDetails().getPathwayTriage().iterator(); pt.hasNext();){
			PathwayTriage pathwayTriage =  pt.next();
			pathwayTriage.setStart(documentGeneratedStartDateTime);
			pathwayTriage.setFinish(documentGeneratedEndDateTime);
			
			for(Iterator<TriageLine> tl = pathwayTriage.getTriageLineDetails().getTriageLine().iterator(); tl.hasNext();){
				TriageLine triageLine = tl.next();
				triageLine.setStart(GetNextTimeStamp(workingDate));
				triageLine.setFinish(GetNextTimeStamp(workingDate));
				
				if (triageLine.getQuestionType() == QuestionType.Disposition){
					dispositionTime = triageLine.getFinish();
				}
			}
		}

		//set triage disposition time
		for (Iterator<PathwayTriage> pt = pathwaysCase.getPathwayDetails().getPathwayTriageDetails().getPathwayTriage().iterator(); pt.hasNext();){
			PathwayTriage pathwayTriage = pt.next();
			pathwayTriage.getTriageDisposition().setTimeReached(dispositionTime);
		}
		
		return pathwaysCase;
	}
	
	private int CountTimeStepsForTriage(PathwayTriageDetails triageDetails){
		if(triageDetails.getPathwayTriage() != null && triageDetails.getPathwayTriage().size() > 0) {
						
			int triageLineCount = CountTriageLines(triageDetails.getPathwayTriage().get(0).getTriageLineDetails()); 
			
			return (triageLineCount * 2) + 1;	
		}
		else {
			return 1;
		}
	}

	private int CountTriageLines(TriageLineDetails triageLineDetails ){
		if (triageLineDetails != null && triageLineDetails.getTriageLine() != null){
			return triageLineDetails.getTriageLine().size();
		}else {
			return 0;
		}
	}
	
	private DateTime BackInTime(DateTime dateTime, int decreaseSeconds){
		return dateTime.minusSeconds(decreaseSeconds);
	}
	
	private XMLGregorianCalendar GetNextTimeStamp(DateTime dateTime){
		workingDate = dateTime.plusSeconds(1);
		return datatypeFactory.newXMLGregorianCalendar(workingDate.toGregorianCalendar());
	}
}
