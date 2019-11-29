package OctopusConsortium.PDSMiniServicesV1;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2012-09-11T14:29:56.846+01:00
 * Generated source version: 2.6.2
 * 
 */
@WebServiceClient(name = "verifyNHSNumber-v1-0", 
                  //wsdlLocation = "file:/C:/111/docs/Spine/Schemas/Schemas/wsdl/PDSMiniServices-v1-0.wsdl",
				  wsdlLocation = "classpath:schemas/PDS/PDSMiniServices/wsdl/PDSMiniServices-v1-0.wsdl",
                  targetNamespace = "urn:nhs-itk:ns:201005") 
public class VerifyNHSNumberV10 extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:nhs-itk:ns:201005", "verifyNHSNumber-v1-0");
    public final static QName VerifyNHSNumberV10PttPort = new QName("urn:nhs-itk:ns:201005", "verifyNHSNumber-v1-0_pttPort");
    static {
        URL url = null;
        //url = new URL("file:/C:/111/docs/Spine/Schemas/Schemas/wsdl/PDSMiniServices-v1-0.wsdl");
		url = VerifyNHSNumberV10.class.getClassLoader().getResource("schemas/PDS/PDSMiniServices/wsdl/PDSMiniServices-v1-0.wsdl");
        WSDL_LOCATION = url;
    }

    public VerifyNHSNumberV10(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public VerifyNHSNumberV10(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VerifyNHSNumberV10() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     *
     * @return
     *     returns VerifyNHSNumberV10Ptt
     */
    @WebEndpoint(name = "verifyNHSNumber-v1-0_pttPort")
    public VerifyNHSNumberV10Ptt getVerifyNHSNumberV10PttPort() {
        return super.getPort(VerifyNHSNumberV10PttPort, VerifyNHSNumberV10Ptt.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VerifyNHSNumberV10Ptt
     */
    @WebEndpoint(name = "verifyNHSNumber-v1-0_pttPort")
    public VerifyNHSNumberV10Ptt getVerifyNHSNumberV10PttPort(WebServiceFeature... features) {
        return super.getPort(VerifyNHSNumberV10PttPort, VerifyNHSNumberV10Ptt.class, features);
    }

}
