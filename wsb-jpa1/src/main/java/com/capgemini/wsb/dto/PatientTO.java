package com.capgemini.wsb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class PatientTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Long telephoneNumber;
    private String email;
    private Long patientNumber;
    private LocalDate dateOfBirth;
    private List<VisitTO> visit;
    private List<AddressTO> address;
    private Long contactPersonPhoneNumber;
}
