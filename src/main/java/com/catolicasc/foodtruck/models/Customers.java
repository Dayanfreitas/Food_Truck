package com.catolicasc.foodtruck.models;

public class Customers {
	private User   customers;
	String address;
	//private Address address;

	public Customers() {
		customers = new User();
		//address   = new Address();
	}
	
	public User getCustomers() {
		return customers;
	}

	public void setCustomers(User customers) {
		this.customers = customers;
	}

/*	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] args) {
		Customers n = new Customers();
		n.getCustomers().setName("Sla");
		System.out.print(n.getCustomers().getName());
	}
}
