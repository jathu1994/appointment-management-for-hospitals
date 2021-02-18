package com.jatha.apmng.appointmentui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.jatha.apmng.appointmentui.model.Appointment;

@SpringBootApplication
public class AppointmentUiApplication {
	
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(AppointmentUiApplication.class, args);
	}

}
