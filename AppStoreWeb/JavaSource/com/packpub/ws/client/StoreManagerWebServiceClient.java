package com.packpub.ws.client;

import java.util.List;

import com.ivankoi.Customer;
import com.ivankoi.StoreManagerWebEndpoint;
import com.ivankoi.StoreManagerWebService;

public class StoreManagerWebServiceClient {
	public static void main(String[] args) {
		
		StoreManagerWebService service = new StoreManagerWebService();
		StoreManagerWebEndpoint port = service.getStoreManagerWebEndpointPort();
		List<Customer> allCustomers = port.findAllCustomers();
		
		for (Customer customer : allCustomers) {
			System.out.println("---------------------------------");
			System.out.println(customer.getId());
			System.out.println(customer.getName());
			System.out.println(customer.getCountry());
			System.out.println("---------------------------------");
		}
	}
}
