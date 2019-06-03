package com.catolicasc.foodtruck.models;

public class Address {
	private String street;
	private String number;
	private String district;
	private static final String city = "Joinville";
	
	
	public Address(){
	}
	
	public Address(String street,String number,String districit) {
		this.street = street;
		this.number = number;
		this.district = districit;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public static String getCity() {
		return city;
	}
	
	@Override
	public String toString() {
		return String.format("Rua %s %s %s %s",getStreet(),getNumber(),getDistrict(),getCity());
	}
	
	public static void main(String[] args) {
		Address  a = new Address();
		System.out.print(a.toString());
	}
}
