package com.capgemini.wsb.mapper;



import com.capgemini.wsb.dto.AddressTO;
import com.capgemini.wsb.dto.PatientTO;

import com.capgemini.wsb.dto.VisitTO;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class PatientMapper {
    public static PatientTO mapToTO(final PatientEntity patientEntity) {
        if (patientEntity == null) {
            return null;
        }
        final PatientTO patientTO = new PatientTO();
        patientTO.setId(patientEntity.getId());
        patientTO.setFirstName(patientEntity.getFirstName());
        patientTO.setLastName(patientEntity.getLastName());
        patientTO.setEmail(patientEntity.getEmail());
        patientTO.setPatientNumber(patientEntity.getPatientNumber());
        patientTO.setDateOfBirth(patientEntity.getDateOfBirth());
        patientTO.setTelephoneNumber(patientEntity.getTelephoneNumber());
        patientTO.setContactPersonPhoneNumber(patientEntity.getContactPersonPhoneNumber());
        patientTO.setVisit(patientEntity.getVisitEntity().stream()
                .map(visitEntity -> {
                    VisitTO visitTO = new VisitTO();
                    visitTO.setId(visitEntity.getId());
                    visitTO.setTime(visitEntity.getTime());
                    visitTO.setDescription(visitEntity.getDescription());
                    return visitTO;
                })
                .collect(Collectors.toList()));
        patientTO.setAddress(patientEntity.getAddressEntity().stream()
                .map(AddressMapper::mapToTO)
                .collect(Collectors.toList()));
        return patientTO;
    }

    public static PatientEntity mapToEntity(final PatientTO patientTO) {
        if (patientTO == null) {
            return null;
        }
        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(patientTO.getId());
        patientEntity.setFirstName(patientTO.getFirstName());
        patientEntity.setLastName(patientTO.getLastName());
        patientEntity.setEmail(patientTO.getEmail());
        patientEntity.setPatientNumber(patientTO.getPatientNumber());
        patientEntity.setDateOfBirth(patientTO.getDateOfBirth());
        patientEntity.setTelephoneNumber(patientTO.getTelephoneNumber());
        patientEntity.setContactPersonPhoneNumber(patientTO.getContactPersonPhoneNumber());
        patientEntity.setVisitEntity(patientTO.getVisit().stream()
                .map(visitTO -> {
                    VisitEntity visitEntity = new VisitEntity();
                    visitEntity.setId(visitTO.getId());
                    visitEntity.setTime(visitTO.getTime());
                    visitEntity.setDescription(visitTO.getDescription());
                    return visitEntity;
                })
                .collect(Collectors.toList()));
        patientEntity.setAddressEntity(patientTO.getAddress().stream()
                .map(AddressMapper::mapToEntity)
                .collect(Collectors.toList()));

        return patientEntity;
    }

}
