package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.client.UsuarioClient;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import com.vemser.hackaton.dbcbank.rest.model.UsuarioResponse;

import static java.lang.String.valueOf;

public class UsuarioDataFactory {

    static UsuarioClient usuarioClient = new UsuarioClient();

    public static UsuarioResponse pegarDadosUsuario(LoginRequest login) {
        UsuarioResponse response =
        usuarioClient.buscarDadosUsuarioPorId(LoginDataFactory.pegarAuthToken(login))
        .then()
                .extract().as(UsuarioResponse.class);
        String documento = response.getDocument();
        String contaBancaria = String.valueOf(response.getBankAccount());

        ;
        return response;
    }


}
