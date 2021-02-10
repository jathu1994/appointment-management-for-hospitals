package com.jatha.apmng.hospitalservice.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.hospitalservice.model.DoctorSchedules;

public interface DoctorScheduleService {

	DoctorSchedules save(DoctorSchedules doctorSchedules);

	List<DoctorSchedules> findAll();

	List<DoctorSchedules> findByHosRegNoAndDocRegNo(String hosRegNo, String docRegNo);
	
	List<DoctorSchedules> findByHosRegNoAndDocRegNoAndDate(String hosRegNo, String docRegNo, Date date);
	
	Optional<DoctorSchedules> findByHosRegNoAndDocRegNoAndDateAndSession(String hosRegNo, String docRegNo, Date date, String session);

	ResponseEntity<?> deleteDoctorSchedules(String hosRegNo, String docRegNo, Date date, String session);

}