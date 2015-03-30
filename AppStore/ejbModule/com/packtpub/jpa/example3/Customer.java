package com.packtpub.jpa.example3;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.FetchType.EAGER;

@Entity  
@Table(name="CUSTOMER")  
@SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
	@Column(name="ID")  
	private int id;

	@Column(name="COUNTRY")
	private String country;

	@Column(name="NAME")
	private String name;

	//bi-directional many-to-one association to Item
	@OneToMany(mappedBy="customerFK", fetch = EAGER)  
	private List<Item> items;

    public Customer() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return this.items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
}
