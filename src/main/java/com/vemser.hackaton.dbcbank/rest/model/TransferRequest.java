package com.vemser.hackaton.dbcbank.rest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TransferRequest {
    private String destinationKey;
    private Integer amount;
    private SenhaCartaoModel[] transactionPwd;
    @JsonIgnore
    private String token;
}

