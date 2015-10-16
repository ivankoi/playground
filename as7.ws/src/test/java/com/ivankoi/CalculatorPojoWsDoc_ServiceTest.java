package com.ivankoi;



import static junit.framework.Assert.assertEquals;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class CalculatorPojoWsDoc_ServiceTest {

//	private static final QName SERVICE_NAME = new QName("http://www.ivankoi.com/", "Calculator_pojo_ws_doc");
	
	@Test
	public void testJaxWs() {
		CalculatorPojoWsDoc_Service service = new CalculatorPojoWsDoc_Service();
		
		CalculatorPojoWsDoc port = service.getCalculatorPojoWsDocPort();
		
		double actual = port.calculatePower(2, 4);
		assertEquals(16.0, actual);
		
	}

	@Test
	public void testJaxWsFactoryBean() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost:8090/as7.ws/CalculatorPojoWsDoc");
        CalculatorPojoWsDoc client = factory.create(CalculatorPojoWsDoc.class);
        
        double actual = client.calculatePower(2, 4);
        assertEquals(16.0, actual);
	}
	
	
}
