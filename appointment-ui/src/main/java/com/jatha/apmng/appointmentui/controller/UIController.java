package com.jatha.apmng.appointmentui.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.Patient;

@Controller
public class UIController {
	
	
	
	@Autowired 
	RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String loadUI() {
		return "home";
		
	}
	
	
	@RequestMapping("/patients") 
	public String loadPatients(Model model) {
	
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("patientId","10");
		HttpEntity<Patient> patientHttpEntity = new HttpEntity<>(httpHeaders);
		
		try {
		ResponseEntity<Patient[]> responseEntity = restTemplate.exchange("http://localhost:9194/aptservice/patients?phone=0759017404", HttpMethod.GET,patientHttpEntity,Patient[].class);
		model.addAttribute("patients", responseEntity.getBody());
		System.out.println(responseEntity.getBody().length+">>>>>>>>");
		}catch(HttpStatusCodeException e){
			ResponseEntity responseEntity = ResponseEntity
					.status(e.getRawStatusCode())
					.headers(e.getResponseHeaders())
					.body(e.getResponseBodyAsString());
			
			model.addAttribute("error",responseEntity);
			
		}
		
		
		return "home";
		
	}

}
