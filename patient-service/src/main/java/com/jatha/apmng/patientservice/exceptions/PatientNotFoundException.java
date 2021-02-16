package com.jatha.apmng.patientservice.exceptions;

public class PatientNotFoundException extends RuntimeException {
		   private static final long serialVersionUID = 1L;
		   
		   public PatientNotFoundException(String errorMessage) {
		        super(errorMessage);
		    }

}
