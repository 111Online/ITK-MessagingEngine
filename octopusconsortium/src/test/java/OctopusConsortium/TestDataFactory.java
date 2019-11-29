package OctopusConsortium;

public class TestDataFactory {
	public static IdentifyPatientRequestBuilder getIdentifyPatientRequest() {
		return new IdentifyPatientRequestBuilder();
	}
	
	public static PdsMappingBuilder getPdsMapping() { 
		return new PdsMappingBuilder();
	}
}
