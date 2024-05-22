package com.capgemini.wsb.persistence.dao;

import com.capgemini.wsb.persistence.entity.PatientEntity;

import java.util.List;

public interface PatientDao extends Dao<PatientEntity, Long> {

    public List<PatientEntity> findPatientsByLastName(String lastName);
    public List<PatientEntity> findPatientsWithMoreThanSpecificNumberVisit(Integer visitNumber);
    public List<PatientEntity> findPatientsByContactPersonTelephoneNumber(String telephoneNumber);
}
