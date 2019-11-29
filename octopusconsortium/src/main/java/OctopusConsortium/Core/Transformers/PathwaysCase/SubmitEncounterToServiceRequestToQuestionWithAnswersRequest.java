package OctopusConsortium.Core.Transformers.PathwaysCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.codehaus.jackson.map.ObjectMapper;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.mule.transformer.types.DataTypeFactory;

import OctopusConsortium.Core.PathwaysValues;
import OctopusConsortium.Service.Models.StepInstance;
import OctopusConsortium.Service.Models.SubmitEncounterToServiceRequest;
import OctopusConsortium.Models.PathwaysTriage.Answer;
import OctopusConsortium.Models.PathwaysTriage.QuestionWithAnswersRequest;
import OctopusConsortium.Models.PathwaysTriage.Step;

public class SubmitEncounterToServiceRequestToQuestionWithAnswersRequest extends AbstractTransformer
{
	
	public SubmitEncounterToServiceRequestToQuestionWithAnswersRequest() throws DatatypeConfigurationException{
		super();
	
		this.registerSourceType(DataTypeFactory.create(SubmitEncounterToServiceRequest.class));

		this.setReturnDataType(DataTypeFactory.create(QuestionWithAnswersRequest.class));
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object doTransform(Object src, String enc) throws TransformerException {
		if (src instanceof SubmitEncounterToServiceRequest){
			SubmitEncounterToServiceRequest encounter = (SubmitEncounterToServiceRequest)src;
			QuestionWithAnswersRequest questionWithAnswersRequest = new QuestionWithAnswersRequest();
			questionWithAnswersRequest.setDispositionCode(encounter.getCaseDetails().getDispositionCode());
			questionWithAnswersRequest.setStartingPathwayType(encounter.getCaseDetails().getConditionType());
			questionWithAnswersRequest.setStartingPathwayId(encounter.getCaseDetails().getConditionId());
			
			HashMap<String, String> mappedState = new HashMap<>();
			try {
				mappedState = new ObjectMapper().readValue(encounter.getCaseDetails().getUnstructuredData(), HashMap.class);
			} catch (IOException e) {
				e.printStackTrace();
			}
			questionWithAnswersRequest.setState(mappedState);
			
			questionWithAnswersRequest.setSteps(ConvertStep(encounter.getCaseDetails().getCaseSteps()));
			
			return questionWithAnswersRequest;
		}
		return new QuestionWithAnswersRequest();
	}
	
	private List<Step> ConvertStep(List<StepInstance> stepInstances){
		
		List<Step> steps = new ArrayList<Step>();
		
		for(Iterator<StepInstance> i = stepInstances.iterator(); i.hasNext();){
			StepInstance stepInstance = i.next();
			Step step = new Step();
			step.setAnswer(new Answer());
			step.getAnswer().setOrder(stepInstance.getAnswerOrder());
			step.setQuestionId(stepInstance.getQuestionId());
			step.setQuestionNo(stepInstance.getQuestionNo());
			steps.add(step);
		}
		
		return steps;
	}
}