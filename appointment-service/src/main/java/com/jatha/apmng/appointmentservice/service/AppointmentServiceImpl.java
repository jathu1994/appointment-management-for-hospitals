package com.jatha.apmng.appointmentservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jatha.apmng.appointmentservice.model.Appointment;
import com.jatha.apmng.appointmentservice.model.AppointmentFullDetails;
import com.jatha.apmng.appointmentservice.model.Doctor;
import com.jatha.apmng.appointmentservice.model.DoctorSchedules;
import com.jatha.apmng.appointmentservice.model.Hospital;
import com.jatha.apmng.appointmentservice.model.Patient;
import com.jatha.apmng.appointmentservice.model.VisitingDoctors;
import com.jatha.apmng.appointmentservice.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
//	@Autowired
//	AppointmentFullDetails appointmentFullDetails;

	@Override
	public Appointment save(Appointment appointment) {
		return appointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> findAll() {
		return appointmentRepository.findAll();
	}

	@Override
	public Optional<Appointment> findById(int id) {
		return appointmentRepository.findById(id);
	}

	@Override
	public ResponseEntity<?> deleteAppointment(int id) {
		return appointmentRepository.findById(id).map(appointment -> {
			appointmentRepository.delete(appointment);
            return ResponseEntity.ok().build();
        }).orElse(null);
	}
	
	@Override
	public List<Hospital> findByHospitalName(String hosName) {
		ResponseEntity<Hospital[]> response = restTemplate.getForEntity("http://localhost:9193/hosservices/hospitals?hosName="+hosName,Hospital[].class);
		Hospital[] hospitals = response.getBody();
		
		List<Hospital> list = Arrays.asList(hospitals);
				
		return list;
	}

	@Override
	public List<Doctor> findDoctorsByHospital(String hosRegNo) {
		System.out.println(hosRegNo);
		ResponseEntity<VisitingDoctors[]> response = restTemplate.getForEntity("http://localhost:9193/hosservices/visitingdoctors?hosRegNo="+hosRegNo,VisitingDoctors[].class);
		VisitingDoctors[] visitingDoctors = response.getBody();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++");
		
		List<Doctor> doctorList = new ArrayList<Doctor>();
		for(VisitingDoctors visitDetail : visitingDoctors) {
			System.out.println(visitDetail);
			System.out.println(visitDetail.getDocRegNo());
			
			ResponseEntity<Doctor> response2 = restTemplate.getForEntity("http://localhost:9191/docservices/doctors/"+visitDetail.getDocRegNo(),Doctor.class);
			Doctor doctor = response2.getBody();
			doctorList.add(doctor);
			
			
			
		}
		return doctorList;
	}

	@Override
	public List<DoctorSchedules> findAvailabilityByHosAndDoc(String hosRegNo, String docRegNo) {
		ResponseEntity<DoctorSchedules[]> response = restTemplate.getForEntity("http://localhost:9193/hosservices/doctorSchedules/"+hosRegNo+"/"+docRegNo,DoctorSchedules[].class);
		DoctorSchedules[] schedules = response.getBody();
		
		List<DoctorSchedules> list = Arrays.asList(schedules);
				
		return list;
	}

	@Override
	public List<DoctorSchedules> findAvailabilityByHosAndDocAndDate(String hosRegNo, String docRegNo, String sDate) {
		ResponseEntity<DoctorSchedules[]> response = restTemplate.getForEntity("http://localhost:9193/hosservices/doctorSchedules/"+hosRegNo+"/"+docRegNo+"/"+sDate,DoctorSchedules[].class);
		DoctorSchedules[] schedules = response.getBody();
		
		List<DoctorSchedules> list = Arrays.asList(schedules);
				
		return list;
	}

	@Override
	public List<DoctorSchedules> findAvailabilityByHosAndDocAndDate(String hosRegNo, String docRegNo, String sDate,
			String session) {
		
		ResponseEntity<DoctorSchedules> response = restTemplate.getForEntity("http://localhost:9193/hosservices/doctorSchedules/"+hosRegNo+"/"+docRegNo+"/"+sDate+"/"+session,DoctorSchedules.class);
		DoctorSchedules schedules = response.getBody();
		
		List<DoctorSchedules> list = new ArrayList<DoctorSchedules>();
		list.add(schedules);
				
		return list;
	}
	
	//patient

	@Override
	public List<Patient> findPatientById(String id) {
		ResponseEntity<Patient> response = restTemplate.getForEntity("http://localhost:9192/services/patients/"+id,Patient.class);
		Patient patient = response.getBody();
		
		List<Patient> list = new ArrayList<Patient>();
		list.add(patient);
				
		return list;
	}

	@Override
	public List<Patient> findPatientByNic(String nic) {
		ResponseEntity<Patient> response = restTemplate.getForEntity("http://localhost:9192/services/patients/find?nic="+nic,Patient.class);
		Patient patient = response.getBody();
		
		List<Patient> list = new ArrayList<Patient>();
		list.add(patient);
				
		return list;
	}

	@Override
	public List<Patient> findPatientByPhone(String phone) {
		ResponseEntity<Patient[]> response = restTemplate.getForEntity("http://localhost:9192/services/patients/find/phone?phone="+phone,Patient[].class);
		Patient[] patients = response.getBody();
		
		List<Patient> list = Arrays.asList(patients);
				
		return list;
	}

	@Override
	public AppointmentFullDetails findAppointmentDetails(String nic, String docRegNo, String hosRegNo, String scheduleId,
			String appointmentId, String visitId) {
		
		AppointmentFullDetails ap = new AppointmentFullDetails();
		
		ResponseEntity<Patient> responsePatient = restTemplate.getForEntity("http://localhost:9192/services/patients/find?nic="+nic,Patient.class);
		Patient patient = responsePatient.getBody();
		ap.setPatient(patient);
		
		ResponseEntity<Doctor> responseDoctor = restTemplate.getForEntity("http://localhost:9191/docservices/doctors/"+docRegNo,Doctor.class);
		Doctor doctor = responseDoctor.getBody();
		ap.setDoctor(doctor);
		
		ResponseEntity<Hospital> responseHospital = restTemplate.getForEntity("http://localhost:9193/hosservices/hospitals/"+hosRegNo,Hospital.class);
		Hospital hospital = responseHospital.getBody();
		ap.setHospital(hospital);
		
		ResponseEntity<DoctorSchedules> responseDoctorSchedules = restTemplate.getForEntity("http://localhost:9193/hosservices/doctorSchedules/"+scheduleId,DoctorSchedules.class);
		DoctorSchedules doctorSchedules = responseDoctorSchedules.getBody();
		ap.setDoctorSchedules(doctorSchedules);
		
		ResponseEntity<Appointment> responseAppointment = restTemplate.getForEntity("http://localhost:9194/aptservice/appointments/"+appointmentId,Appointment.class);
		Appointment appointment = responseAppointment.getBody();
		ap.setAppointment(appointment);
		
		ResponseEntity<VisitingDoctors> responseVisitingDoctors = restTemplate.getForEntity("http://localhost:9193/hosservices/visitingdoctors/"+visitId,VisitingDoctors.class);
		VisitingDoctors visitingDoctors = responseVisitingDoctors.getBody();
		ap.setVisitingDoctors(visitingDoctors);
		
		
		return ap;
	}
	
	
	
	
	//patient
	
	
	
	
	
	
	
	
	
	
	
	

}
