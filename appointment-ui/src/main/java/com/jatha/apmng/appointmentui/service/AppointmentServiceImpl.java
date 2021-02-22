package com.jatha.apmng.appointmentui.service;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.jatha.apmng.appointmentui.config.AccessToken;
import com.jatha.apmng.appointmentui.exception.DataNotFoundException;
import com.jatha.apmng.appointmentui.exception.RMIException;
import com.jatha.apmng.appointmentui.model.Appointment;
import com.jatha.apmng.appointmentui.model.Doctor;
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.Hospital;
import com.jatha.apmng.appointmentui.model.Patient;
import com.jatha.apmng.appointmentui.model.VisitingDoctors;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AccessToken accessToken;

//	@Override
//	public List<Hospital> loadAllHospitals() {
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add("Authorization", accessToken.getAccessToken());
//
//		HttpEntity<Hospital> request = new HttpEntity<>(httpHeaders);
//		List<Hospital> list = null;
//		try {
//			ResponseEntity<Hospital[]> responseEntity = restTemplate.exchange(
//					"http://localhost:2020/appointment-api/aptservice/hospitals", HttpMethod.GET, request,
//					Hospital[].class);
//
//			list = Arrays.asList(responseEntity.getBody());
//			if(list.size()==0) {
//				
//				throw new DataNotFoundException("No Hospitals available");
//				
//			}
//
//		} catch (HttpStatusCodeException e) {
//			
//			throw new RMIException(e.getMessage());
//		}
//		return list;
//
//	}

	@Override
	public ResponseEntity<?> loadAllHospitals() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		try {
			HttpEntity<Hospital> request = new HttpEntity<>(httpHeaders);
			ResponseEntity<Hospital[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/hospitals", HttpMethod.GET, request,
					Hospital[].class);
			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no Hospitals were listed");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {

			throw new RMIException(
					"oops...some thing went wrong loading data from hospital service....\n" + e.getMessage());

		}

	}

	@Override
	public ResponseEntity<?> loadHospitalByRegNo(String hosRegNo) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<Hospital> request = new HttpEntity<>(httpHeaders);
		try {
			ResponseEntity<Hospital[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/hospitals?hosRegNo=" + hosRegNo, HttpMethod.GET,
					request, Hospital[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("No Data for the given HosRegNo");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {

			throw new RMIException(
					"oops...some thing went wrong loading data from hospital service....\n" + e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadAllPatients() {

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<Patient> request = new HttpEntity<>(httpHeaders);

		try {
			ResponseEntity<Patient[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/patients", HttpMethod.GET, request,
					Patient[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no patients were listed");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading data from patient service....\n" + e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadPatientByNic(String nic) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<Patient> request = new HttpEntity<>(httpHeaders);

		try {

			ResponseEntity<Patient[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/patients?nic=" + nic, HttpMethod.GET, request,
					Patient[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("No Data for the given NIC");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading data from patient service....\n" + e.getMessage());

		}

	}

	@Override
	public ResponseEntity<?> loadAllDoctorsByHospital(String hosRegNo) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<Doctor> request = new HttpEntity<>(httpHeaders);
		try {

			ResponseEntity<Doctor[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/hospitals/doctors?hosRegNo=" + hosRegNo,
					HttpMethod.GET, request, Doctor[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no doctors are listed in this hospital");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading doctor details from hospital service....\n" + e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadADoctorByRegNo(String docRegNo) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<Doctor> request = new HttpEntity<>(httpHeaders);

		try {
			ResponseEntity<Doctor[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/doctors?docRegNo=" + docRegNo, HttpMethod.GET,
					request, Doctor[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no doctors are listed for this DocRegNo");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading doctor details from doctor service....\n" + e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadAllAvailableDates(String hosRegNo, String docRegNo) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<DoctorSchedules> request = new HttpEntity<>(httpHeaders);
		try {

			ResponseEntity<DoctorSchedules[]> responseEntity = restTemplate
					.exchange(
							"http://localhost:2020/appointment-api/aptservice//hospitals/doctors/availability?hosRegNo="
									+ hosRegNo + "&docRegNo=" + docRegNo,
							HttpMethod.GET, request, DoctorSchedules[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no schedules are listed for this doctor");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading doctor session details from hospital service....\n"
							+ e.getMessage());

		}

	}

	@Override
	public ResponseEntity<?> loadAllAvailableSessions(String hosRegNo, String docRegNo, Date sDate) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<DoctorSchedules> request = new HttpEntity<>(httpHeaders);
		try {
			ResponseEntity<DoctorSchedules[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice//hospitals/doctors/availability?hosRegNo="
							+ hosRegNo + "&docRegNo=" + docRegNo + "&sDate=" + sDate,
					HttpMethod.GET, request, DoctorSchedules[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no schedules are listed for this date");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading doctor session details from hospital service....\n"
							+ e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadSession(String hosRegNo, String docRegNo, Date sDate, String sSession) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<DoctorSchedules> request = new HttpEntity<>(httpHeaders);
		try {

			ResponseEntity<DoctorSchedules[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice//hospitals/doctors/availability?hosRegNo="
							+ hosRegNo + "&docRegNo=" + docRegNo + "&sDate=" + sDate + "&sSession=" + sSession,
					HttpMethod.GET, request, DoctorSchedules[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no schedules are listed for the slot selected");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading doctor session details from hospital service....\n"
							+ e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadVisitDetailsByHosAndDoc(String hosRegNo, String docRegNo) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<VisitingDoctors> request = new HttpEntity<>(httpHeaders);
		try {
			ResponseEntity<VisitingDoctors[]> responseEntity = restTemplate
					.exchange("http://localhost:2020/appointment-api/aptservice/hospitals/visits?hosRegNo=" + hosRegNo
							+ "&docRegNo=" + docRegNo, HttpMethod.GET, request, VisitingDoctors[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("no schedules are listed for this doctor");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading doctor session details from hospital service....\n"
							+ e.getMessage());

		}
	}

//	@Override
//	public Appointment saveAppointment(Appointment appointment) {
//		HttpHeaders httpHeaders = new HttpHeaders();
//		httpHeaders.add("Authorization", accessToken.getAccessToken());
//
//		HttpEntity<Appointment> request = new HttpEntity<>(appointment, httpHeaders);
//		try {
//
//			ResponseEntity<Appointment> responseEntity = restTemplate.exchange(
//					"http://localhost:2020/appointment-api/aptservice/appointments", HttpMethod.POST, request,
//					Appointment.class);
//			return responseEntity.getBody();
//
//		} catch (HttpStatusCodeException e) {
//
//		}
//		return null;
//	}
	
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<Appointment> request = new HttpEntity<>(appointment, httpHeaders);
		try {

			ResponseEntity<Appointment> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/appointments", HttpMethod.POST, request,
					Appointment.class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("Can't save your appointment");

			}
			return responseEntity.getBody();

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong saving appointment details to appointment service....\n"
							+ e.getMessage());

		}
	}

}
