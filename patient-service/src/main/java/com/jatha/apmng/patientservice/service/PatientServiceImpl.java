package com.jatha.apmng.patientservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatha.apmng.patientservice.exceptions.PatientNotFoundException;
import com.jatha.apmng.patientservice.model.Patient;
import com.jatha.apmng.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {
	
	@Autowired 
	PatientRepository patientRepository;

	
	//create or update patients. only hospitals and respective patients have permissions
	//admin 
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
	public List<Patient> findByPhoneNumber(String phoneNumber)  {
		
		List<Patient> list = patientRepository.findByPhoneNumber(phoneNumber);
		if(list.size()==0) {
		throw new PatientNotFoundException("no patient records found for provided phone-number\n recheck the phone number \n or try with other search options\n");
		}
		return list;
	}
	
	@Override
	public ResponseEntity<?> deletePatient(String nic) {
		return patientRepository.findByNICNumber(nic).map(patient -> {
			patientRepository.delete(patient);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}
	
	
}
