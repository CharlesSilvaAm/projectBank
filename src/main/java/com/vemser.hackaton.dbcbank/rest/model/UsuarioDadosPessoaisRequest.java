package com.vemser.hackaton.dbcbank.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDadosPessoaisRequest {
    private String name;
    private String birthdate;
    private String phoneNumber;
    private String pronoun;
    private EnderecoModel address;
}
