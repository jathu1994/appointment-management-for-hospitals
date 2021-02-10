package com.jatha.apmng.hospitalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatha.apmng.hospitalservice.model.Hospital;
import com.jatha.apmng.hospitalservice.repository.HospitalRepository;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepository hospitalRepopsitory;

	@Override
	public Hospital save(Hospital hospital) {
		return hospitalRepopsitory.save(hospital);
	}

	@Override
	public List<Hospital> findAll() {
		return hospitalRepopsitory.findAll();
	}

	@Override
	public Optional<Hospital> findByHosRegNo(String hosRegNo) {
		return hospitalRepopsitory.findByHosRegNo(hosRegNo);	}

	@Override
	public ResponseEntity<?> deleteHospital(String hosRegNo) {
		return hospitalRepopsitory.findByHosRegNo(hosRegNo).map(hospital -> {
			hospitalRepopsitory.delete(hospital);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}

	@Override
	public List<Hospital> findByHosNameIgnoreCaseContaining(String hosName) {
		return hospitalRepopsitory.findByHosNameIgnoreCaseContaining(hosName);
	}

}
