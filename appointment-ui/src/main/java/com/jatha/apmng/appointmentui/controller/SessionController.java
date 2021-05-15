package com.jatha.apmng.appointmentui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jatha.apmng.appointmentui.service.SessionService;

@RestController
@RequestMapping("/sessionservice")
public class SessionController {
	
	@Autowired
	SessionService sessionService;
	
	
	@GetMapping("/staffs")
	public ResponseEntity<?> loadHospitalByUserName() {

		return sessionService.loadHospitalByUserName();
	}
	
	@GetMapping("/session")
	public ResponseEntity<?> loadSessionById(@RequestParam(value = "sessionId") int sessionId) {

		return sessionService.loadSessionById(sessionId);
	}

}
