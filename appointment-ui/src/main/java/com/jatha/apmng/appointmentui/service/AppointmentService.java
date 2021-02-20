package com.jatha.apmng.appointmentui.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.jatha.apmng.appointmentui.model.Appointment;
import com.jatha.apmng.appointmentui.model.Doctor;
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.Patient;
import com.jatha.apmng.appointmentui.model.VisitingDoctors;

public interface AppointmentService {

	List<Hospital> loadAllHospitals();
	
	List<Hospital> loadHospitalByRegNo(String hosRegNo);
	
	List<Patient> loadAllPatients();
	
	List<Patient> loadPatientByNic(String nic);
	
	List<Doctor> loadAllDoctorsByHospital(String hosRegNo);
	
	List<Doctor> loadADoctorByRegNo(String docRegNo);
	
	List<DoctorSchedules> loadAllAvailableDates(String hosRegNo,String docRegNo);
	
	List<DoctorSchedules> loadAllAvailableSessions(String hosRegNo,String docRegNo,Date sDate);
	
	List<DoctorSchedules> loadSession(String hosRegNo, String docRegNo, Date sDate, String sSession);

	List<VisitingDoctors> loadVisitDetailsByHosAndDoc(String hosRegNo, String docRegNo);

	Appointment saveAppointment(Appointment appointment);

	
	
	
	

}