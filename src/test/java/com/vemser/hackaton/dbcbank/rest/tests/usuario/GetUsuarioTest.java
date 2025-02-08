package com.vemser.hackaton.dbcbank.rest.tests.usuario;

import com.vemser.hackaton.dbcbank.rest.client.UsuarioClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Usuário")
@Feature("Consulta de Usuário")
public class GetUsuarioTest {

    UsuarioClient usuarioClient = new UsuarioClient();
    private String auth;

    @BeforeMethod
    private void beforeMethod() {
        CadastroRequest cadastro = CadastroDataFactory.cadastrarNovoUsuarioValido();
        LoginRequest login = new LoginRequest(cadastro.getDocument(), cadastro.getLoginPwd());
        auth = LoginDataFactory.pegarAuthToken(login);
    }

    @Test
    @Story("Buscar usuário por ID com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a API retorna os dados corretos ao buscar um usuário por ID")
    @Owner("Cainan Machado")
    public void testDeveBuscarUsuarioPorIdComSucesso() {

        Response response = usuarioClient.buscarDadosUsuarioPorId(auth);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then().statusCode(200);
    }
}
