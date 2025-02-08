package com.vemser.hackaton.dbcbank.rest.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepositoModel {
    private String document;
    private String accNumber;
    private int  amount;
    private SenhaCartaoModel[] transactionPwd;
    @JsonIgnore
    private String token;
}
