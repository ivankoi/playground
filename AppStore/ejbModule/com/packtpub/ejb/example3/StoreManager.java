package com.packtpub.ejb.example3;

import java.util.List;

import javax.ejb.Local;

import com.packtpub.jpa.example3.Customer;
import com.packtpub.jpa.example3.Item; 


public interface StoreManager {

	public void createCustomer(String country,String name);
	public List<Customer> findAllCustomers();
	public Customer findCustomerByName(String name);
	public Customer findCustomerById(int id);
	
	public void saveOrder(int idCustomer, int price,
            int quantity,String product);
	public List<Item> findAllItems(int customerId);

	
}
