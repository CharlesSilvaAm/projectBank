package com.vemser.hackaton.dbcbank.rest.tests.autenticacao;

import com.vemser.hackaton.dbcbank.rest.client.CadastroClient;

import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.CadastroProvider;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

import static org.hamcrest.Matchers.equalTo;

@Epic("Autenticação")
@Feature("Cadastro de Usuário")
public class CadastroTest {
    CadastroClient client = new CadastroClient();

    @Test(dataProvider = "providerCadastroUsuario", dataProviderClass = CadastroProvider.class)
    @Story("Usuário realiza cadastro com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o cadastro de usuário ocorre corretamente com dados válidos")
    @Owner("Luiz Henrique")
    public void testDeveCadastrarComSucesso(CadastroRequest usuario, Integer statusCode, String param, String msg) {
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(usuario.toString().getBytes()), "json");

        Response response = client.realizarCadastro(usuario);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(statusCode)
                .body(param, equalTo(msg));
    }

    @Test
    @Story("Validação do schema da resposta ao cadastrar usuário")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao cadastrar usuário está correto")
    @Owner("Luiz Henrique")
    public void testDeveValidarCadastroUsuarioSchemaValidation() {
        CadastroRequest usuario = CadastroDataFactory.usuarioValido();

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(usuario.toString().getBytes()), "json");

        Response response = client.realizarCadastro(usuario);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(201)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/CadastroUsuarioValidoSchema.json"));
    }
}