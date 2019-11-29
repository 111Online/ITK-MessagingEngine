package OctopusConsortium.Models.PathwaysTriage;

import org.codehaus.jackson.annotate.JsonProperty;

public class AssociatedPathway {
	
	@JsonProperty
	private String id;
	@JsonProperty
	private String	title;
	@JsonProperty
	private String pathwayNo;
	@JsonProperty
	private String gender;
	@JsonProperty
	private String  minimumAgeInclusive;
	@JsonProperty
	private String maximumAgeExclusive;
	@JsonProperty
	private String module;
	@JsonProperty
	private String symptomGroup;
	@JsonProperty
	private String group;
	@JsonProperty
	private String keywords;
	@JsonProperty
	private String excludeKeywords;
	@JsonProperty
	private String startingPathway;
	@JsonProperty	
	private String traumaType;
	@JsonProperty
    private String majorVersion;
	@JsonProperty
    private String minorVersion;
	@JsonProperty
    private String subRevision;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPathwayNo() {
		return pathwayNo;
	}
	public void setPathwayNo(String pathwayNo) {
		this.pathwayNo = pathwayNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMinimumAgeInclusive() {
		return minimumAgeInclusive;
	}
	public void setMinimumAgeInclusive(String minimumAgeInclusive) {
		this.minimumAgeInclusive = minimumAgeInclusive;
	}
	public String getMaximumAgeExclusive() {
		return maximumAgeExclusive;
	}
	public void setMaximumAgeExclusive(String maximumAgeExclusive) {
		this.maximumAgeExclusive = maximumAgeExclusive;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getSymptomGroup() {
		return symptomGroup;
	}
	public void setSymptomGroup(String symptomGroup) {
		this.symptomGroup = symptomGroup;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
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
	public String getStartingPathway() {
		return startingPathway;
	}
	public void setStartingPathway(String startingPathway) {
		this.startingPathway = startingPathway;
	}
	public String getTraumaType() {
		return traumaType;
	}
	public void setTraumaType(String traumaType) {
		this.traumaType = traumaType;
	}
	public String getMajorVersion() {
		return majorVersion;
	}
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}
	public String getMinorVersion() {
		return majorVersion;
	}
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}
	public String getSubRevision() {
		return subRevision;
	}
	public void setSubRevision(String subRevision) {
		this.subRevision = subRevision;
	}
}