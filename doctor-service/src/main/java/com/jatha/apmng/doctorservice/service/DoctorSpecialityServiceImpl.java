package com.jatha.apmng.doctorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatha.apmng.doctorservice.model.DoctorSpeciality;
import com.jatha.apmng.doctorservice.repository.DoctorSpecialityRepository;

@Service
public class DoctorSpecialityServiceImpl implements DoctorSpecialityService {
	
	@Autowired
	DoctorSpecialityRepository doctorSpecialityRepository; 

	@Override
	public DoctorSpeciality save(DoctorSpeciality doctorSpeciality) {
		return doctorSpecialityRepository.save(doctorSpeciality);
	}

	@Override
	public List<DoctorSpeciality> findAll() {
		return doctorSpecialityRepository.findAll();
	}

	@Override
	public Optional<DoctorSpeciality> findById(int id) {
		return doctorSpecialityRepository.findById(id);
	}

	@Override
	public ResponseEntity<?> deleteDoctorType(int typeId) {
		
		return doctorSpecialityRepository.findById(typeId).map(doctorSpeciality -> {
			doctorSpecialityRepository.delete(doctorSpeciality);
            return ResponseEntity.ok().build();
        }).orElse(null);
		
	}

}