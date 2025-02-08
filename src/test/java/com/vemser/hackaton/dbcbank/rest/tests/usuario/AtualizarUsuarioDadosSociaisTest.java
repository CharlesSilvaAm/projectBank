package com.vemser.hackaton.dbcbank.rest.tests.usuario;

import com.vemser.hackaton.dbcbank.rest.client.UsuarioClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.UsuarioDadosSociaisDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.UsuarioDadosSociaisProvider;
import com.vemser.hackaton.dbcbank.rest.model.UsuarioDadosSociaisRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Usuário")
@Feature("Atualização de Dados Sociais")
public class AtualizarUsuarioDadosSociaisTest {
    UsuarioClient client = new UsuarioClient();

    @Test(dataProvider = "providerAtualizarDadosSociais", dataProviderClass = UsuarioDadosSociaisProvider.class)
    @Story("Usuário atualiza seus dados sociais com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a API permite atualizar os dados sociais do usuário corretamente")
    @Owner("Luiz Henrique")
    public void testDeveAutalizarDadosSociais(UsuarioDadosSociaisRequest usuario, Integer statusCode, String auth) {

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(usuario.toString().getBytes()), "json");

        Response response = client.atualizarDadosSociais(usuario, auth);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then().statusCode(statusCode);
    }

    @Test
    @Story("Validação do schema da resposta ao atualizar dados sociais")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao atualizar os dados sociais do usuário está correto")
    @Owner("Luiz Henrique")
    public void testDeveAtualizarDadosSociaisValidarSchema() {
        UsuarioDadosSociaisRequest usuario = UsuarioDadosSociaisDataFactory.criandoUsuarioDadosSociais();
        String auth = LoginDataFactory.fazerLoginValidoRetornandoToken();

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(usuario.toString().getBytes()), "json");

        Response response = client.atualizarDadosSociais(usuario, auth);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/AtualizarDadosSociaisUsuarioSchema.json"));
    }
}
