package com.jatha.apmng.hospitalservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jatha.apmng.hospitalservice.model.VisitingDoctors;

@Repository
public interface VisitingDoctorRepository extends JpaRepository<VisitingDoctors, Integer> {
	
	List<VisitingDoctors> findByHosRegNo(String hosRegNo);
	
	List<VisitingDoctors> findByDocRegNo(String docRegNo);
	
//	List<VisitingDoctors> findByHosRegNoAndDocRegNo(String hosRegNo,String docRegNo); 
	
	Optional<VisitingDoctors> findByHosRegNoAndDocRegNo(String hosRegNo,String docRegNo); 

}
