
package OctopusConsortium.RepeatCallerServiceV1;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.6.2
 * 2012-09-20T12:44:15.106+01:00
 * Generated source version: 2.6.2
 * 
 */
public final class SendNHS111ReportV20Ptt_SendNHS111ReportV20PttPort_Client {

    private static final QName SERVICE_NAME = new QName("urn:nhs-itk:ns:201005", "NHS111");

    private SendNHS111ReportV20Ptt_SendNHS111ReportV20PttPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = NHS111.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        NHS111 ss = new NHS111(wsdlURL, SERVICE_NAME);
        SendNHS111ReportV20Ptt port = ss.getSendNHS111ReportV20PttPort();  
        
        {
        System.out.println("Invoking sendNHS111ReportV20...");
        OctopusConsortium.RepeatCallerServiceV1.DistributionEnvelopeType _sendNHS111ReportV20_sendNHS111ReportV20 = null;
        try {
            java.lang.String _sendNHS111ReportV20__return = port.sendNHS111ReportV20(_sendNHS111ReportV20_sendNHS111ReportV20);
            System.out.println("sendNHS111ReportV20.result=" + _sendNHS111ReportV20__return);

        } catch (SendNHS111ReportV20PttSendNHS111ReportV20ToolkitErrorInfoFaultMessage e) { 
            System.out.println("Expected exception: SendNHS111Report-v2-0_ptt_SendNHS111Report-v2-0_ToolkitErrorInfo_FaultMessage has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}