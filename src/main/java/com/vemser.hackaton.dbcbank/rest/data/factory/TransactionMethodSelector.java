package com.vemser.hackaton.dbcbank.rest.data.factory;

import java.util.Random;

public class TransactionMethodSelector {

    private static final String[] transactionMethods = {
            "Saque",
            "Depósito em conta",
            "Transferência Eletrônica",
            "Transferência por PIX"
    };

    public static String getRandomTransactionMethod() {
        Random random = new Random();
        return transactionMethods[random.nextInt(transactionMethods.length)];
    }
}

