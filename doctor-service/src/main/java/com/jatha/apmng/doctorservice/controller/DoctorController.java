package com.jatha.apmng.doctorservice.controller;

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

import com.jatha.apmng.doctorservice.model.Doctor;
import com.jatha.apmng.doctorservice.service.DoctorService;
import com.jatha.apmng.doctorservice.service.DoctorSpecialityService;

@RestController
@RequestMapping(value = "/docservices")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	DoctorSpecialityService doctorSpecialityService;
	
	@PostMapping("/doctors")
    public Doctor saveDoctor(@RequestParam("typeId") int typeId,
    		@RequestBody Doctor doctor) {
		
		return doctorService.save(doctor,typeId);
    }
	
	
	@GetMapping("/doctors")
	public List<Doctor> findAllDoctors() {
		
		return doctorService.findAll();
		
	}
	
	@GetMapping("/doctors/{regNo}")
	public Optional<Doctor> findByRegNo(@PathVariable("regNo") String regNo) {
		return doctorService.findByRegNo(regNo);
	}
	
	@DeleteMapping("/doctors/{regNo}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("regNo") String regNo) {
        return doctorService.deleteDoctor(regNo);
    }

}
