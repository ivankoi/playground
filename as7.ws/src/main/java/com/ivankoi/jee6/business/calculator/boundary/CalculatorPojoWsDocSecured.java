package com.ivankoi.jee6.business.calculator.boundary;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.jboss.ws.api.annotation.EndpointConfig;

@WebService(targetNamespace="http://www.ivankoi.com/", serviceName="Calculator_pojo_ws_doc_secured", wsdlLocation="WEB-INF/wsdl/CalculatorPojoWsDocSecured.wsdl")
@SOAPBinding(style=Style.DOCUMENT)
@EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName = "Custom WS-Security")

public class CalculatorPojoWsDocSecured {
	
	@WebMethod
	@WebResult(name="result")
	public double calculatePower(@WebParam(name="base") double argument, @WebParam(name="exponent") double power) {
		return Math.pow(argument, power);
	}
}
