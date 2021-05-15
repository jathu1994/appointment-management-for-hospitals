package com.jatha.apmng.appointmentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.appointmentservice.model.Appointment;
import com.jatha.apmng.appointmentservice.model.AppointmentFullDetails;
import com.jatha.apmng.appointmentservice.model.Doctor;
import com.jatha.apmng.appointmentservice.model.DoctorSchedules;
import com.jatha.apmng.appointmentservice.model.Hospital;
import com.jatha.apmng.appointmentservice.model.HospitalStaff;
import com.jatha.apmng.appointmentservice.model.Patient;
import com.jatha.apmng.appointmentservice.model.VisitingDoctors;
import com.jatha.apmng.appointmentservice.service.AppointmentService;

@RestController
@RequestMapping("/aptservice")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@PostMapping("/appointments")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {

		return appointmentService.save(appointment);
	}

	@GetMapping("/appointments")
	@PreAuthorize("hasRole('ROLE_super_admin')")
	public List<Appointment> findAllAppointments() {

		return appointmentService.findAll();

	}

	@GetMapping("/appointments/{id}")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public Optional<Appointment> findById(@PathVariable("id") int id) {
		return appointmentService.findById(id);
	}

	@DeleteMapping("/appointments/{id}")
	@PreAuthorize("hasRole('ROLE_super_admin')")
	public ResponseEntity<?> deleteAppointment(@PathVariable("id") int id) {
		return appointmentService.deleteAppointment(id);
	}

	/*--------------------------*/

	@GetMapping("/hospitals")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<Hospital> findByHospitalName(@RequestParam(value = "hosName", required = false) String hosName,
			@RequestParam(value = "hosRegNo", required = false) String hosRegNo) {
		if (hosName != null) {
			return appointmentService.findByHospitalName(hosName);
		}
		if (hosRegNo != null) {
			return appointmentService.findByHospitalRegNo(hosRegNo);
		}
		return appointmentService.findAllHospitals();

	}

	@GetMapping("/hospitals/doctors")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<Doctor> findByHospitalRegNo(@RequestParam(value = "hosRegNo", required = false) String hosRegNo,
			@RequestParam(value = "docRegNo", required = false) String docRegNo) {
		if (hosRegNo != null && docRegNo != null) {

		}
		return appointmentService.findDoctorsByHospital(hosRegNo);
	}

	@GetMapping("/hospitals/doctors/availability")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<DoctorSchedules> findAvailabilityByHosAndDoc(
			@RequestParam(value = "hosRegNo") String hosRegNo,
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
	
	@PostMapping("/hospitals/doctors/availability")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public DoctorSchedules updateNextAppointmentNumber(@RequestBody DoctorSchedules doctorSchedules) {
		
		System.out.println(doctorSchedules);
		System.out.println(doctorSchedules.getId());

		return appointmentService.updateNextAppointmentNumber(doctorSchedules);
	}

//	------------------------------------------

	@GetMapping("/doctors")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<Doctor> findDoctorByDocRegNo(@RequestParam(value = "docRegNo", required = false) String docRegNo) {

		return appointmentService.findDoctorByDocRegNo(docRegNo);

	}

//	------------------------------------------

	@GetMapping("/hospitals/visits")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<VisitingDoctors> findVisitDetailsByHosAndDoc(
			@RequestParam(value = "hosRegNo", required = false) String hosRegNo,
			@RequestParam(value = "docRegNo", required = false) String docRegNo) {
		return appointmentService.findVisitDetailsByHosRegNoAndDocRegNo(hosRegNo, docRegNo);
	}

	@GetMapping("/patients")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<Patient> findPatient(@RequestParam(value = "id", required = false) String id,
			@RequestParam(value = "nic", required = false) String nic,
			@RequestParam(value = "phone", required = false) String phone) {
		if (id != null) {
			return appointmentService.findPatientById(id);
		}
		if (nic != null) {
			return appointmentService.findPatientByNic(nic);
		}
		if (phone != null) {
			return appointmentService.findPatientByPhone(phone);
		}
		return appointmentService.findAllPatient();
	}

	@GetMapping("/appointments/full")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public AppointmentFullDetails findAppointmentDetails(@RequestParam(value = "patientNic") String nic,
			@RequestParam(value = "docRegNo") String docRegNo, @RequestParam(value = "hosRegNo") String hosRegNo,
			@RequestParam(value = "scheduleId") String scheduleId,
			@RequestParam(value = "appointmentId") String appointmentId,
			@RequestParam(value = "visitId") String visitId) {
		return appointmentService.findAppointmentDetails(nic, docRegNo, hosRegNo, scheduleId, appointmentId, visitId);
	}

	@GetMapping("/staffs")
	@PreAuthorize("hasRole('ROLE_super_admin') or hasRole('ROLE_hospital_admin') or hasRole('ROLE_hospital_staff')")
	public List<HospitalStaff> findHospitalByUserName(
			@RequestParam(value = "userName", required = true) String userName) {
		
		System.out.println("staff+++++++++++++++++++++++++++++++++++++++");
		return appointmentService.findHospitalByUserName(userName);
	}

}
