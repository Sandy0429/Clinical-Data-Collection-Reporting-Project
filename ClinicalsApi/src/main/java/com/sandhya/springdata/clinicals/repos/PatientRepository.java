package com.sandhya.springdata.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandhya.springdata.clinicals.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
