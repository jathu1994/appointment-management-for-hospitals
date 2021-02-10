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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.doctorservice.model.DoctorSpeciality;
import com.jatha.apmng.doctorservice.service.DoctorService;
import com.jatha.apmng.doctorservice.service.DoctorSpecialityService;

@RestController
@RequestMapping(value = "/docservices")
public class DoctorSpecialityController {
	
	@Autowired
	DoctorService doctorService;
	
	@Autowired
	DoctorSpecialityService doctorSpecialityService;
	
	
	@PostMapping(value = "/doctortypes")
	public DoctorSpeciality saveDoctorType(@RequestBody DoctorSpeciality doctorSpeciality) {
		
		return doctorSpecialityService.save(doctorSpeciality);
		
	}
	
	@GetMapping(value = "/doctortypes")
	public List<DoctorSpeciality> findAll() {
		
		return doctorSpecialityService.findAll();
		
	}
	
	@DeleteMapping("/doctortypes/{typeId}")
    public ResponseEntity<?> deleteDoctorType(@PathVariable("typeId") int typeId) {
        return doctorSpecialityService.deleteDoctorType(typeId);
    }
	
	
	
	
	@RequestMapping(value = "/doctortypes/{id}",method = RequestMethod.GET)
	public Optional<DoctorSpeciality> findById(@PathVariable(value="id") int id) {
		
		return doctorSpecialityService.findById(id);
		
	}
}
