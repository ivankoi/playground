package com.ivankoi;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2015-08-01T22:18:18.341+02:00
 * Generated source version: 2.4.6
 * 
 */
@WebService(targetNamespace = "http://www.ivankoi.com/", name = "CalculatorPojoWsDocSecured")
@XmlSeeAlso({ObjectFactory.class})
public interface CalculatorPojoWsDocSecured {

    @WebResult(name = "result", targetNamespace = "")
    @RequestWrapper(localName = "calculatePower", targetNamespace = "http://www.ivankoi.com/", className = "com.ivankoi.CalculatePower")
    @WebMethod
    @ResponseWrapper(localName = "calculatePowerResponse", targetNamespace = "http://www.ivankoi.com/", className = "com.ivankoi.CalculatePowerResponse")
    public double calculatePower(
        @WebParam(name = "base", targetNamespace = "")
        double base,
        @WebParam(name = "exponent", targetNamespace = "")
        double exponent
    );
}