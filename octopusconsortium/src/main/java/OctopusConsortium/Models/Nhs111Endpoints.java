package OctopusConsortium.Models;

import java.util.ArrayList;
import java.util.List;



public class Nhs111Endpoints {
	protected List<Nhs111Endpoint> endpoints;

	public Nhs111Endpoints() {
		super();
		endpoints = new ArrayList<Nhs111Endpoint>();
	}

	/**
	 * @return the endpoints
	 */
	public List<Nhs111Endpoint> getEndpoints() {
		return endpoints;
	}

	/**
	 * @param endpoints the endpoints to set
	 */
	public void setEndpoints(List<Nhs111Endpoint> endpoints) {
		this.endpoints = endpoints;
	}

}
