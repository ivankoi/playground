package com.packpub.ws;

import java.util.List;

import com.packtpub.ejb.example3.StoreManager;
import com.packtpub.ejb.example3.StoreManagerRemote;
import com.packtpub.jpa.example3.Customer;
import com.packtpub.jpa.example3.Item;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://www.ivankoi.com", serviceName="StoreManagerWebService")
public class StoreManagerWebEndpoint implements StoreManagerRemote {

	@EJB(mappedName = "AppStoreEJB/local") 
	StoreManager storeManager;
	
	@WebMethod
	public void createCustomer(@WebParam(name="customerCountry") String country, @WebParam(name="customerName") String name) {
		storeManager.createCustomer(country, name);
	}

	@WebMethod
	@WebResult(name="customerList")
	public List<Customer> findAllCustomers() {
		return storeManager.findAllCustomers();
	}

	@WebMethod
	@WebResult(name="customer")
	public Customer findCustomerByName(@WebParam(name="customerName") String name) {
		return storeManager.findCustomerByName(name);
	}

	@WebMethod
	@WebResult(name="customer")
	public Customer findCustomerById(@WebParam(name="customerId") int id) {
		return storeManager.findCustomerById(id);
	}

	@WebMethod
	public void saveOrder(@WebParam(name="customerId") int idCustomer, 
						  @WebParam(name="price") int price, 
						  @WebParam(name="quantity") int quantity,
						  @WebParam(name="product") String product) {
		storeManager.saveOrder(idCustomer, price, quantity, product);
	}

	@WebMethod
	@WebResult(name="itemList")
	public List<Item> findAllItems(@WebParam(name="customerId") int customerId) {
		return storeManager.findAllItems(customerId);
	}
	
}
