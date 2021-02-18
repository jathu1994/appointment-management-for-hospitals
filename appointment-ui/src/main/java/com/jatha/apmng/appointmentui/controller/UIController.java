package com.jatha.apmng.appointmentui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jatha.apmng.appointmentui.model.Appointment;
import com.jatha.apmng.appointmentui.service.AjaxService;

@Controller
public class UIController {
	
	@Autowired
	AjaxService ajaxService;
	
	@GetMapping("/")
	public String loadUI(Model model) {
		model.addAttribute("appointment", new Appointment());
		return "home";
		
	}
	
	@PostMapping("/")
	  public String saveAppointment(@ModelAttribute Appointment appointment, Model model) {
		Appointment savedAppointment = ajaxService.saveAppointment(appointment);
	    model.addAttribute("appointment", savedAppointment);
	    return "redirect:/";
	  }

}
