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
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Optional<Patient> findById(int id) {
		// TODO Auto-generated method stub
		return patientRepository.findById(id);
	}

	@Override
	public Optional<Patient> findByNICNumber(String nic) {
		// TODO Auto-generated method stub
		return patientRepository.findByNICNumber(nic);
	}
}
