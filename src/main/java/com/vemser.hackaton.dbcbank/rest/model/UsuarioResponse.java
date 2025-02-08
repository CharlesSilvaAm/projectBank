package com.vemser.hackaton.dbcbank.rest.model;

import lombok.Data;

import java.util.List;

@Data
public class UsuarioResponse {
    private String name;
    private String document;
    private String birthdate;
    private String pronoun;
    private String email;
    private String phoneNumber;
    private String gender;
    private String selfDeclaredRace;
    private boolean isPcd;
    private String pcdDescription;
    private String educationalLevel;
    private String occupation;
    private String monthlyIncome;
    private String jobExperience;
    private String workType;
    private List<EnderecoModel> address;
    private ContaBancoModel bankAccount;
    private UserModel user;

}
