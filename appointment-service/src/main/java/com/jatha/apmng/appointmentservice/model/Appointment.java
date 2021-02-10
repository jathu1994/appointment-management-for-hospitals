package com.jatha.apmng.appointmentservice.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "appointment")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String hosRegNo;
	String docRegNo;
	String patientId;//patient Id nicw
	Date sessionDate;
	String session;
	String appointmentNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHosRegNo() {
		return hosRegNo;
	}
	public void setHosRegNo(String hosRegNo) {
		this.hosRegNo = hosRegNo;
	}
	public String getDocRegNo() {
		return docRegNo;
	}
	public void setDocRegNo(String docRegNo) {
		this.docRegNo = docRegNo;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public Date getSessionDate() {
		return sessionDate;
	}
	public void setSessionDate(Date sessionDate) {
		this.sessionDate = sessionDate;
	}
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	public String getAppointmentNumber() {
		return appointmentNumber;
	}
	public void setAppointmentNumber(String appointmentNumber) {
		this.appointmentNumber = appointmentNumber;
	}
	
	
}
