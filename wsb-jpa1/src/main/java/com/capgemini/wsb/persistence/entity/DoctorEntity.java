package com.capgemini.wsb.persistence.entity;

import com.capgemini.wsb.persistence.enums.Specialization;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DOCTOR")
public class DoctorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long telephoneNumber;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private Long doctorNumber;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Specialization specialization;

    //Jednostronna od strony rodzica
    @OneToMany(mappedBy = "doctorEntity")
    private List<VisitEntity> visitEntity;

    //Dwustronna od strony rodzica
    @ManyToMany()
    private List<AddressEntity> addressEntity;



}
