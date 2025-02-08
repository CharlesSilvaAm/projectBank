package com.vemser.hackaton.dbcbank.rest.data.provider;

import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.UsuarioDadosPessoaisDataFactory;
import org.testng.annotations.DataProvider;

public class UsuarioDadosPessoaisProvider {

    @DataProvider(name = "providerAtualizarDadosPessoais")
    public static Object[][] providerAtualizarDadosPessoais() {
        return new Object[][]{
                {UsuarioDadosPessoaisDataFactory.dadosPessoaisValidos(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosPessoaisDataFactory.usuarioSemNome(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosPessoaisDataFactory.usuarioSemTelefone(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosPessoaisDataFactory.usuarioSemDataNascimento(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosPessoaisDataFactory.usuarioSemPronome(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosPessoaisDataFactory.usuarioSemEndereco(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()}
        };
    }
}
