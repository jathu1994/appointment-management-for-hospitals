package com.jatha.apmng.hospitalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.hospitalservice.model.HospitalStaff;

public interface HospitalStaffService {
	
	HospitalStaff save(HospitalStaff hospitalStaff);
	
	List<HospitalStaff> findAll();
	
	List<HospitalStaff> findByHosRegNo(String hosRegNo);
	
	Optional<HospitalStaff> findByUserName(String userName);
	
//	Optional<HospitalStaff> findByUserNameAndHosRegNo(String userName,String hosRegNo);
	
	ResponseEntity<?> deleteHospitalStaff(String userName);
	
	List<HospitalStaff> findByUserNameIgnoreCaseContaining(String userName);

}
