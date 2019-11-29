package OctopusConsortium.Models.PostCodes;

public class OOHPreferredProvider {

	public int getServiceId() {
		return _serviceId;
	}

	public void setServiceId(int _serviceId) {
		this._serviceId = _serviceId;
	}

	public String getOdsCode() {
		return _odsCode;
	}

	public void setOdsCode(String _odsCode) {
		this._odsCode = _odsCode;
	}

	public String getServicePostcode() {
		return _postcode;
	}

	public void setServicePostcode(String _postcode) {
		this._postcode = _postcode;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String _address) {
		this._address = _address;
	}

	public String getName() {
		return _name;
	}

	public void setName(String _name) {
		this._name = _name;
	}
	
	public boolean getIsDoSAllowed() {
		return _isDoSAllowed;
	}

	public void setIsDoSAllowed(boolean _isDoSAllowed) {
		this._isDoSAllowed = _isDoSAllowed;
	}

	private int _serviceId;
	private String _odsCode;
	private String _postcode;
	private String _address;
	private String _name;
	private boolean _isDoSAllowed;


}
