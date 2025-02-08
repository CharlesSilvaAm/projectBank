package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.client.LoginClient;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import com.vemser.hackaton.dbcbank.rest.utils.Credenciais;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;
import io.restassured.response.Response;

import java.util.Properties;

public class LoginDataFactory {
    static LoginClient loginClient = new LoginClient();

    public static LoginRequest loginValido() {
        return novoLogin();
    }

    private static LoginRequest novoLogin() {
        LoginRequest loginRequest = new LoginRequest();
        CadastroRequest usuario = CadastroDataFactory.cadastrarNovoUsuarioValido();
        loginRequest.setUsername(usuario.getDocument());
        loginRequest.setPassword(usuario.getLoginPwd());
        return loginRequest;
    }

    public static LoginRequest loginComSenhaInvalida(){
        LoginRequest login = loginValido();
        login.setPassword(DataFakerGeneration.senhaFaker());
        return login;
    }

    public static LoginRequest loginComUsernameInvalido() {
        LoginRequest login = loginValido();;
        login.setUsername("12345678910");
        return login;
    }

    public static LoginRequest loginUsuarioFixo(){
        LoginRequest login = new LoginRequest();
        Properties props = Credenciais.getProp();
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        login.setUsername(username);
        login.setPassword(password);
        return login;
    }

    public static String pegarAuthToken(LoginRequest login){
        Response response =
                loginClient.realizarLogin(login)
                        .then()
                        .extract().response()
                ;
        return response.path("token");
    }

    public static String pegarAuthTokenUsuarioFixo(){
        LoginRequest loginRequest = loginUsuarioFixo();
        Response response =
                loginClient.realizarLogin(loginRequest)
                        .then()
                        .extract().response()
                ;
        return response.path("token");
    }

    public static String fazerLoginValidoRetornandoToken(){
        CadastroRequest cadastroRequest = CadastroDataFactory.cadastrarNovoUsuarioValido();
        LoginRequest novoLogin = new LoginRequest(cadastroRequest.getDocument(),cadastroRequest.getLoginPwd());
        Response response =
                loginClient.realizarLogin(novoLogin)
                        .then()
                        .extract().response();

        return response.path("token");
    }

}
