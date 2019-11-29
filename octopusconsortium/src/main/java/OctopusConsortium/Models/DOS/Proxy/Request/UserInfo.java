package OctopusConsortium.Models.DOS.Proxy.Request;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserInfo {
	@JsonProperty("Username")
	private String username;
	@JsonProperty("Password")
	private String password;

	@JsonProperty("Username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("Username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("Password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("Password")
	public void setPassword(String password) {
		this.password = password;
	}
}
