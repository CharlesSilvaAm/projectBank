package com.vemser.hackaton.dbcbank.rest.tests.autenticacao;

import com.vemser.hackaton.dbcbank.rest.client.LoginClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.LoginProvider;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.Matchers.equalTo;

@Epic("Autenticação")
@Feature("Login de Usuário")
public class LoginTest {
    LoginClient loginClient = new LoginClient();

    @Test(dataProvider = "providerLoginUsuarioInvalido", dataProviderClass = LoginProvider.class)
    @Story("Usuário tenta realizar login com credenciais inválidas")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a API retorna erro ao tentar realizar login com credenciais inválidas")
    @Owner("Isabele Torres")
    public void testDeveRealizarLoginInvalido(LoginRequest login, Integer statusCode, String campo, String message) {
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(login.toString().getBytes()), "json");

        Response response = loginClient.realizarLogin(login);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(statusCode)
                .body(campo, equalTo(message));
    }

    @Test
    @Story("Validação do schema da resposta ao realizar login com sucesso")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao realizar login está correto")
    @Owner("Isabele Torres")
    public void testDeveValidarLoginValidoSchemaComSucesso() {
        LoginRequest loginRequest = LoginDataFactory.loginValido();

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(loginRequest.toString().getBytes()), "json");

        Response response = loginClient.realizarLogin(loginRequest);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/LoginSchema.json"));
    }

    @Test(dataProvider = "providerLoginUsuarioValido", dataProviderClass = LoginProvider.class)
    @Story("Usuário realiza login com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o login é realizado com sucesso ao usar credenciais válidas")
    @Owner("Isabele Torres")
    public void testDeveRealizarLoginValidoComSucesso(LoginRequest login, Integer statusCode) {
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(login.toString().getBytes()), "json");

        Response response = loginClient.realizarLogin(login);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(statusCode);
    }
}