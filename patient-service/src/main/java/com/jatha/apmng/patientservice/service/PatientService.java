package com.jatha.apmng.patientservice.service;

import java.util.List;
import java.util.Optional;

import com.jatha.apmng.patientservice.model.Patient;

public interface PatientService {
	
	Patient save(Patient patient);
	List<Patient> findAll();
	Optional<Patient> findById(int id);
	Optional<Patient> findByNICNumber(String nic);
	List<Patient> findByPhoneNumber(String phoneNumber);

}
