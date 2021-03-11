package com.jatha.apmng.appointmentui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jatha.apmng.appointmentui.model.Appointment;
import com.jatha.apmng.appointmentui.service.AppointmentService;

@Controller
public class UIController {

	@Autowired
	AppointmentService appointmentService;

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

}
