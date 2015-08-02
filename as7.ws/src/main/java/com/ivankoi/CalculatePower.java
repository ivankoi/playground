
package com.ivankoi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for calculatePower complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="calculatePower">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="base" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="exponent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculatePower", propOrder = {
    "base",
    "exponent"
})
public class CalculatePower {

    protected double base;
    protected double exponent;

    /**
     * Gets the value of the base property.
     * 
     */
    public double getBase() {
        return base;
    }

    /**
     * Sets the value of the base property.
     * 
     */
    public void setBase(double value) {
        this.base = value;
    }

    /**
     * Gets the value of the exponent property.
     * 
     */
    public double getExponent() {
        return exponent;
    }

    /**
     * Sets the value of the exponent property.
     * 
     */
    public void setExponent(double value) {
        this.exponent = value;
    }

}
