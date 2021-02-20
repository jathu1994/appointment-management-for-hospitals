package com.jatha.apmng.patientservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.patientservice.model.Patient;
import com.jatha.apmng.patientservice.service.PatientService;

@RestController
@RequestMapping(value = "/services")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping(value = "/patients")
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_hospital') or hasRole('ROLE_patient')")                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
	public Patient savePatient(@RequestBody Patient patient) {
		
		return patientService.save(patient);
		
	}
	
	
	@GetMapping(value = "/patients")
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_hospital')")
	public List<Patient> findAllPatient() {
		
		return patientService.findAll();
		
	}
	
	
	@GetMapping(value = "/patients/{id}")
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_hospital')")
	public Optional<Patient> findPatientById(@PathVariable(value="id") int id) {
		
		return patientService.findById(id);
		
	}
	
	@GetMapping(value = "/patients/find")
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_hospital') or hasRole('ROLE_patient')") 
	public Optional<Patient> findPatientNic(@RequestParam(name="nic",required=false) String nic) {
		if(nic!=null){
			return patientService.findByNICNumber(nic);
		}
		return null;
		
	}
	
	@GetMapping(value = "/patients/find/phone")
	@PreAuthorize("hasRole('ROLE_admin') or hasRole('ROLE_hospital')")
	public List<Patient> findPatientByPhone(@RequestParam(name="phone",required=false) String phone) {
		if(phone!=null){
			return patientService.findByPhoneNumber(phone);
		}
		return patientService.findAll();
		
	}
	
	
	@DeleteMapping("/patients/{nic}")
	@PreAuthorize("hasRole('ROLE_admin')")
    public ResponseEntity<?> deletePatient(@PathVariable("nic") String nic) {
        return patientService.deletePatient(nic);
    }

}
