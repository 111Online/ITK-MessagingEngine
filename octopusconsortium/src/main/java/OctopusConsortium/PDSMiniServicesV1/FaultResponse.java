
package OctopusConsortium.PDSMiniServicesV1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.6.2
 * 2012-09-11T14:29:56.737+01:00
 * Generated source version: 2.6.2
 */

@WebFault(name = "ToolkitErrorInfo", targetNamespace = "urn:nhs-itk:ns:201005")
public class FaultResponse extends Exception {

	private static final long serialVersionUID = 2708180305600788217L;
	private OctopusConsortium.PDSMiniServicesV1.ToolkitErrorInfoStruct toolkitErrorInfo;

    public FaultResponse() {
        super();
    }
    
    public FaultResponse(String message) {
        super(message);
    }
    
    public FaultResponse(String message, Throwable cause) {
        super(message, cause);
    }

    public FaultResponse(String message, OctopusConsortium.PDSMiniServicesV1.ToolkitErrorInfoStruct toolkitErrorInfo) {
        super(message);
        this.toolkitErrorInfo = toolkitErrorInfo;
    }

    public FaultResponse(String message, OctopusConsortium.PDSMiniServicesV1.ToolkitErrorInfoStruct toolkitErrorInfo, Throwable cause) {
        super(message, cause);
        this.toolkitErrorInfo = toolkitErrorInfo;
    }

    public OctopusConsortium.PDSMiniServicesV1.ToolkitErrorInfoStruct getFaultInfo() {
        return this.toolkitErrorInfo;
    }
}