package OctopusConsortium;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;

import java.util.ArrayList;
import java.util.List;

import com.github.tomakehurst.wiremock.client.UrlMatchingStrategy;
import com.github.tomakehurst.wiremock.client.ValueMatchingStrategy;
import com.github.tomakehurst.wiremock.client.WireMock;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import com.github.tomakehurst.wiremock.client.MappingBuilder;

public class PdsMappingBuilder {

	private UrlMatchingStrategy _urlStrategy;
	private List<ValueMatchingStrategy> _valueStrategy;
	private int _statusCode;
	private String _body;

	public PdsMappingBuilder() {
		_urlStrategy = urlEqualTo("/app/api/pds");
		_valueStrategy = new ArrayList<ValueMatchingStrategy>();
		_valueStrategy.add(containing("service=\"urn:nhs-itk:services:201005:getPatientDetails-v1-0\""));
		_statusCode = 200;
		_body = "";
	}
	
	public PdsMappingBuilder withUrlMatchingStrategy(UrlMatchingStrategy urlStrategy) {
		this._urlStrategy = urlStrategy;
		return this;
	}
	
	public PdsMappingBuilder withRequestBody(ValueMatchingStrategy valueStrategy) {
		this._valueStrategy.add(valueStrategy);
		return this;
	}
	
	public PdsMappingBuilder withStatusCode(int statusCode) {
		this._statusCode = statusCode;
		return this;
	}
	
	public PdsMappingBuilder withBody(String body) {
		this._body = body;
		return this;
	}
	
	public MappingBuilder build() {
		MappingBuilder mapping = WireMock.post(_urlStrategy);
		for (ValueMatchingStrategy strat : _valueStrategy) {
			mapping.withRequestBody(strat);
		}
		
		return mapping.willReturn(aResponse()
						.withStatus(_statusCode)
						.withHeader("Content-Type", "text/xml")
						.withBody(_body));
	}	
}
