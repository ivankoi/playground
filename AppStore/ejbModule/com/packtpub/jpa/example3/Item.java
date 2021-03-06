package com.packtpub.jpa.example3;

 

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="ITEM")
@SequenceGenerator(name = "itemSeq", sequenceName = "item_seq")
@XmlAccessorType(XmlAccessType.FIELD)
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSeq")
	@Column(name="ID")
	private int id;

	@Column(name="PRICE")
	private int price;

	@Column(name="PRODUCT")
	private String product;

	@Column(name="QUANTITY")
	private int quantity;

	@XmlTransient
	@ManyToOne  
	@JoinColumn(name="CUSTOMER_ID")  
	private Customer customerFK;

	public Item() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomerFK() {
		return this.customerFK;
	}

	public void setCustomerFK(Customer customerFK) {
		this.customerFK = customerFK;
	}
}
