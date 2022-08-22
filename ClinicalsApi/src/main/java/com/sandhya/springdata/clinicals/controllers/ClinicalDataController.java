package com.sandhya.springdata.clinicals.controllers;

import java.sql.Timestamp;
import java.util.Date;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sandhya.springdata.clinicals.dto.ClinicalDataRequest;
import com.sandhya.springdata.clinicals.model.ClinicalData;
import com.sandhya.springdata.clinicals.model.Patient;
import com.sandhya.springdata.clinicals.repos.ClinicalDataRepository;
import com.sandhya.springdata.clinicals.repos.PatientRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicalDataController {
	
	@Autowired
	private ClinicalDataRepository clinicalDatarepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@RequestMapping(value ="/clinicals", method =RequestMethod.POST )
	public ClinicalData saveclinicalData(@RequestBody ClinicalDataRequest request) {
		
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setComponentValue(request.getComponentValue());
		clinicalData.setPatient(patient);
		
		Timestamp time = new Timestamp(new Date().getTime());
		clinicalData.setMeasuredDateTime(time);
		
		return clinicalDatarepository.save(clinicalData);
		
	}

}
