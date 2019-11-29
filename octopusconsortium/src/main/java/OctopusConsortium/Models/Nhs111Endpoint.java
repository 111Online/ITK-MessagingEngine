package OctopusConsortium.Models;

import java.net.MalformedURLException;
import java.net.URL;

import OctopusConsortium.DosService1_5.EndpointTransportType;

public class Nhs111Endpoint {

	protected String url;
	protected URL urlObj;
	protected String interaction;
	protected String format;
	protected EndpointTransportType transport;
	
	public EndpointTransportType getTransport() {
		return transport;
	}
	
	public void setTransport(EndpointTransportType transport) {
		this.transport = transport;
	}

	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
		try {
			urlObj = new URL(url);
		} catch (MalformedURLException e) {
			urlObj = null;
		}
	}		
	/**
	 * @return the interaction
	 */
	public String getInteraction() {
		return interaction;
	}
	/**
	 * @param interaction the interaction to set
	 */
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}
	public String getUrlHost()
	{
		if(urlObj!=null && urlObj.getHost() != null)
			return urlObj.getHost();
		return "";
	}
	public String getUrlPort()
	{
		if(urlObj!=null){
			if(urlObj.getPort() == -1){
				//return default
				return "" + urlObj.getDefaultPort();				
			}
			if (urlObj.getPort() == -1) {
				return "" + urlObj.getDefaultPort();
			}
			else {
				return "" + urlObj.getPort();
			}
		}
		return null;
	}
	public String getUrlPath()
	{
		if(urlObj!=null && urlObj.getPath().indexOf("/")==0)			
			return urlObj.getPath().replaceFirst("/", "");		
		else if(urlObj!=null)
			return urlObj.getPath();
		else
			return null;
	}
	public String getUrlProtocol()
	{
		if(urlObj!=null)
			return "" + urlObj.getProtocol();
		return null;
	}
}
