package com.jatha.apmng.hospitalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatha.apmng.hospitalservice.model.VisitingDoctors;
import com.jatha.apmng.hospitalservice.repository.VisitingDoctorRepository;

@Service
public class VisitingDoctorServiceImpl implements VisitingDoctorService {
	
	@Autowired
	VisitingDoctorRepository visitingDoctorRepository;

	@Override
	public VisitingDoctors save(VisitingDoctors visitingDoctors) {
		return visitingDoctorRepository.save(visitingDoctors);
	}

	@Override
	public List<VisitingDoctors> findAll() {
		return visitingDoctorRepository.findAll();
	}

	

	@Override
	public List<VisitingDoctors> findByHosRegNo(String hosRegNo) {
		return visitingDoctorRepository.findByHosRegNo(hosRegNo);
	}
	
	

	@Override
	public List<VisitingDoctors> findByDocRegNo(String docRegNo) {
		return visitingDoctorRepository.findByDocRegNo(docRegNo);
	}

	@Override
	public Optional<VisitingDoctors> findByHosRegNoAndDocRegNo(String hosRegNo, String docRegNo) {
		return visitingDoctorRepository.findByHosRegNoAndDocRegNo(hosRegNo, docRegNo);
	}

	@Override
	public ResponseEntity<?> deleteVisitingDoctors(String hosRegNo, String docRegNo) {
		
		return visitingDoctorRepository.findByHosRegNoAndDocRegNo(hosRegNo, docRegNo).map(visitingDoctor -> {
			visitingDoctorRepository.delete(visitingDoctor);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}
	
	

}
