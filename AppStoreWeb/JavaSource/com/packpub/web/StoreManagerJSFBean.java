package com.packpub.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.packtpub.ejb.example3.*;
import com.packtpub.jpa.example3.*;

public class StoreManagerJSFBean {

	@EJB(mappedName = "AppStoreEJB/local")  
	private StoreManager storeManager;

	private int customerId;

	private int orderQuantity;
	private int orderPrice;

	private String customerName;
	private String customerCountry;
	private String orderProduct;

	List<Item> listOrders;
	List <SelectItem> listCustomers;

	public StoreManagerJSFBean() { 	}

	public void findOrders() {  

		listOrders = storeManager.findAllItems(customerId);

	}
	public void findAllCustomers() {  

		List<Customer> listCustomersEJB = storeManager.findAllCustomers();

		for (int ii=0;ii<listCustomersEJB.size();ii++) {
			Customer customer = listCustomersEJB.get(ii);
			listCustomers.add(new  SelectItem(customer.getId(),customer.getName()));

		}
	}

	public void saveOrder() { 
		storeManager.saveOrder(customerId,this.orderPrice,this.orderQuantity,this.orderProduct);

		FacesMessage fm = new FacesMessage("Saved order for "+this.orderQuantity+ " of "+this.orderProduct);
		FacesContext.getCurrentInstance().addMessage("Message", fm);

		this.orderPrice=0;
		this.orderQuantity=0;
		this.orderProduct=null;

	}

	public void insertCustomer() {

		storeManager.createCustomer(this.customerCountry, this.customerName);

		FacesMessage fm = new FacesMessage("Created Customer  "+this.customerName+ " from "+this.customerCountry);
		FacesContext.getCurrentInstance().addMessage("Message", fm);

		this.customerName=null;
		this.customerCountry=null;
		// Forces customer reloading
		this.listCustomers=null;
	}

	/* Navigation rules */
	public String home() {  
		return "home";
	}
	public String newOrder() {
		return "newOrder";
	}       
	public String newCustomer() {
		return "newCustomer";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public int getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerCountry() {
		return customerCountry;
	}

	public void setCustomerCountry(String customerCountry) {
		this.customerCountry = customerCountry;
	}

	public String getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}

	public List<Item> getListOrders() {
		return listOrders;
	}

	public void setListOrders(List<Item> listOrders) {
		this.listOrders = listOrders;
	}

	public List<SelectItem> getListCustomers() {
		if (listCustomers == null) {
			listCustomers= new ArrayList();
			findAllCustomers();

		}
		return listCustomers;
	}

	public void setListCustomers(List<SelectItem> listCustomers) {
		this.listCustomers = listCustomers;
	}
}

