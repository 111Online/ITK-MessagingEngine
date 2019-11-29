package OctopusConsortium.Core;

import java.io.InputStream;

import org.w3c.dom.ls.LSInput;

public class LSInputImpl implements LSInput
{

    private String baseURI;
	public java.io.Reader getCharacterStream () {
        return null;
    }

    @Override
	public void setCharacterStream(java.io.Reader arg0) {
	}
    
    public InputStream getByteStream () {
        InputStream retval = null;
        if ( byteStream != null ) {
            retval = byteStream;
        }
        return retval;
    }

    public void setByteStream ( InputStream byteStream ) {
        this.byteStream = byteStream;
    }

    public String getStringData () {
        return null;
    }

    public void setStringData ( String stringData ) {}

    public String getSystemId () {
        return systemId;
    }

    public void setSystemId ( String systemId ) {
        this.systemId = systemId;
    }

    public String getPublicId () {
        return null;
    }

    public void setPublicId ( String publicId ) {}

    public String getBaseURI () {
        return this.baseURI;
    }

    public void setBaseURI ( String baseURI ) {
    	this.baseURI=baseURI;
    }

    public String getEncoding () {
        return null;
    }

    public void setEncoding ( String encoding ) {}

    public boolean getCertifiedText () {
        return false;
    }

    public void setCertifiedText ( boolean certifiedText ) {}


    private String systemId = null;
    private InputStream byteStream = null;
	
}