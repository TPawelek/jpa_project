package com.capgemini.wsb.persistence.dao.impl;

import com.capgemini.wsb.persistence.dao.PatientDao;
import com.capgemini.wsb.persistence.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDaoImpl extends AbstractDao<PatientEntity, Long> implements PatientDao {

    @Override
    public List<PatientEntity> findPatientsByLastName(String lastName) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.lastName LIKE :lastName", PatientEntity.class)
                .setParameter("lastName", "%" + lastName + "%")
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsWithMoreThanSpecificNumberVisit(Integer visitNumber) {
        return entityManager.createQuery("SELECT DISTINCT p FROM PatientEntity p JOIN p.visitEntity ve GROUP BY p HAVING COUNT(ve) > :visitNumber", PatientEntity.class)
                .setParameter("visitNumber", visitNumber.longValue())
                .getResultList();
    }

    @Override
    public List<PatientEntity> findPatientsByContactPersonTelephoneNumber(String telephoneNumber) {
        return entityManager.createQuery("SELECT p FROM PatientEntity p WHERE p.contactPersonPhoneNumber LIKE :telephoneNumber", PatientEntity.class)
                .setParameter("telephoneNumber", telephoneNumber)
                .getResultList();
    }
}

