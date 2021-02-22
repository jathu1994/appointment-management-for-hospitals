package com.jatha.apmng.appointmentui.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.appointmentui.model.Appointment;
import com.jatha.apmng.appointmentui.model.Doctor;
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.Patient;
import com.jatha.apmng.appointmentui.model.VisitingDoctors;

public interface AppointmentService {

	ResponseEntity<?> loadAllHospitals();
	
	ResponseEntity<?> loadHospitalByRegNo(String hosRegNo);
	
	ResponseEntity<?> loadAllPatients();
	
	ResponseEntity<?> loadPatientByNic(String nic);
	
	ResponseEntity<?> loadAllDoctorsByHospital(String hosRegNo);
	
	ResponseEntity<?> loadADoctorByRegNo(String docRegNo);
	
	ResponseEntity<?> loadAllAvailableDates(String hosRegNo,String docRegNo);
	
	ResponseEntity<?> loadAllAvailableSessions(String hosRegNo,String docRegNo,Date sDate);
	
	ResponseEntity<?> loadSession(String hosRegNo, String docRegNo, Date sDate, String sSession);

	ResponseEntity<?> loadVisitDetailsByHosAndDoc(String hosRegNo, String docRegNo);

	Appointment saveAppointment(Appointment appointment);

	
	
	
	

}
