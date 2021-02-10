package com.jatha.apmng.patientservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jatha.apmng.patientservice.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	public Optional<Patient> findByNICNumber(String nic);
	
	public List<Patient> findByPhoneNumber(String phoneNumber);

}
