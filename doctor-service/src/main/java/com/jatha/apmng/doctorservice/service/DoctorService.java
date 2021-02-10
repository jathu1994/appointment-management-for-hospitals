package com.jatha.apmng.doctorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.doctorservice.model.Doctor;

public interface DoctorService {
	
	Doctor save(Doctor doctor,int typeId);
	List<Doctor> findAll();
	Optional<Doctor> findByRegNo(String regNo);
	
	ResponseEntity<?> deleteDoctor(String regNo);

}
