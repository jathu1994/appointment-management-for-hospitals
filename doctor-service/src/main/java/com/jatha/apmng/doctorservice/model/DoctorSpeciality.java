package com.jatha.apmng.doctorservice.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctorspeciality")
public class DoctorSpeciality implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	String specialityType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpecialityType() {
		return specialityType;
	}

	public void setSpecialityType(String specialityType) {
		this.specialityType = specialityType;
	}
	
	
	
	
	
	
	

}
