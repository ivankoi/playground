package com.ivankoi;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.6
 * 2015-08-01T22:18:52.857+02:00
 * Generated source version: 2.4.6
 * 
 */
@WebServiceClient(name = "Calculator_pojo_ws_rpc", 
                  wsdlLocation = "file:/C:/Users/ivankoi/AppData/Local/Temp/tempdir3759788797090229398.tmp/CalculatorPojoWsRpc_1.wsdl",
                  targetNamespace = "http://www.ivankoi.com/") 
public class CalculatorPojoWsRpc_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.ivankoi.com/", "Calculator_pojo_ws_rpc");
    public final static QName CalculatorPojoWsRpcPort = new QName("http://www.ivankoi.com/", "CalculatorPojoWsRpcPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/ivankoi/AppData/Local/Temp/tempdir3759788797090229398.tmp/CalculatorPojoWsRpc_1.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CalculatorPojoWsRpc_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/ivankoi/AppData/Local/Temp/tempdir3759788797090229398.tmp/CalculatorPojoWsRpc_1.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CalculatorPojoWsRpc_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CalculatorPojoWsRpc_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CalculatorPojoWsRpc_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CalculatorPojoWsRpc_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CalculatorPojoWsRpc_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CalculatorPojoWsRpc_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns CalculatorPojoWsRpc
     */
    @WebEndpoint(name = "CalculatorPojoWsRpcPort")
    public CalculatorPojoWsRpc getCalculatorPojoWsRpcPort() {
        return super.getPort(CalculatorPojoWsRpcPort, CalculatorPojoWsRpc.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CalculatorPojoWsRpc
     */
    @WebEndpoint(name = "CalculatorPojoWsRpcPort")
    public CalculatorPojoWsRpc getCalculatorPojoWsRpcPort(WebServiceFeature... features) {
        return super.getPort(CalculatorPojoWsRpcPort, CalculatorPojoWsRpc.class, features);
    }

}