package com.jatha.apmng.appointmentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.appointmentservice.model.Appointment;
import com.jatha.apmng.appointmentservice.model.AppointmentFullDetails;
import com.jatha.apmng.appointmentservice.model.Doctor;
import com.jatha.apmng.appointmentservice.model.DoctorSchedules;
import com.jatha.apmng.appointmentservice.model.Hospital;
import com.jatha.apmng.appointmentservice.model.Patient;

public interface AppointmentService {
	
	Appointment save(Appointment appointment);
	
	List<Appointment> findAll();
	
	Optional<Appointment> findById(int id);
	
	ResponseEntity<?> deleteAppointment(int id);
	List<Hospital> findAllHospitals();

	List<Hospital> findByHospitalName(String hosName);
	
	List<Hospital> findByHospitalRegNo(String hosRegNo);

	List<Doctor> findDoctorsByHospital(String hosRegNo);
	
	List<Doctor> findDoctorByDocRegNo(String docRegNo);

	List<DoctorSchedules> findAvailabilityByHosAndDoc(String hosRegNo, String docRegNo);

	List<DoctorSchedules> findAvailabilityByHosAndDocAndDate(String hosRegNo, String docRegNo, String sDate);
	
	List<DoctorSchedules> findAvailabilityByHosAndDocAndDate(String hosRegNo, String docRegNo, String sDate,
			String session);
	
	List<Patient> findAllPatient();

	List<Patient> findPatientById(String id);

	List<Patient> findPatientByNic(String nic);

	List<Patient> findPatientByPhone(String phone);

	AppointmentFullDetails findAppointmentDetails(String nic, String docRegNo, String hosRegNo, String scheduleId,
			String appointmentId, String visitId);

	

//	Optional<DoctorSchedules> findAvailabilityByHosAndDocAndDate(String hosRegNo, String docRegNo, String sDate,
//			String session);

}