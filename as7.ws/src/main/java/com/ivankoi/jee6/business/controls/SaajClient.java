package com.ivankoi.jee6.business.controls;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.dom.DOMSource;

import org.apache.ws.security.WSConstants;
import org.apache.ws.security.message.WSSecHeader;
import org.apache.ws.security.message.WSSecUsernameToken;
import org.apache.xml.security.c14n.Canonicalizer;
import org.w3c.dom.Document;

import eu.europa.ec.research.fp.services.project_financial.interfaces.v4.SearchFinancialStatementsResponseType;

public abstract class SaajClient {

	public SaajClient() {
		super();
	}

	protected Document buildDocumentWithSecuredHeader(String requestBody, String username,
			String password) throws Exception {
				WSSecUsernameToken addUsernameToken = new WSSecUsernameToken();
				addUsernameToken.setPasswordType( WSConstants.PASSWORD_DIGEST );
			
				addUsernameToken.setUserInfo(username, password);
				addUsernameToken.addNonce();
				addUsernameToken.addCreated();
				
			 	Document doc = null;
				
				doc = toSOAPPart(requestBody);
			 	WSSecHeader secHeader = new WSSecHeader();
			 	
			 	secHeader.insertSecurityHeader(doc);
			 	
			 	return addUsernameToken.build(doc, secHeader);
			}

	protected SearchFinancialStatementsResponseType soapMessageToTypedResponse(
			SOAPMessage response) throws SOAPException, JAXBException {
		DOMSource source = new DOMSource(response.getSOAPBody().getFirstChild());
		
		JAXBContext context = JAXBContext.newInstance(SearchFinancialStatementsResponseType.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		JAXBElement<SearchFinancialStatementsResponseType> result = unmarshaller.unmarshal(source, SearchFinancialStatementsResponseType.class);
		return result.getValue();
	}
	
	protected SOAPMessage callWithSaaj(Document requestDoc) throws SOAPException, Exception {
		
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		SOAPConnection connection = soapConnectionFactory.createConnection();
		
		URL endpoint = new URL(getWsEndpoint());
		
		return connection.call(toSOAPMessage(requestDoc), endpoint);
	}

	protected String prepareRequestFromTemplate(String template, HashMap<String, String> parameters) {
		String result = template;
		for (Entry<String, String> entry : parameters.entrySet()) {
			result = result.replaceAll(entry.getKey(), entry.getValue());
		}
		return result;
	}
	
	protected abstract String getWsEndpoint();

	protected Document toSOAPPart(String xml) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
	    InputStream in = new ByteArrayInputStream(xml.getBytes());
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    return builder.parse(in);
	}

	/**
	 * Convert a DOM Document into a soap message. <p/>
	 * 
	 * @param doc
	 * @return
	 * @throws Exception
	 */
	protected SOAPMessage toSOAPMessage(Document doc) throws Exception {
		Canonicalizer c14n = Canonicalizer
				.getInstance(Canonicalizer.ALGO_ID_C14N_WITH_COMMENTS);
		byte[] canonicalMessage = c14n.canonicalizeSubtree(doc);
		ByteArrayInputStream in = new ByteArrayInputStream(canonicalMessage);
		MessageFactory factory = MessageFactory.newInstance();
		return factory.createMessage(null, in);
	}

}