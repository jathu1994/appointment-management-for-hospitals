package com.jatha.apmng.hospitalservice.controller;

import java.sql.Date;
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
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.hospitalservice.model.DoctorSchedules;
import com.jatha.apmng.hospitalservice.service.DoctorScheduleService;

@RestController
@RequestMapping(value = "/hosservices")
public class DoctorScheduleController {
	
	@Autowired
	DoctorScheduleService doctorScheduleService;
	
	@PostMapping("/doctorSchedules")
    public DoctorSchedules saveVisitingDoctor(@RequestBody DoctorSchedules doctorSchedules) {
		
		return doctorScheduleService.save(doctorSchedules);
    }
	
	@GetMapping("/doctorSchedules")
	public List<DoctorSchedules> findAllDoctorSchedules() {
		
		return doctorScheduleService.findAll();
	}
	
	@GetMapping(value = "/doctorSchedules/{id}")
	public Optional<DoctorSchedules> findDoctorSchedulesById(@PathVariable(value="id") int id) {
		
		return doctorScheduleService.findById(id);
		
	}
	
	@GetMapping("/doctorSchedules/{hosRegNo}/{docRegNo}")
	public List<DoctorSchedules> findByHosRegNoAndDocRegNo(
			@PathVariable("hosRegNo") String hosRegNo, 
			@PathVariable("docRegNo") String docRegNo){
		return doctorScheduleService.findByHosRegNoAndDocRegNo(hosRegNo, docRegNo);
		
	}
	
	@GetMapping("/doctorSchedules/{hosRegNo}/{docRegNo}/{date}")
	public List<DoctorSchedules> findByHosRegNoAndDocRegNoAndDate(
			@PathVariable("hosRegNo") String hosRegNo, 
			@PathVariable("docRegNo") String docRegNo, 
			@PathVariable("date") Date date
			){
		return doctorScheduleService.findByHosRegNoAndDocRegNoAndDate(hosRegNo, docRegNo, date);
	}
	
	
	@GetMapping("/doctorSchedules/{hosRegNo}/{docRegNo}/{date}/{session}")
	public Optional<DoctorSchedules> findByHosRegNoAndDocRegNoAndDateAndSession(
			@PathVariable("hosRegNo") String hosRegNo, 
			@PathVariable("docRegNo") String docRegNo, 
			@PathVariable("date") Date date,
			@PathVariable("session") String session
			){
		return doctorScheduleService.findByHosRegNoAndDocRegNoAndDateAndSession(hosRegNo, docRegNo, date, session);
	}
	
	@DeleteMapping("/doctorSchedules/{hosRegNo}/{docRegNo}/{date}/{session}")
    public ResponseEntity<?> deleteHospital(
    		@PathVariable("hosRegNo") String hosRegNo, 
			@PathVariable("docRegNo") String docRegNo, 
			@PathVariable("date") Date date,
			@PathVariable("session") String session
    		){
        return doctorScheduleService.deleteDoctorSchedules(hosRegNo, docRegNo, date, session);
    }

}
