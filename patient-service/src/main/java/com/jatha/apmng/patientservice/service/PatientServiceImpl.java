package com.jatha.apmng.patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jatha.apmng.patientservice.model.Patient;
import com.jatha.apmng.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired 
	PatientRepository patientRepository;

	@Override
	public Patient save(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> findById(int id) {
		return patientRepository.findById(id);
	}

	@Override
	public Optional<Patient> findByNICNumber(String nic) {
		return patientRepository.findByNICNumber(nic);
	}

	@Override
	public List<Patient> findByPhoneNumber(String phoneNumber) {
		return patientRepository.findByPhoneNumber(phoneNumber);
	}
	
	
}
