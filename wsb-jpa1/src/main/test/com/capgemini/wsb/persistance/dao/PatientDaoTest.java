package com.capgemini.wsb.persistance.dao;


import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.AddressEntity;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PatientDaoTest {

    @Autowired
    private PatientDao patientDao;

    @Test
    public void findPatientByLastNameTest() {
        String surname = "Mostowiak";
        List<PatientEntity> foundedPatients = patientDao.findPatientsByLastName(surname);
        assertThat(foundedPatients).hasSize(2);
    }
    @Test
    public void findPatientsWithMoreThanSpecificNumberVisitTest() {
        Integer visitNum = 2;
        List<PatientEntity> foundedPatients = patientDao.findPatientsWithMoreThanSpecificNumberVisit(visitNum);
        assertThat(foundedPatients).hasSize(1);
    }

    @Test
    public void findPatientsByContactPersonTelephoneNumberTest() {
        String contactPersonNumber = "123456789";
        List<PatientEntity> foundedPatients = patientDao.findPatientsByContactPersonTelephoneNumber(contactPersonNumber);
        assertThat(foundedPatients).hasSize(1);
    }
}
