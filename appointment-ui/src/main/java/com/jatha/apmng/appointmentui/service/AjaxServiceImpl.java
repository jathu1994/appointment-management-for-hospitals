package com.jatha.apmng.appointmentui.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.jatha.apmng.appointmentui.model.Doctor;
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.Patient;
import com.jatha.apmng.appointmentui.model.VisitingDoctors;


@Service
public class AjaxServiceImpl implements AjaxService {
	
	@Autowired 
	RestTemplate restTemplate;
	
	
	@Override
	public List<Hospital> loadAllHospitals() {
		List<Hospital> list = null;
		try {
		ResponseEntity<Hospital[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice/hospitals",Hospital[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
		
		
	}
	
	


	@Override
	public List<Hospital> loadHospitalByRegNo(String hosRegNo) {
		List<Hospital> list = null;
		try {
		ResponseEntity<Hospital[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice/hospitals?hosRegNo="+hosRegNo,Hospital[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
	}




	@Override
	public List<Patient> loadAllPatients() {
		List<Patient> list = null;
		try {
		ResponseEntity<Patient[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice/patients",Patient[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
	}
	
	


	@Override
	public List<Patient> loadPatientByNic(String nic) {
		
		List<Patient> list = null;
		try {
		ResponseEntity<Patient[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice/patients?nic="+nic,Patient[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
	}


	@Override
	public List<Doctor> loadAllDoctorsByHospital(String hosRegNo) {
		List<Doctor> list = null;
		try {
		ResponseEntity<Doctor[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice/hospitals/doctors?hosRegNo="+hosRegNo,Doctor[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
	}
	
	


	@Override
	public List<Doctor> loadADoctorByRegNo(String docRegNo) {
		List<Doctor> list = null;
		try {
		ResponseEntity<Doctor[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice/doctors?docRegNo="+docRegNo,Doctor[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
	}




	@Override
	public List<DoctorSchedules> loadAllAvailableDates(String hosRegNo,String docRegNo) {
		List<DoctorSchedules> list = null;
		try {
		ResponseEntity<DoctorSchedules[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice//hospitals/doctors/availability?hosRegNo="+hosRegNo+"&docRegNo="+docRegNo,DoctorSchedules[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
		
	}


	@Override
	public List<DoctorSchedules> loadAllAvailableSessions(String hosRegNo,String docRegNo,Date sDate){
		List<DoctorSchedules> list = null;
		try {
		ResponseEntity<DoctorSchedules[]> responseEntity = restTemplate.getForEntity("http://localhost:9194/aptservice//hospitals/doctors/availability?hosRegNo="+hosRegNo+"&docRegNo="+docRegNo+"&sDate="+sDate,DoctorSchedules[].class);
		
		list = Arrays.asList(responseEntity.getBody());
		
		}catch(HttpStatusCodeException e){
			
		}
		return list;
	}




}
