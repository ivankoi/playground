
package com.ivankoi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ivankoi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CalculatePowerResponse_QNAME = new QName("http://www.ivankoi.com/", "calculatePowerResponse");
    private final static QName _CalculatePower_QNAME = new QName("http://www.ivankoi.com/", "calculatePower");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ivankoi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculatePower }
     * 
     */
    public CalculatePower createCalculatePower() {
        return new CalculatePower();
    }

    /**
     * Create an instance of {@link CalculatePowerResponse }
     * 
     */
    public CalculatePowerResponse createCalculatePowerResponse() {
        return new CalculatePowerResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePowerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com/", name = "calculatePowerResponse")
    public JAXBElement<CalculatePowerResponse> createCalculatePowerResponse(CalculatePowerResponse value) {
        return new JAXBElement<CalculatePowerResponse>(_CalculatePowerResponse_QNAME, CalculatePowerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculatePower }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com/", name = "calculatePower")
    public JAXBElement<CalculatePower> createCalculatePower(CalculatePower value) {
        return new JAXBElement<CalculatePower>(_CalculatePower_QNAME, CalculatePower.class, null, value);
    }

}
