package com.jatha.apmng.hospitalservice.model;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ErrorMessage {
	
	int id;
	String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ErrorMessage [id=" + id + ", message=" + message + "]";
	}
	public ErrorMessage(int id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	

}
