package OctopusConsortium.Models.PathwaysTriage;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class QuestionWithAnswersRequest {

    @JsonProperty
    private String dispositionCode;
    @JsonProperty
    private String startingPathwayType;
    @JsonProperty
    private String startingPathwayId;
    @JsonProperty
    private Map<String, String> state;
    @JsonProperty
    private List<Step> steps;

    public String getDispositionCode() {
        return dispositionCode;
    }

    public void setDispositionCode(String dispositionCode) {
        this.dispositionCode = dispositionCode;
    }

    public String getStartingPathwayType() {
        return startingPathwayType;
    }

    public void setStartingPathwayType(String startingPathwayType) {
        this.startingPathwayType = startingPathwayType;
    }

    public String getStartingPathwayId() {
        return startingPathwayId;
    }

    public void setStartingPathwayId(String startingPathwayId) {
        this.startingPathwayId = startingPathwayId;
    }

    public Map<String, String> getState() {
        return state;
    }

    public void setState(Map<String, String> state) {
        this.state = state;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }

}
