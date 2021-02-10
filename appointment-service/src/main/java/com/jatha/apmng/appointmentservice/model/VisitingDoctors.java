package com.jatha.apmng.appointmentservice.model;

public class VisitingDoctors {
	
	int id;
	String docRegNo;
	String hosRegNo;
	double docChanellingFee;
	double hosChanellingFee;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDocRegNo() {
		return docRegNo;
	}
	public void setDocRegNo(String docRegNo) {
		this.docRegNo = docRegNo;
	}
	public String getHosRegNo() {
		return hosRegNo;
	}
	public void setHosRegNo(String hosRegNo) {
		this.hosRegNo = hosRegNo;
	}
	public double getDocChanellingFee() {
		return docChanellingFee;
	}
	public void setDocChanellingFee(double docChanellingFee) {
		this.docChanellingFee = docChanellingFee;
	}
	public double getHosChanellingFee() {
		return hosChanellingFee;
	}
	public void setHosChanellingFee(double hosChanellingFee) {
		this.hosChanellingFee = hosChanellingFee;
	}
//	@Override
//	public String toString() {
//		return "VisitingDoctors [id=" + id + ", docRegNo=" + docRegNo + ", hosRegNo=" + hosRegNo + ", docChanellingFee="
//				+ docChanellingFee + ", hosChanellingFee=" + hosChanellingFee + "]";
//	}
//	
	

}
