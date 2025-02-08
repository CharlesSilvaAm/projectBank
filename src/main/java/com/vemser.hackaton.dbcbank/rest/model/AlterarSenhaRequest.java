package com.vemser.hackaton.dbcbank.rest.model;

import lombok.Data;

@Data
public class AlterarSenhaRequest {
    private String oldPassword;
    private String newPassword;
    private String newPasswordConfirmation;
    private String token;
}
