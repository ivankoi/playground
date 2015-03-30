package com.packpub.ws;

import java.util.List;

import javax.ejb.Remote;

import com.ivankoi.Customer;
import com.ivankoi.Item;

@Remote
public interface StoreManagerTopDown {


    /**
     * 
     * @param customerName
     * @param customerCountry
     */
    public void createCustomer(
        String customerCountry,
        String customerName);

    /**
     * 
     * @return
     *     returns java.util.List<com.ivankoi.Customer>
     */
    public List<Customer> findAllCustomers();

    /**
     * 
     * @param customerId
     * @return
     *     returns java.util.List<com.ivankoi.Item>
     */
    public List<Item> findAllItems(
        int customerId);

    /**
     * 
     * @param customerId
     * @return
     *     returns com.ivankoi.Customer
     */
    public Customer findCustomerById(
        int customerId);

    /**
     * 
     * @param customerName
     * @return
     *     returns com.ivankoi.Customer
     */
    public Customer findCustomerByName(
        String customerName);

    /**
     * 
     * @param product
     * @param price
     * @param customerId
     * @param quantity
     */
    public void saveOrder(
        int customerId,
        int price,
        int quantity,
        String product);
    
}
