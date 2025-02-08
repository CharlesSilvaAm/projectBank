package com.vemser.hackaton.dbcbank.rest.model;

import lombok.Data;

import java.util.List;

@Data
public class ContaBancoModel {
    private String accNumber;
    private String branchId;
    private String bankId;
    private double balance;
    private double savingsBalance;
    private int score;
    private String accType;
    private double limiteCreditoMax;
    private double limiteCreditoAtual;
    private double limiteCreditoUsado;
    private List<CartaoModel> card;
    private List<ChavePixRequest> pixKeys;

}
