package com.capgemini.wsb.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class VisitTO implements Serializable {

    private Long id;
    private String description;
    private LocalDateTime time;
    private PatientTO patient;
    private DoctorTO doctor;


}
