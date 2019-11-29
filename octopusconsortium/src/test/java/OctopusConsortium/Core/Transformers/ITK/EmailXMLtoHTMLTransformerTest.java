package OctopusConsortium.Core.Transformers.ITK;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Assert;
import org.junit.Test;
import org.mule.api.transformer.DataType;
import org.mule.module.xml.transformer.XsltTransformer;
import org.mule.tck.junit4.FunctionalTestCase;
import org.mule.util.IOUtils;

public class EmailXMLtoHTMLTransformerTest extends FunctionalTestCase  {
	/*
	 * Removed test until I can get the configuration working
	protected String getConfigResources()
	{
	    return "itk_submission.xml,queryspine.xml,message_logging.xml,main.xml";
	}
	
	@Test
    public void testSuccessResponseTransformer() throws Exception {
	    String srcXML = IOUtils.getResourceAsString("c:\\cda.xml", getClass());
	    XsltTransformer xslt = FunctionalTestCase.muleContext.getRegistry().lookupObject("Transform XML to HTML");
	    xslt.setXslFile("C:\\Users\\anaylor\\ITK-MessagingEngine\\Code\\octopusconsortium\\src\\main\\resources\\xsl\\CDA_NPfIT_Document_Renderer_IntegratedUrgentCare.xsl");
	    xslt.setReturnDataType(DataType.STRING_DATA_TYPE);
	    xslt.initialise();
	    String result = (String) xslt.transform(srcXML);
	    String srcData = IOUtils.getResourceAsString("result.xml", getClass());
	    XMLUnit.setIgnoreWhitespace(true);
	    XMLUnit.setIgnoreComments(true);
	    Assert.assertTrue(XMLUnit.compareXML(srcData, result).similar());
	}*/
}