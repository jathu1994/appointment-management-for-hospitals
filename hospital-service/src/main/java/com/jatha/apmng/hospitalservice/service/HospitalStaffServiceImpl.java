package com.jatha.apmng.hospitalservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatha.apmng.hospitalservice.model.HospitalStaff;
import com.jatha.apmng.hospitalservice.repository.HospitalStaffRepository;

@Service
public class HospitalStaffServiceImpl implements HospitalStaffService {
	
	@Autowired
	HospitalStaffRepository hospitalStaffRepository;

	@Override
	public HospitalStaff save(HospitalStaff hospitalStaff) {
		return hospitalStaffRepository.save(hospitalStaff);
	}

	@Override
	public List<HospitalStaff> findAll() {
		return hospitalStaffRepository.findAll();
	}

	@Override
	public List<HospitalStaff> findByHosRegNo(String hosRegNo) {
		return hospitalStaffRepository.findByHosRegNo(hosRegNo);
	}

	@Override
	public Optional<HospitalStaff> findByUserName(String userName) {
		return hospitalStaffRepository.findByUserName(userName);
	}

	@Override
	public ResponseEntity<?> deleteHospitalStaff(String userName) {
		return hospitalStaffRepository.findByUserName(userName).map(hospitalStaff -> {
			hospitalStaffRepository.delete(hospitalStaff);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}

	@Override
	public List<HospitalStaff> findByUserNameIgnoreCaseContaining(String userName) {
		return hospitalStaffRepository.findByUserNameIgnoreCaseContaining(userName);
	}
	
	

}
