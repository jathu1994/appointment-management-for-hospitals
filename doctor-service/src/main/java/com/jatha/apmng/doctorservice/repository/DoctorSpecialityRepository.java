package com.jatha.apmng.doctorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jatha.apmng.doctorservice.model.DoctorSpeciality;

public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality,Integer> {

}
