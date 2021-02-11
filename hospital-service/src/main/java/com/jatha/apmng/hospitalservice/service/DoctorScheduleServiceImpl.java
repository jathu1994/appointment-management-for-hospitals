package com.jatha.apmng.hospitalservice.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jatha.apmng.hospitalservice.model.DoctorSchedules;
import com.jatha.apmng.hospitalservice.repository.DoctorScheduleRepository;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {
	
	@Autowired 
	DoctorScheduleRepository doctorScheduleRepository;

	@Override
	public DoctorSchedules save(DoctorSchedules doctorSchedules) {
		return doctorScheduleRepository.save(doctorSchedules);
	}

	@Override
	public List<DoctorSchedules> findAll() {
		return doctorScheduleRepository.findAll();
	}
	
	@Override
	public Optional<DoctorSchedules> findById(int id) {
		return doctorScheduleRepository.findById(id);
	}

	@Override
	public List<DoctorSchedules> findByHosRegNoAndDocRegNo(String hosRegNo, String docRegNo) {
		return doctorScheduleRepository.findByHosRegNoAndDocRegNo(hosRegNo, docRegNo);
	}

	@Override
	public List<DoctorSchedules> findByHosRegNoAndDocRegNoAndDate(String hosRegNo, String docRegNo, Date date) {
		return doctorScheduleRepository.findByHosRegNoAndDocRegNoAndDate(hosRegNo, docRegNo, date);
	}

	@Override
	public Optional<DoctorSchedules> findByHosRegNoAndDocRegNoAndDateAndSession(String hosRegNo, String docRegNo,
			Date date, String session) {
		return doctorScheduleRepository.findByHosRegNoAndDocRegNoAndDateAndSession(hosRegNo, docRegNo, date, session);
	}

	@Override
	public ResponseEntity<?> deleteDoctorSchedules(int id) {
		return doctorScheduleRepository.findById(id).map(doctorSchedule -> {
			doctorScheduleRepository.delete(doctorSchedule);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}

	@Override
	public ResponseEntity<?> deleteDoctorSchedulesByResource(String hosRegNo, String docRegNo, Date date,
			String session) {
		return doctorScheduleRepository.findByHosRegNoAndDocRegNoAndDateAndSession(hosRegNo, docRegNo, date, session).map(doctorSchedule -> {
			doctorScheduleRepository.delete(doctorSchedule);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}
	
	
	
	

}
