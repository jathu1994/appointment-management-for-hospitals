package com.jatha.apmng.hospitalservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jatha.apmng.hospitalservice.model.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, String> {
	
	Optional<Hospital> findByHosRegNo(String hosRegNo);
	
	List<Hospital> findByHosNameIgnoreCaseContaining(String hosName);
	
	

}
