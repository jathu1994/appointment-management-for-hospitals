package com.jatha.apmng.hospitalservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "visitingDoctors")
public class VisitingDoctors {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
