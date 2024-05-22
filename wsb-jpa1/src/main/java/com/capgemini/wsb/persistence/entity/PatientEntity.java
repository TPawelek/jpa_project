package com.capgemini.wsb.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "PATIENT")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String telephoneNumber;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long patientNumber;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    private String contactPersonPhoneNumber;

    //Jednostronna od strony rodzica
    @OneToMany(mappedBy = "patientEntity",cascade = CascadeType.REMOVE)
    private List<VisitEntity> visitEntity;

    //Dwustronna od strony rodzica
    @ManyToMany()
    private List<AddressEntity> addressEntity;

}
