package com.vemser.hackaton.dbcbank.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosDeUsuarioModel {
    private CadastroRequest cadastroRequest;
    private LoginRequest loginRequest;
    private SenhaCartaoModel[] senhaCartao;
    private String auth;

}
