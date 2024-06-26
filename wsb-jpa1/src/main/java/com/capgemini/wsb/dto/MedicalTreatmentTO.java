package com.capgemini.wsb.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class MedicalTreatmentTO implements Serializable {

    private Long id;
    private String description;
    private String type;

}
