package com.packpub.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.ejb3.annotation.RemoteBinding;

import com.ivankoi.Customer;
import com.ivankoi.Item;
import com.packtpub.ejb.example3.StoreManager;

@Stateless
@RemoteBinding(jndiBinding="StoreManagerEJB/remote")
@WebService(targetNamespace = "http://www.packtpub.com/", serviceName = "StoreManagerEJBTopDown")
public class StoreManagerEJBTopDownSeviceEnpoint implements StoreManagerTopDown {
	
	static Log LOG = LogFactory.getLog(StoreManagerEJBTopDownSeviceEnpoint.class);
	
	@EJB(mappedName = "AppStoreEJB/local")  
	private StoreManager storeManager;
	
	/**
     * 
     * @param customerName
     * @param customerCountry
     */
    @WebMethod
    @RequestWrapper(localName = "createCustomer", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.CreateCustomer")
    @ResponseWrapper(localName = "createCustomerResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.CreateCustomerResponse")
    public void createCustomer(
        @WebParam(name = "customerCountry", targetNamespace = "")
        String customerCountry,
        @WebParam(name = "customerName", targetNamespace = "")
        String customerName) {
        	return;
        }

    /**
     * 
     * @return
     *     returns java.util.List<com.ivankoi.Customer>
     */
    @WebMethod
    @WebResult(name = "customerList", targetNamespace = "")
    @RequestWrapper(localName = "findAllCustomers", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindAllCustomers")
    @ResponseWrapper(localName = "findAllCustomersResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindAllCustomersResponse")
    public List<Customer> findAllCustomers() {
    	LOG.debug("findAllCustomers() debug");
		LOG.info("findAllCustomers() info");
		LOG.warn("findAllCustomers() warn");
		LOG.error("findAllCustomers() error");
		
		List<Customer> result = new ArrayList<Customer>();
		
		List<com.packtpub.jpa.example3.Customer> customersEntities = storeManager.findAllCustomers();
		for (com.packtpub.jpa.example3.Customer customer : customersEntities) {
			Customer customerJaxb = new Customer();
			customerJaxb.setId(customer.getId());
			customerJaxb.setName(customer.getName());
			customerJaxb.setCountry(customer.getCountry());
			
			result.add(customerJaxb);
		}
		
		return result;
    }

    /**
     * 
     * @param customerId
     * @return
     *     returns java.util.List<com.ivankoi.Item>
     */
    @WebMethod
    @WebResult(name = "itemList", targetNamespace = "")
    @RequestWrapper(localName = "findAllItems", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindAllItems")
    @ResponseWrapper(localName = "findAllItemsResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindAllItemsResponse")
    public List<Item> findAllItems(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId) {
    	return null;
    }

    /**
     * 
     * @param customerId
     * @return
     *     returns com.ivankoi.Customer
     */
    @WebMethod
    @WebResult(name = "customer", targetNamespace = "")
    @RequestWrapper(localName = "findCustomerById", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindCustomerById")
    @ResponseWrapper(localName = "findCustomerByIdResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindCustomerByIdResponse")
    public Customer findCustomerById(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId) {
        	return null;
    }

    /**
     * 
     * @param customerName
     * @return
     *     returns com.ivankoi.Customer
     */
    @WebMethod
    @WebResult(name = "customer", targetNamespace = "")
    @RequestWrapper(localName = "findCustomerByName", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindCustomerByName")
    @ResponseWrapper(localName = "findCustomerByNameResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindCustomerByNameResponse")
    public Customer findCustomerByName(
        @WebParam(name = "customerName", targetNamespace = "")
        String customerName) {
        	return null;
    }
    
    /**
     * 
     * @param product
     * @param price
     * @param customerId
     * @param quantity
     */
    @WebMethod
    @RequestWrapper(localName = "saveOrder", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.SaveOrder")
    @ResponseWrapper(localName = "saveOrderResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.SaveOrderResponse")
    public void saveOrder(
        @WebParam(name = "customerId", targetNamespace = "")
        int customerId,
        @WebParam(name = "price", targetNamespace = "")
        int price,
        @WebParam(name = "quantity", targetNamespace = "")
        int quantity,
        @WebParam(name = "product", targetNamespace = "")
        String product) {
        	return;
        }
    
		

}
