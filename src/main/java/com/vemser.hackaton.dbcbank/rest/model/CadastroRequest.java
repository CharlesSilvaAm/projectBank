package com.vemser.hackaton.dbcbank.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CadastroRequest {
    private String name;
    private String document;
    private String phoneNumber;
    private String email;
    private String emailConfirmation;
    private String loginPwd;
    private String loginPwdConfirmation;
    private String transactionPwd;
    private String transactionPwdConfirmation;
    private Boolean consentOpt;
    private String birthdate;
}
