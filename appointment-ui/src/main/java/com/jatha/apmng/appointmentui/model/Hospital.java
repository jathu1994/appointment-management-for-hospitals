package com.jatha.apmng.appointmentui.model;

import java.io.Serializable;

public class Hospital implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String hosRegNo;
	String hosName;
	String hosType;
	String hosAdress;
	String hosPhoneNumber;
	String hosEmail;
	public Hospital() {
		super();
	}
	public Hospital(String hosRegNo, String hosName, String hosType, String hosAdress, String hosPhoneNumber,
			String hosEmail) {
		super();
		this.hosRegNo = hosRegNo;
		this.hosName = hosName;
		this.hosType = hosType;
		this.hosAdress = hosAdress;
		this.hosPhoneNumber = hosPhoneNumber;
		this.hosEmail = hosEmail;
	}
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
//	@Override
//	public String toString() {
//		return "Hospital [hosRegNo=" + hosRegNo + ", hosName=" + hosName + ", hosType=" + hosType + ", hosAdress="
//				+ hosAdress + ", hosPhoneNumber=" + hosPhoneNumber + ", hosEmail=" + hosEmail + "]";
//	}
	
	
	
	

}
