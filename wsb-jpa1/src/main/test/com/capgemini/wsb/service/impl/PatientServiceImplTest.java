package com.capgemini.wsb.service.impl;

import com.capgemini.wsb.dto.PatientTO;
import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.DoctorEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import com.capgemini.wsb.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientServiceImplTest {
    @Autowired
    private PatientDao patientDao;
    @Autowired
    private PatientServiceImpl patientServiceImpl;

    private final String name = "Paweł";
    private final String surname = "Pawełek";

    @Test
    public void deletePatientTest() {
        //given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName(name);
        patientEntity.setLastName(surname);
        patientEntity.setEmail("efeifh@wp.pl");
        patientEntity.setPatientNumber(745859658L);
        patientEntity.setTelephoneNumber("7458965265");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 8, 10));
        patientEntity.setAddressEntity(List.of(new AddressEntity()));
        patientEntity.setVisitEntity(List.of(new VisitEntity()));
        patientEntity.setContactPersonPhoneNumber("456456456");
        // When
        final PatientEntity updatedPatient = patientDao.update(patientEntity);
        patientDao.delete(updatedPatient.getId());
        List<PatientEntity> foundPatients = patientDao.findAll();
        // Then
        assertThat(patientServiceImpl.findById(patientEntity.getId())).isNull();
        assertThat(foundPatients).isEmpty();
    }

    @Test
    public void FindPatientByIdTest() {
        // Given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName(name);
        patientEntity.setLastName(surname);
        patientEntity.setEmail("efeifh@wp.pl");
        patientEntity.setPatientNumber(745859658L);
        patientEntity.setTelephoneNumber("7458965265");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 8, 10));
        patientEntity.setAddressEntity(List.of(new AddressEntity()));
        patientEntity.setVisitEntity(List.of(new VisitEntity()));
        patientEntity.setContactPersonPhoneNumber("456456456");
        // When
        final PatientEntity updatedPatient = patientDao.update(patientEntity);
        PatientTO patientById = patientServiceImpl.findById(updatedPatient.getId());
        // Then
        assertThat(patientById).isNotNull();
        assertThat(patientById.getFirstName()).isEqualTo(name);
        assertThat(patientById.getLastName()).isEqualTo(surname);
    }

    @Test
    public void findAllVisitsByPatientIdTest() {
        VisitEntity visit1 = new VisitEntity();
        VisitEntity visit2 = new VisitEntity();
        VisitEntity visit3 = new VisitEntity();
        // Given
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(1L);
        patientEntity.setFirstName(name);
        patientEntity.setLastName(surname);
        patientEntity.setEmail("efeifh@wp.pl");
        patientEntity.setPatientNumber(745859658L);
        patientEntity.setTelephoneNumber("7458965265");
        patientEntity.setDateOfBirth(LocalDate.of(1990, 8, 10));
        patientEntity.setAddressEntity(List.of(new AddressEntity()));
        patientEntity.setVisitEntity(List.of(visit1, visit2, visit3));
        patientEntity.setContactPersonPhoneNumber("456456456");


        // When
        final PatientEntity updatedPatient = patientDao.update(patientEntity);
        PatientTO patientById = patientServiceImpl.findById(updatedPatient.getId());
        // Then
        assertThat(patientById.getVisit().size()).isNotNull();
        assertThat(patientById.getVisit()).hasSize(3);
    }
}