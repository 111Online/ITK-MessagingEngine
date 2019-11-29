package OctopusConsortium.Core.Transformers.ITK;

//import java.io.ByteArrayOutputStream;
//import java.io.OutputStream;

import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractTransformer;
import org.xhtmlrenderer.pdf.ITextRenderer;
//import org.xhtmlrenderer.simple.XHTMLPanel;

public class CdaHtmlToPdfTransformer
	extends AbstractTransformer {

	@Override
	protected Object doTransform(Object src, String enc)
			throws TransformerException {
	    
		//OutputStream os = new ByteArrayOutputStream();
		
	    ITextRenderer renderer = new ITextRenderer();
	    renderer.setDocumentFromString(new String((byte[])src));
	    renderer.layout();
	    try {
	    	//renderer.createPDF(os);
	    } catch (Exception e) {
	    	throw new TransformerException(this, e);
	    }
	    return null;
	}

}
