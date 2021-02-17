package com.jatha.apmng.appointmentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.appointmentservice.model.Appointment;
import com.jatha.apmng.appointmentservice.model.AppointmentFullDetails;
import com.jatha.apmng.appointmentservice.model.Doctor;
import com.jatha.apmng.appointmentservice.model.DoctorSchedules;
import com.jatha.apmng.appointmentservice.model.Hospital;
import com.jatha.apmng.appointmentservice.model.Patient;
import com.jatha.apmng.appointmentservice.service.AppointmentService;

@RestController
@RequestMapping("/aptservice")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/appointments")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {

		return appointmentService.save(appointment);
	}

	@GetMapping("/appointments")
	public List<Appointment> findAllAppointments() {

		return appointmentService.findAll();

	}

	@GetMapping("/appointments/{id}")
	public Optional<Appointment> findById(@PathVariable("id") int id) {
		return appointmentService.findById(id);
	}

	@DeleteMapping("/appointments/{id}")
	public ResponseEntity<?> deleteAppointment(@PathVariable("id") int id) {
		return appointmentService.deleteAppointment(id);
	}

	/*--------------------------*/

	@GetMapping("/hospitals")
	public List<Hospital> findByHospitalName(
			@RequestParam(value = "hosName",required = false) String hosName,
			@RequestParam(value = "hosRegNo",required = false) String hosRegNo) {
		if(hosName!=null) {
			return appointmentService.findByHospitalName(hosName);	
		}
		if(hosRegNo != null) {
			return appointmentService.findByHospitalRegNo(hosRegNo);
		}
		return appointmentService.findAllHospitals();
		
	}

	@GetMapping("/hospitals/doctors")
	public List<Doctor> findByHospitalRegNo(@RequestParam(value = "hosRegNo") String hosRegNo) {
		return appointmentService.findDoctorsByHospital(hosRegNo);
	}

	@GetMapping("/hospitals/doctors/availability")
	public List<DoctorSchedules> findAvailabilityByHosAndDoc(@RequestParam(value = "hosRegNo") String hosRegNo,
			@RequestParam(value = "docRegNo") String docRegNo,
			@RequestParam(value = "sDate", required = false) String sDate,
			@RequestParam(value = "sSession", required = false) String sSession) {
		if (sSession != null) {
			return appointmentService.findAvailabilityByHosAndDocAndDate(hosRegNo, docRegNo, sDate, sSession);
		}
		if (sDate != null) {
			return appointmentService.findAvailabilityByHosAndDocAndDate(hosRegNo, docRegNo, sDate);
		}
		return appointmentService.findAvailabilityByHosAndDoc(hosRegNo, docRegNo);
	}
	
//	------------------------------------------
	
	
	@GetMapping("/doctors")
	public List<Doctor> findDoctorByDocRegNo(
			@RequestParam(value = "docRegNo",required = false) String docRegNo) {

		return appointmentService.findDoctorByDocRegNo(docRegNo);
		
	}
	
	
//	------------------------------------------
	
	@GetMapping("/patients")
	public List<Patient> findPatient(
			@RequestParam(value = "id",required = false) String id,
			@RequestParam(value = "nic", required = false) String nic,
			@RequestParam(value = "phone", required = false) String phone) {
		if (id != null) {
			return appointmentService.findPatientById(id);
		}
		if (nic != null) {
			return appointmentService.findPatientByNic(nic);
		}
		if(phone!= null) {
			return appointmentService.findPatientByPhone(phone);
		}
		return appointmentService.findAllPatient();
	}
	
	@GetMapping("/appointments/full")
	public AppointmentFullDetails findAppointmentDetails(
			@RequestParam(value = "patientNic") String nic,
			@RequestParam(value = "docRegNo") String docRegNo,
			@RequestParam(value = "hosRegNo") String hosRegNo,
			@RequestParam(value = "scheduleId") String scheduleId,
			@RequestParam(value = "appointmentId") String appointmentId,
			@RequestParam(value = "visitId") String visitId){
		return appointmentService.findAppointmentDetails(nic,docRegNo,hosRegNo,scheduleId,appointmentId,visitId);
	}

}
