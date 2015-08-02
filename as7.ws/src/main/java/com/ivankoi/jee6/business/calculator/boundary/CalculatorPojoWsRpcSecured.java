package com.ivankoi.jee6.business.calculator.boundary;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService(targetNamespace="http://www.ivankoi.com/", serviceName="Calculator_pojo_ws_rpc_secured", wsdlLocation="WEB-INF/wsdl/CalculatorPojoWsRpcSecured.wsdl")
@SOAPBinding(style=Style.RPC)
public class CalculatorPojoWsRpcSecured {
	
	@WebMethod
	@WebResult(name="result")
	public double calculatePower(@WebParam(name="base") double argument, @WebParam(name="exponent") double power) {
		return Math.pow(argument, power);
	}
}
