package com.jatha.apmng.appointmentui.model;

import java.io.Serializable;

public class AppointmentFullDetails implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Patient patient;
	public Hospital hospital;
	public Doctor doctor;
	public DoctorSchedules doctorSchedules;
	public Appointment appointment;
	public VisitingDoctors visitingDoctors;
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public DoctorSchedules getDoctorSchedules() {
		return doctorSchedules;
	}
	public void setDoctorSchedules(DoctorSchedules doctorSchedules) {
		this.doctorSchedules = doctorSchedules;
	}
	public Appointment getAppointment() {
		return appointment;
	}
	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}
	public VisitingDoctors getVisitingDoctors() {
		return visitingDoctors;
	}
	public void setVisitingDoctors(VisitingDoctors visitingDoctors) {
		this.visitingDoctors = visitingDoctors;
	}
	
	
	
	

}
