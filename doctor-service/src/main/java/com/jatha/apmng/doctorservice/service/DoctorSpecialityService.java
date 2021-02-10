package com.jatha.apmng.doctorservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.doctorservice.model.DoctorSpeciality;

public interface DoctorSpecialityService {
	
	DoctorSpeciality save(DoctorSpeciality doctorSpeciality);
	List<DoctorSpeciality> findAll();
	Optional<DoctorSpeciality> findById(int id);
	ResponseEntity<?> deleteDoctorType(int typeId);

}
