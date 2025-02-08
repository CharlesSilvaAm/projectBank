package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.DadosDeUsuarioModel;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import com.vemser.hackaton.dbcbank.rest.model.SenhaCartaoModel;

public class DadosDeUsuarioDataFactory {
    public static DadosDeUsuarioModel gerarDadosDeUsuario() {
        DadosDeUsuarioModel dadosDeUsuario = new DadosDeUsuarioModel();
        CadastroRequest cadastro = CadastroDataFactory.cadastrarNovoUsuarioValido();
        LoginRequest login = new LoginRequest(cadastro.getDocument(),cadastro.getLoginPwd());
        String auth = LoginDataFactory.pegarAuthToken(login);
        SenhaCartaoModel[] senhaCartaoModel = ConversorDeSenhaDataFactory.converterSenhaParaFormatoValido(cadastro.getTransactionPwd());
        dadosDeUsuario.setCadastroRequest(cadastro);
        dadosDeUsuario.setLoginRequest(login);
        dadosDeUsuario.setAuth(auth);
        dadosDeUsuario.setSenhaCartao(senhaCartaoModel);
        return dadosDeUsuario;
    }
}
