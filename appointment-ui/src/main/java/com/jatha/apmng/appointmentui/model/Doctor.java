package com.jatha.apmng.appointmentui.model;

import java.io.Serializable;

public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String regNo;
	String firstName;
	String lastName;
	String phoneNumber;
	String email;
	String address;
	private DoctorSpeciality doctorSpeciality;

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DoctorSpeciality getDoctorSpeciality() {
		return doctorSpeciality;
	}

	public void setDoctorSpeciality(DoctorSpeciality doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}
	
	
	
	
	
	
	
	

}
