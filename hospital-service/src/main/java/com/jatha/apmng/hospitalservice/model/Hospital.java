package com.jatha.apmng.hospitalservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hospitals")
public class Hospital implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(unique = true)
	String hosRegNo;
	String hosName;
	String hosType;
	String hosAdress;
	String hosPhoneNumber;
	String hosEmail;
	
	public String getHosRegNo() {
		return hosRegNo;
	}
	public void setHosRegNo(String hosRegNo) {
		this.hosRegNo = hosRegNo;
	}
	public String getHosName() {
		return hosName;
	}
	public void setHosName(String hosName) {
		this.hosName = hosName;
	}
	public String getHosType() {
		return hosType;
	}
	public void setHosType(String hosType) {
		this.hosType = hosType;
	}
	public String getHosAdress() {
		return hosAdress;
	}
	public void setHosAdress(String hosAdress) {
		this.hosAdress = hosAdress;
	}
	public String getHosPhoneNumber() {
		return hosPhoneNumber;
	}
	public void setHosPhoneNumber(String hosPhoneNumber) {
		this.hosPhoneNumber = hosPhoneNumber;
	}
	public String getHosEmail() {
		return hosEmail;
	}
	public void setHosEmail(String hosEmail) {
		this.hosEmail = hosEmail;
	}
	
	

}
