package com.jatha.apmng.appointmentui.service;

import org.springframework.http.ResponseEntity;

import com.jatha.apmng.appointmentui.model.DoctorSchedules;

public interface SessionService {

	DoctorSchedules saveSession(DoctorSchedules doctorSchedules);

	ResponseEntity<?> loadHospitalByUserName();

	ResponseEntity<?> loadSessionById(int sId);

}
