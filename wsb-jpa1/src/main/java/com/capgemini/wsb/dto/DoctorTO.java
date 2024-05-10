package com.capgemini.wsb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class DoctorTO implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private Long telephoneNumber;
    private String email;
    private Long doctorNumber;
    private String specialization;
    private List<VisitTO> visit;
    private List<AddressTO> address;
}
