package com.sandhya.springdata.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandhya.springdata.clinicals.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
