package com.jatha.apmng.hospitalservice.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatha.apmng.hospitalservice.model.DoctorSchedules;

public interface DoctorScheduleRepository extends JpaRepository<DoctorSchedules, Integer> {

	List<DoctorSchedules> findByHosRegNoAndDocRegNo(String hosRegNo, String docRegNo);

	List<DoctorSchedules> findByHosRegNoAndDocRegNoAndDate(String hosRegNo, String docRegNo, Date date);

	Optional<DoctorSchedules> findByHosRegNoAndDocRegNoAndDateAndSession(String hosRegNo, String docRegNo, Date date,
			String session);

}
