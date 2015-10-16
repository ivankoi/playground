package com.ivankoi.jee6.business.calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import javax.inject.Named;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import com.ivankoi.CalculatorPojoWsDocSecured;
import com.ivankoi.CalculatorPojoWsDocSecured_Service;
import com.ivankoi.jee6.business.calculator.boundary.HeaderHandlerResolver;

@Named
public class WsConsumer {
	
	
	public void testSemiDynamicService() throws MalformedURLException {
		URL wsdlURL = new URL("http://localhost:8889/as7.ws/CalculatorPojoWsDocSecured?wsdl");
        QName qname = new QName("http://www.ivankoi.com/", "Calculator_pojo_ws_doc_secured");
        
        Service service = Service.create(wsdlURL, qname);
        HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver("ivankiv", "password");
		service.setHandlerResolver(handlerResolver);
		
        CalculatorPojoWsDocSecured port = (CalculatorPojoWsDocSecured) service.getPort(CalculatorPojoWsDocSecured.class);
 
        Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8889/as7.ws/CalculatorPojoWsDocSecured");
 
        double actual = port.calculatePower(2, 4);
        System.out.println("***********************************************");
        System.out.println(actual);
        System.out.println("***********************************************");
	}
	
	public void testStaticService() {
		CalculatorPojoWsDocSecured_Service service = new CalculatorPojoWsDocSecured_Service();
		HeaderHandlerResolver handlerResolver = new HeaderHandlerResolver("ivankiv", "password");
		service.setHandlerResolver(handlerResolver);
		
		CalculatorPojoWsDocSecured port = (CalculatorPojoWsDocSecured) service.getPort(CalculatorPojoWsDocSecured.class);
		 
        Map<String, Object> ctx = ((BindingProvider)port).getRequestContext();
        ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8889/as7.ws/CalculatorPojoWsDocSecured");
 
        double actual = port.calculatePower(2, 4);
        System.out.println("***********************************************");
        System.out.println(actual);
        System.out.println("***********************************************");
	}
}
