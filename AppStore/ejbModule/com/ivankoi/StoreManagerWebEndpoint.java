
package com.ivankoi;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3-b02-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "StoreManagerWebEndpoint", targetNamespace = "http://www.ivankoi.com")
public interface StoreManagerWebEndpoint {


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
        String customerName);

    /**
     * 
     * @return
     *     returns java.util.List<com.ivankoi.Customer>
     */
    @WebMethod
    @WebResult(name = "customerList", targetNamespace = "")
    @RequestWrapper(localName = "findAllCustomers", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindAllCustomers")
    @ResponseWrapper(localName = "findAllCustomersResponse", targetNamespace = "http://www.ivankoi.com", className = "com.ivankoi.FindAllCustomersResponse")
    public List<Customer> findAllCustomers();

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
        int customerId);

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
        int customerId);

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
        String customerName);

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
        String product);

}