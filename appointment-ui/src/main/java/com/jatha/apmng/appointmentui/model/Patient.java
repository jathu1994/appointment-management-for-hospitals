package com.jatha.apmng.appointmentui.model;

public class Patient {
	

	int id;
	String NICNumber;
	String firstName;
	String lastName;
	String phoneNumber;
	String adress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNICNumber() {
		return NICNumber;
	}
	public void setNICNumber(String nICNumber) {
		NICNumber = nICNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	

}
