package com.jatha.apmng.hospitalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.hospitalservice.model.Hospital;


public interface HospitalService {
	
	Hospital save(Hospital hospital);
	List<Hospital> findAll();
	Optional<Hospital> findByHosRegNo(String hosRegNo);
	
	ResponseEntity<?> deleteHospital(String hosRegNo);
	
	List<Hospital> findByHosNameIgnoreCaseContaining(String hosName);

}