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

import com.jatha.apmng.hospitalservice.model.Hospital;
import com.jatha.apmng.hospitalservice.service.HospitalService;

@RestController
@RequestMapping(value = "/hosservices")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/hospitals")
    public Hospital saveHospital(@RequestBody Hospital hospital) {
		
		return hospitalService.save(hospital);
    }
	
	
	@GetMapping("/hospitals")
	public List<Hospital> findAllHospital(@RequestParam(value = "hosName", required =false) String hosName) {
		
		if(hosName!=null) {
			return hospitalService.findByHosNameIgnoreCaseContaining(hosName);	
		}
		return hospitalService.findAll();
		
	}
	
	@GetMapping("/hospitals/{regNo}")
	public Optional<Hospital> findByRegNo(@PathVariable("regNo") String regNo) {
		return hospitalService.findByHosRegNo(regNo);
	}
	
	@DeleteMapping("/hospitals/{regNo}")
    public ResponseEntity<?> deleteHospital(@PathVariable("regNo") String regNo) {
        return hospitalService.deleteHospital(regNo);
    }

}