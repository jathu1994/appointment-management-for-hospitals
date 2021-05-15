package com.jatha.apmng.hospitalservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.hospitalservice.model.HospitalStaff;
import com.jatha.apmng.hospitalservice.service.HospitalStaffService;

@RestController
@RequestMapping(value = "/hosservices")
public class HospitalStaffController {
	
	@Autowired
	HospitalStaffService hospitalStaffService;
	
	@PostMapping("/staffs")
    public HospitalStaff saveHospitalStaff(@RequestBody HospitalStaff hospitalStaff) {
		
		return hospitalStaffService.save(hospitalStaff);
    }
	
	
	@GetMapping("/staffs")
	public List<HospitalStaff> findAllHospitalStaffs(
			@RequestParam(value = "userName", required =false) String userName,
			@RequestParam(value = "hosRegNo", required =false) String hosRegNo) {
		
		if(hosRegNo!=null && userName!=null) {
			return null;
		}
		
		if(userName!=null) {
			return hospitalStaffService.findByUserNameIgnoreCaseContaining(userName);	
		}
		if(hosRegNo!=null) {
			return hospitalStaffService.findByHosRegNo(hosRegNo);
		}
		return hospitalStaffService.findAll();
		
	}
	
	@GetMapping("/staffs/{userName}")
	public Optional<HospitalStaff> findByUserName(@PathVariable("userName") String userName) {
		return hospitalStaffService.findByUserName(userName);
	}
	
	@DeleteMapping("/staffs/{userName}")
    public ResponseEntity<?> deleteHospital(@PathVariable("userName") String userName) {
        return hospitalStaffService.deleteHospitalStaff(userName);
    }

}
