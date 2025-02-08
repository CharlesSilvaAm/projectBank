package com.vemser.hackaton.dbcbank.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class AlterarLimiteTransacaoRequest {
    private SenhaCartaoModel[] transactionPwd;
    private Integer dailyLimit;
    @JsonIgnore
    private String authToken;
}
