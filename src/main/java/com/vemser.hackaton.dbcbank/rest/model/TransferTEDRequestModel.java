package com.vemser.hackaton.dbcbank.rest.model;

import lombok.Data;

@Data
public class TransferTEDRequestModel {

    private SenhaCartaoModel[] transactionPwd;
    private String destinationBranchId;
    private String destinationAccNumber;
    private String recipientDocument;
    private String amount;
    private String transactionDescription;

}
