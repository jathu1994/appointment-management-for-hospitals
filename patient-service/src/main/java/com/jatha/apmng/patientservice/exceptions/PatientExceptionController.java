package com.jatha.apmng.patientservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PatientExceptionController {
   @ExceptionHandler(value = PatientNotFoundException.class)
   public ResponseEntity<Object> exception(PatientNotFoundException exception) {
      return new ResponseEntity<>(exception.getMessage()+" Patient not found exception", HttpStatus.NOT_FOUND);
   }
}