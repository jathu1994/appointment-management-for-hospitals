package com.jatha.apmng.appointmentui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableOAuth2Sso
public class AppointmentUiApplication extends WebSecurityConfigurerAdapter {
	
	
	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/")
		.permitAll()
		.anyRequest()
		.authenticated().and().httpBasic().disable();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(AppointmentUiApplication.class, args);
	}

}
