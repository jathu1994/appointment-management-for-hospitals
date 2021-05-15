package com.jatha.apmng.appointmentui.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.appointmentui.model.Doctor;
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.Patient;
import com.jatha.apmng.appointmentui.model.VisitingDoctors;
import com.jatha.apmng.appointmentui.service.AppointmentService;

@RestController
@RequestMapping("/aptservice")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@GetMapping("/hospitals")
	public ResponseEntity<?> loadHospitals(@RequestParam(value = "hosRegNo", required = false) String hosRegNo) {
		if (hosRegNo != null) {
			return appointmentService.loadHospitalByRegNo(hosRegNo);
		}

		ResponseEntity<?> re = appointmentService.loadAllHospitals();
		System.out.println(re.getStatusCodeValue());
		System.out.println(re.getStatusCode());
		System.out.println(re.getBody().toString());
		return re;
	}

	@GetMapping("/patients")
	public ResponseEntity<?> loadPatients(@RequestParam(value = "NICNumber", required = false) String NICNumber) {

		if (NICNumber != null) {
			return appointmentService.loadPatientByNic(NICNumber);
		}

		return appointmentService.loadAllPatients();
	}

	@GetMapping("/doctors")
	public ResponseEntity<?> loadDoctors(@RequestParam(value = "hosRegNo", required = false) String hosRegNo,
			@RequestParam(value = "docRegNo", required = false) String docRegNo) {

		if (hosRegNo != null) {
			return appointmentService.loadAllDoctorsByHospital(hosRegNo);

		}

		if (docRegNo != null) {
			return appointmentService.loadADoctorByRegNo(docRegNo);

		}
		return null;
	}

	@GetMapping("/sessionDates")
	public ResponseEntity<?> loadSessionDates(@RequestParam(value = "hosRegNo", required = false) String hosRegNo,
			@RequestParam(value = "docRegNo", required = false) String docRegNo) {

		return appointmentService.loadAllAvailableDates(hosRegNo, docRegNo);
	}

	@GetMapping("/sessions")
	public ResponseEntity<?> loadSessions(@RequestParam(value = "hosRegNo", required = false) String hosRegNo,
			@RequestParam(value = "docRegNo", required = false) String docRegNo,
			@RequestParam(value = "sDate", required = false) Date sDate,
			@RequestParam(value = "sSession", required = false) String sSession) {

		if (sSession != null) {
			return appointmentService.loadSession(hosRegNo, docRegNo, sDate, sSession);
		}
		return appointmentService.loadAllAvailableSessions(hosRegNo, docRegNo, sDate);
	}

	@GetMapping("/visits")
	public ResponseEntity<?> loadVisitDetails(@RequestParam(value = "hosRegNo", required = false) String hosRegNo,
			@RequestParam(value = "docRegNo", required = false) String docRegNo) {

		return appointmentService.loadVisitDetailsByHosAndDoc(hosRegNo, docRegNo);
	}
	
//	@GetMapping("/staffs")
//	public ResponseEntity<?> loadHospitalByUserName(
//			@RequestParam(value = "userName", required = true) String userName
//			) {
//
//		return appointmentService.loadHospitalByUserName(userName);
//	}
	
	@GetMapping("/staffs")
	public ResponseEntity<?> loadHospitalByUserName() {

		return appointmentService.loadHospitalByUserName();
	}

}
