package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.*;

public class LimiteTransacaoDataFactory {

    private static AlterarLimiteTransacaoRequest criarNovoLimiteDiario(){
        AlterarLimiteTransacaoRequest request = new AlterarLimiteTransacaoRequest();
        DadosDeUsuarioModel dados = DadosDeUsuarioDataFactory.gerarDadosDeUsuario();
        request.setTransactionPwd(dados.getSenhaCartao());
        request.setAuthToken(dados.getAuth());
        return request;
    }

    public static AlterarLimiteTransacaoRequest novoLimiteDiarioValido(){
        return criarNovoLimiteDiario();
    }


}
