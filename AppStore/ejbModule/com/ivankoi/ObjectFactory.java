
package com.ivankoi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ivankoi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FindAllCustomersResponse_QNAME = new QName("http://www.ivankoi.com", "findAllCustomersResponse");
    private final static QName _FindCustomerById_QNAME = new QName("http://www.ivankoi.com", "findCustomerById");
    private final static QName _CreateCustomerResponse_QNAME = new QName("http://www.ivankoi.com", "createCustomerResponse");
    private final static QName _SaveOrderResponse_QNAME = new QName("http://www.ivankoi.com", "saveOrderResponse");
    private final static QName _FindCustomerByIdResponse_QNAME = new QName("http://www.ivankoi.com", "findCustomerByIdResponse");
    private final static QName _FindAllItemsResponse_QNAME = new QName("http://www.ivankoi.com", "findAllItemsResponse");
    private final static QName _FindAllCustomers_QNAME = new QName("http://www.ivankoi.com", "findAllCustomers");
    private final static QName _CreateCustomer_QNAME = new QName("http://www.ivankoi.com", "createCustomer");
    private final static QName _FindAllItems_QNAME = new QName("http://www.ivankoi.com", "findAllItems");
    private final static QName _FindCustomerByName_QNAME = new QName("http://www.ivankoi.com", "findCustomerByName");
    private final static QName _FindCustomerByNameResponse_QNAME = new QName("http://www.ivankoi.com", "findCustomerByNameResponse");
    private final static QName _SaveOrder_QNAME = new QName("http://www.ivankoi.com", "saveOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ivankoi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateCustomer }
     * 
     */
    public CreateCustomer createCreateCustomer() {
        return new CreateCustomer();
    }

    /**
     * Create an instance of {@link FindCustomerByNameResponse }
     * 
     */
    public FindCustomerByNameResponse createFindCustomerByNameResponse() {
        return new FindCustomerByNameResponse();
    }

    /**
     * Create an instance of {@link SaveOrderResponse }
     * 
     */
    public SaveOrderResponse createSaveOrderResponse() {
        return new SaveOrderResponse();
    }

    /**
     * Create an instance of {@link FindAllItemsResponse }
     * 
     */
    public FindAllItemsResponse createFindAllItemsResponse() {
        return new FindAllItemsResponse();
    }

    /**
     * Create an instance of {@link FindCustomerById }
     * 
     */
    public FindCustomerById createFindCustomerById() {
        return new FindCustomerById();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link CreateCustomerResponse }
     * 
     */
    public CreateCustomerResponse createCreateCustomerResponse() {
        return new CreateCustomerResponse();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link FindCustomerByIdResponse }
     * 
     */
    public FindCustomerByIdResponse createFindCustomerByIdResponse() {
        return new FindCustomerByIdResponse();
    }

    /**
     * Create an instance of {@link FindCustomerByName }
     * 
     */
    public FindCustomerByName createFindCustomerByName() {
        return new FindCustomerByName();
    }

    /**
     * Create an instance of {@link FindAllCustomers }
     * 
     */
    public FindAllCustomers createFindAllCustomers() {
        return new FindAllCustomers();
    }

    /**
     * Create an instance of {@link FindAllItems }
     * 
     */
    public FindAllItems createFindAllItems() {
        return new FindAllItems();
    }

    /**
     * Create an instance of {@link FindAllCustomersResponse }
     * 
     */
    public FindAllCustomersResponse createFindAllCustomersResponse() {
        return new FindAllCustomersResponse();
    }

    /**
     * Create an instance of {@link SaveOrder }
     * 
     */
    public SaveOrder createSaveOrder() {
        return new SaveOrder();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCustomersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findAllCustomersResponse")
    public JAXBElement<FindAllCustomersResponse> createFindAllCustomersResponse(FindAllCustomersResponse value) {
        return new JAXBElement<FindAllCustomersResponse>(_FindAllCustomersResponse_QNAME, FindAllCustomersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findCustomerById")
    public JAXBElement<FindCustomerById> createFindCustomerById(FindCustomerById value) {
        return new JAXBElement<FindCustomerById>(_FindCustomerById_QNAME, FindCustomerById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "createCustomerResponse")
    public JAXBElement<CreateCustomerResponse> createCreateCustomerResponse(CreateCustomerResponse value) {
        return new JAXBElement<CreateCustomerResponse>(_CreateCustomerResponse_QNAME, CreateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "saveOrderResponse")
    public JAXBElement<SaveOrderResponse> createSaveOrderResponse(SaveOrderResponse value) {
        return new JAXBElement<SaveOrderResponse>(_SaveOrderResponse_QNAME, SaveOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findCustomerByIdResponse")
    public JAXBElement<FindCustomerByIdResponse> createFindCustomerByIdResponse(FindCustomerByIdResponse value) {
        return new JAXBElement<FindCustomerByIdResponse>(_FindCustomerByIdResponse_QNAME, FindCustomerByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findAllItemsResponse")
    public JAXBElement<FindAllItemsResponse> createFindAllItemsResponse(FindAllItemsResponse value) {
        return new JAXBElement<FindAllItemsResponse>(_FindAllItemsResponse_QNAME, FindAllItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllCustomers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findAllCustomers")
    public JAXBElement<FindAllCustomers> createFindAllCustomers(FindAllCustomers value) {
        return new JAXBElement<FindAllCustomers>(_FindAllCustomers_QNAME, FindAllCustomers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "createCustomer")
    public JAXBElement<CreateCustomer> createCreateCustomer(CreateCustomer value) {
        return new JAXBElement<CreateCustomer>(_CreateCustomer_QNAME, CreateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findAllItems")
    public JAXBElement<FindAllItems> createFindAllItems(FindAllItems value) {
        return new JAXBElement<FindAllItems>(_FindAllItems_QNAME, FindAllItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findCustomerByName")
    public JAXBElement<FindCustomerByName> createFindCustomerByName(FindCustomerByName value) {
        return new JAXBElement<FindCustomerByName>(_FindCustomerByName_QNAME, FindCustomerByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindCustomerByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "findCustomerByNameResponse")
    public JAXBElement<FindCustomerByNameResponse> createFindCustomerByNameResponse(FindCustomerByNameResponse value) {
        return new JAXBElement<FindCustomerByNameResponse>(_FindCustomerByNameResponse_QNAME, FindCustomerByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ivankoi.com", name = "saveOrder")
    public JAXBElement<SaveOrder> createSaveOrder(SaveOrder value) {
        return new JAXBElement<SaveOrder>(_SaveOrder_QNAME, SaveOrder.class, null, value);
    }

}
