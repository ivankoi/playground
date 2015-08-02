package com.ivankoi;

import static junit.framework.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.ws.security.SecurityConstants;
import org.junit.Test;

import com.ivankoi.jee6.business.calculator.boundary.HeaderHandlerResolver;

public class CalculatorPojoWsDocSecured_ServiceTest {

//	private static final QName SERVICE_NAME = new QName("http://www.ivankoi.com/", "Calculator_pojo_ws_doc");
	
	@Test
	public void testJaxWs() {
		CalculatorPojoWsDocSecured_Service service = new CalculatorPojoWsDocSecured_Service();
		CalculatorPojoWsDocSecured port = service.getCalculatorPojoWsDocSecuredPort();
		
		double actual = port.calculatePower(2, 4);
		assertEquals(16.0, actual);
		
	}

	
	@Test
	public void testJaxWsFactoryBean() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost:8090/as7.ws/CalculatorPojoWsDocSecured");
        CalculatorPojoWsDocSecured client = factory.create(CalculatorPojoWsDocSecured.class);
        
        double actual = client.calculatePower(2, 4);
        assertEquals(16.0, actual);
	}
	

	@Test
	public void testSecurity() throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:8090/as7.ws/CalculatorPojoWsDocSecured?wsdl");
        QName qname = new QName("http://www.ivankoi.com/", "Calculator_pojo_ws_doc_secured");
        
        Service service = Service.create(wsdlURL, qname);
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver("ivankiv", "password");
		service.setHandlerResolver(handlerResolver);
		
        CalculatorPojoWsDocSecured port = (CalculatorPojoWsDocSecured) service.getPort(CalculatorPojoWsDocSecured.class);
 
        Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8090/as7.ws/CalculatorPojoWsDocSecured");
 
        double actual = port.calculatePower(2, 4);
        assertEquals(16.0, actual);
	}
	
	@Test
	public void testApacheCXF() throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:8090/as7.ws/CalculatorPojoWsDocSecured?wsdl");
        QName qname = new QName("http://www.ivankoi.com/", "Calculator_pojo_ws_doc_secured");
        
        Service service = Service.create(wsdlURL, qname);
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver("ivankiv", "password");
		service.setHandlerResolver(handlerResolver);
		
        CalculatorPojoWsDocSecured port = (CalculatorPojoWsDocSecured) service.getPort(CalculatorPojoWsDocSecured.class);
 
        Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8090/as7.ws/CalculatorPojoWsDocSecured");
 
        double actual = port.calculatePower(2, 4);
        assertEquals(16.0, actual);
	}
}
