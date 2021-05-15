package com.jatha.apmng.appointmentui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jatha.apmng.appointmentui.model.Appointment;
import com.jatha.apmng.appointmentui.model.Doctor;
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.HospitalStaff;
import com.jatha.apmng.appointmentui.model.Patient;
import com.jatha.apmng.appointmentui.model.VisitingDoctors;
import com.jatha.apmng.appointmentui.service.AppointmentService;
import com.jatha.apmng.appointmentui.service.SessionService;

@Controller
public class UIController {

	@Autowired
	AppointmentService appointmentService;
	
	@Autowired
	SessionService sessionService;

	@GetMapping("/")
	public String loadHome() {
		return "home";

	}
	@GetMapping("/navbar")
	public String loadNavBar() {
		return "navbar";

	}

	@GetMapping("/appointment")
	public String loadAppointmentManager(Model model) {
		model.addAttribute("appointment", new Appointment());
		return "appointmentmanager";

	}

	@PostMapping("/appointment")
	public String saveAppointment(@ModelAttribute Appointment appointment, Model model) {
		Appointment savedAppointment = appointmentService.saveAppointment(appointment);
		model.addAttribute("appointment", savedAppointment);
		return "redirect:/appointment";
	}
	
	@GetMapping("/patient")
	public String loadPatientManager(Model model) {
		model.addAttribute("patient", new Patient());
		return "patientmanager";

	}
	
	@GetMapping("/doctor")
	public String loadDoctorManager(Model model) {
		model.addAttribute("doctor", new Doctor());
		return "doctormanager";

	}
	
	@GetMapping("/session")
	public String loadSessionManager(Model model) {
		model.addAttribute("doctorSchedules", new DoctorSchedules());
		return "doctorsessionmanager";

	}
	
	@PostMapping("/session")
	public String saveSession(@ModelAttribute DoctorSchedules doctorSchedules, Model model) {
		DoctorSchedules savedDoctorSchedules = sessionService.saveSession(doctorSchedules);
		model.addAttribute("doctorSchedules", savedDoctorSchedules);
		return "redirect:/session";
	}
	
	@GetMapping("/hospital")
	public String loadHospitalManager(Model model) {
		model.addAttribute("hospital", new Hospital());
		return "hospitalmanager";

	}
	
	@GetMapping("/employee")
	public String loadEmployeeManager(Model model) {
		model.addAttribute("hospitalStaff", new HospitalStaff());
		return "employeemanager";

	}
	
	@GetMapping("/visit")
	public String loadVisitManager(Model model) {
		model.addAttribute("visitingDoctors", new VisitingDoctors());
		return "doctorvisitmanager";

	}

}
