package com.jatha.apmng.billingservice.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BillingDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	int appointmentId;
	double hosFee;
	double tax;
	double total;
	double discounts;
	double claims;
	double payable;
	Date date;
	Time time;

}
