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

import com.jatha.apmng.hospitalservice.model.DoctorSchedules;
import com.jatha.apmng.hospitalservice.model.VisitingDoctors;
import com.jatha.apmng.hospitalservice.service.VisitingDoctorService;

@RestController
@RequestMapping(value = "/hosservices")
public class VisitingDoctorController {
	
	@Autowired
	VisitingDoctorService visitingDoctorService ;
	
	@PostMapping("/visitingdoctors")
    public VisitingDoctors saveVisitingDoctor(@RequestBody VisitingDoctors visitingDoctors) {
		
		return visitingDoctorService.save(visitingDoctors);
    }
	
	@GetMapping(value = "/visitingdoctors/{id}")
	public Optional<VisitingDoctors> findVisitingDoctorsById(@PathVariable(value="id") int id) {
		
		return visitingDoctorService.findById(id);
		
	}

	
	@GetMapping("/visitingdoctors")
	public List<VisitingDoctors> findAllVisitingDoctors(
			@RequestParam(value = "hosRegNo", required =false) String hosRegNo,
			@RequestParam(value = "docRegNo", required =false) String docRegNo
			) {
		
		if(hosRegNo!=null && docRegNo!=null) {
			return null;
		}
		if(hosRegNo!=null) {
			return visitingDoctorService.findByHosRegNo(hosRegNo);
		}
		if(docRegNo!=null) {
			return visitingDoctorService.findByDocRegNo(docRegNo);
		}
		return visitingDoctorService.findAll();
		
	}
	
	@GetMapping("/visitingdoctors/{hosRegNo}/{docRegNo}")
	public Optional<VisitingDoctors> findVisitingDoctorsByHospitalAndDoctor(@PathVariable("hosRegNo") String hosRegNo, @PathVariable("docRegNo") String docRegNo) {
		
		return visitingDoctorService.findByHosRegNoAndDocRegNo(hosRegNo,docRegNo);
	}
	
	@DeleteMapping("/visitingdoctors/{hosRegNo}/{docRegNo}")
    public ResponseEntity<?> deleteHospital(@PathVariable("hosRegNo") String hosRegNo, @PathVariable("docRegNo") String docRegNo) {
        return visitingDoctorService.deleteVisitingDoctors(hosRegNo, docRegNo); 
	}

}
