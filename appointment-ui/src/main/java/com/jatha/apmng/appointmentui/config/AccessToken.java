package com.jatha.apmng.appointmentui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

@Configuration
public class AccessToken {
	
	public String getAccessToken() {
		
		OAuth2AuthenticationDetails authenticationDetails = (OAuth2AuthenticationDetails)SecurityContextHolder.getContext().getAuthentication().getDetails();
		return authenticationDetails.getTokenType().concat(" ").concat(authenticationDetails.getTokenValue());
		
	}

}
