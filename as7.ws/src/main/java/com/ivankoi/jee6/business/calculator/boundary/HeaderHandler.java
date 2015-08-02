package com.ivankoi.jee6.business.calculator.boundary;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Set;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.w3c.dom.Document;

/**
 *
 * @author www.javadb.com
 */
public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

	String login;
	String password;
	
	public HeaderHandler(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	
    public boolean handleMessage(SOAPMessageContext smc) {
    	
    	WSSecUsernameToken addUsernameToken = new WSSecUsernameToken();
		addUsernameToken.setPasswordType( WSConstants.PASSWORD_DIGEST );

		addUsernameToken.setUserInfo(login, password);
		addUsernameToken.addNonce();
		addUsernameToken.addCreated();
		
//		StringWriter writer = new StringWriter();

		WSSecHeader secHeader = new WSSecHeader();
		
		try {
			Document doc = toDocument(smc.getMessage());
			
			secHeader.insertSecurityHeader( doc);
			doc = addUsernameToken.build( doc, secHeader );
			
			InputStream is = docToInputStream(doc);
	
	
			SOAPMessage resultMEssage = MessageFactory.newInstance().createMessage(smc.getMessage().getMimeHeaders(), is);
			
			smc.setMessage(resultMEssage);
		
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		
		
		
		return true;
    }

	private InputStream docToInputStream(Document doc)
			throws TransformerException, TransformerConfigurationException,
			TransformerFactoryConfigurationError {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		Source xmlSource = new DOMSource(doc);
		Result outputTarget = new StreamResult(outputStream);
		TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
		InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
		return is;
	}

    public String getStringFromDocument(Document doc)
    {
        try
        {
           DOMSource domSource = new DOMSource(doc);
           StringWriter writer = new StringWriter();
           StreamResult result = new StreamResult(writer);
           TransformerFactory tf = TransformerFactory.newInstance();
           Transformer transformer = tf.newTransformer();
           transformer.transform(domSource, result);
           return writer.toString();
        }
        catch(TransformerException ex)
        {
           ex.printStackTrace();
           return null;
        }
    } 
    
    public Document toDocument(SOAPMessage soapMsg)   
            throws TransformerConfigurationException, TransformerException, SOAPException, IOException {  
		Source src = soapMsg.getSOAPPart().getContent();  
		TransformerFactory tf = TransformerFactory.newInstance();  
		Transformer transformer = tf.newTransformer();  
		DOMResult result = new DOMResult();  
		transformer.transform(src, result);  
		return (Document)result.getNode();  
	} 
    
    @SuppressWarnings("all")
    public Set getHeaders() {
        //throw new UnsupportedOperationException("Not supported yet.");
        return null;
    }

    public boolean handleFault(SOAPMessageContext context) {
        //throw new UnsupportedOperationException("Not supported yet.");
        return true;
    }

    public void close(MessageContext context) {
    //throw new UnsupportedOperationException("Not supported yet.");
    }
}
