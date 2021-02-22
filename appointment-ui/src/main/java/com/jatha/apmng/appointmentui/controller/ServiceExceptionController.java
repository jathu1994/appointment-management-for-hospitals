package com.jatha.apmng.appointmentui.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jatha.apmng.appointmentui.exception.DataNotFoundException;
import com.jatha.apmng.appointmentui.exception.RMIException;

@ControllerAdvice
public class ServiceExceptionController {
	
   @ExceptionHandler(DataNotFoundException.class)
   public ResponseEntity<Object> exception1(DataNotFoundException exception) {
      return new ResponseEntity<>(exception.getMessage()+"No Data Available", HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(RMIException.class)
   public ResponseEntity<Object> exception2(RMIException exception) {
      return new ResponseEntity<>(exception.getMessage()+" \nService Access failed.....", HttpStatus.NOT_FOUND);
   }
}