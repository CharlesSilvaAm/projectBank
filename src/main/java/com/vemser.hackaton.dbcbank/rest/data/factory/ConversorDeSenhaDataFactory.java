package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.SenhaCartaoModel;

public class ConversorDeSenhaDataFactory {

    public static SenhaCartaoModel[] converterSenhaParaFormatoValido(String password) {
        SenhaCartaoModel[] senhaCartaoModel = new SenhaCartaoModel[password.length()];

        for (int i = 0; i < password.length(); i++) {
            int optionOne = Character.getNumericValue(password.charAt(i));
            senhaCartaoModel[i] = new SenhaCartaoModel(optionOne, 0);
        }

        return senhaCartaoModel;
    }
}
