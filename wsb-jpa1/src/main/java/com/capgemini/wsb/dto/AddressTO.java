package com.capgemini.wsb.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class AddressTO implements Serializable {

    private Long id;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;

}
