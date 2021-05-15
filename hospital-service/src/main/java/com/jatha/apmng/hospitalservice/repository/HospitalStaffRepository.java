package com.jatha.apmng.hospitalservice.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jatha.apmng.hospitalservice.model.Hospital;
import com.jatha.apmng.hospitalservice.model.HospitalStaff;

@Repository
public interface HospitalStaffRepository extends JpaRepository<HospitalStaff, Integer> {
	
	Optional<HospitalStaff> findByUserNameAndHosRegNo(String userName,String hosRegNo);

	List<HospitalStaff> findByHosRegNo(String hosRegNo);

	Optional<HospitalStaff> findByUserName(String userName); 
	
	List<HospitalStaff> findByUserNameIgnoreCaseContaining(String userName);
}
