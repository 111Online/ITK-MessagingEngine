package OctopusConsortium.Core;

import org.mule.transformer.AbstractTransformer;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import OctopusConsortium.Service.Models.Authentication;

public class AuthenticationVerifyTokens extends AbstractTransformer {

	protected String usernameList;
	public String getUsernameList(){
		return this.usernameList;	
	}
	
	public void setUsernameList(String usernameList){
		this.usernameList = usernameList;
	}
	
	protected String passwordList;
	public String getPasswordList(){
		return this.passwordList;	
	}
	
	public void setPasswordList(String passwordList){
		this.passwordList = passwordList;
	}
	public void setAuthenticationProviderManager(ProviderManager value) {
		_authenticationProviderManager = value;
	}
	
	@Override
	protected Object doTransform(Object payload, String enc) {
		if(payload instanceof Authentication) {
			return authenticate((Authentication)payload);
		}

		return false;
	}
	
	private boolean authenticate(Authentication auth) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(auth.getUsername(), auth.getPassword());

		try {
			org.springframework.security.core.Authentication result = _authenticationProviderManager.authenticate(token);
			
			if(result.isAuthenticated()) {
				auth.setRoles(result.getAuthorities());
				return true;
			}
		}
		catch(Exception e) {
			return false;
		}
		return false;
	}
	
	private ProviderManager _authenticationProviderManager;
}