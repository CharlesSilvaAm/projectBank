package com.vemser.hackaton.dbcbank.rest.model;

import lombok.Data;

@Data
public class  EnderecoModel {
    private String address;
    private String addressNumber;
    private String addressDetails;
    private String zipCode;
    private String district;
    private String city;
    private String state;
    private String country;
}
