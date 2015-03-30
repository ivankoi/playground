package com.packtpub.client.example3;



import java.util.*;

import javax.naming.*;

import com.packtpub.ejb.example3.*;
import com.packtpub.jpa.example3.*;


public class TestAppStore {

	public static void main(String[] args) throws Exception {
		Hashtable hash = new Hashtable();
		hash.put("java.naming.factory.initial","org.jnp.interfaces.NamingContextFactory");
		hash.put("java.naming.provider.url","jnp://localhost:1099");
		hash.put("java.naming.factory.url.pkgs","org.jnp.interfaces");

		Context ctx = new InitialContext(hash);

		StoreManager storeManager = (StoreManager)ctx.lookup("AppStoreEJB/remote");  

		// Create a Customer [1]
		storeManager.createCustomer("Usa","Clint Eastwood");

		// Retrieve the Customer [2]
		Customer customer = storeManager.findCustomerByName("Clint Eastwood");

		// Save an order for an Item
		storeManager.saveOrder(customer.getId(), 1000,5, "Bycycle");

		// Find all Items ordered by the Customer [3]
		List<Item> items = storeManager.findAllItems(customer.getId());

		System.out.println("Listing orders for "+customer.getName());
		Iterator <Item> iter = items.iterator();
		while (iter.hasNext()) {
			Item item = iter.next();
			System.out.println("----------------");
			System.out.println("id #" +item.getId());
			System.out.println("product #" +item.getProduct());
			System.out.println("qty #" +item.getQuantity());
			System.out.println("$ #" +item.getPrice());
		}

	}

}
