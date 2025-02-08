package com.vemser.hackaton.dbcbank.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaqueRequest {

    private Integer amount;
    private SenhaCartaoModel[] transactionPwd;
    @JsonIgnore
    private String token;
}
