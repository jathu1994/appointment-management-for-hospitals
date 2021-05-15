package com.jatha.apmng.appointmentui.service;

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
import com.jatha.apmng.appointmentui.model.DoctorSchedules;
import com.jatha.apmng.appointmentui.model.HospitalStaff;

@Service
public class SessionServiceImpl implements SessionService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AccessToken accessToken;

	@Override
	public DoctorSchedules saveSession(DoctorSchedules doctorSchedules) {
		
		System.out.println(doctorSchedules);
		
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());

		HttpEntity<DoctorSchedules> request = new HttpEntity<>(doctorSchedules, httpHeaders);
		try {

			ResponseEntity<DoctorSchedules> responseEntity = restTemplate.exchange(
					"http://localhost:2020/hospital-api/hosservices/doctorSchedules", HttpMethod.POST, request,
					DoctorSchedules.class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("Can't save this session");

			}

			return responseEntity.getBody();

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong saving appointment details to appointment service....\n"
							+ e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadHospitalByUserName() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());
		
		String userName= accessToken.getLoggedUser();

		HttpEntity<HospitalStaff> request = new HttpEntity<>(httpHeaders);

		try {
			ResponseEntity<HospitalStaff[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/appointment-api/aptservice/staffs?userName=" + userName, HttpMethod.GET,
					request, HospitalStaff[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("System error try reloading the page or sign in again");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading hospital details reload or sign in again....\n" + e.getMessage());

		}
	}

	@Override
	public ResponseEntity<?> loadSessionById(int sId) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Authorization", accessToken.getAccessToken());
		
		String userName= accessToken.getLoggedUser();

		HttpEntity<DoctorSchedules> request = new HttpEntity<>(httpHeaders);

		try {
			ResponseEntity<DoctorSchedules[]> responseEntity = restTemplate.exchange(
					"http://localhost:2020/hospital-api/hosservices/doctorSchedules/"+sId, HttpMethod.GET,
					request, DoctorSchedules[].class);

			if (responseEntity.getBody() == null) {
				throw new DataNotFoundException("System error try reloading the page or sign in again");

			}
			return responseEntity;

		} catch (HttpStatusCodeException e) {
			throw new RMIException(
					"oops...some thing went wrong loading hospital details reload or sign in again....\n" + e.getMessage());

		}
	}

}
