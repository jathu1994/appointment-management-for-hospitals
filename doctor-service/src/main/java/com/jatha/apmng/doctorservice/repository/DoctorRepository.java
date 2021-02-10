package com.jatha.apmng.doctorservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jatha.apmng.doctorservice.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,String> {
	
	Optional<Doctor> findByRegNo(String regNo);

}
