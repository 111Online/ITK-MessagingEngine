package OctopusConsortium.Models.DOS.Proxy.Request;

import org.codehaus.jackson.annotate.JsonProperty;

public class Services {
	@JsonProperty("ServiceVersion")
	private String serviceVersion;
	@JsonProperty("UserInfo")
	private UserInfo userInfo;
	@JsonProperty("ServiceId")
	private String serviceId;

	@JsonProperty("ServiceVersion")
	public String getServiceVersion() {
		return serviceVersion;
	}

	@JsonProperty("ServiceVersion")
	public void setServiceVersion(String serviceVersion) {
		this.serviceVersion = serviceVersion;
	}

	@JsonProperty("UserInfo")
	public UserInfo getUserInfo() {
		return userInfo;
	}

	@JsonProperty("UserInfo")
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@JsonProperty("ServiceId")
	public String getServiceId() {
		return serviceId;
	}

	@JsonProperty("ServiceId")
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}
}