package com.vemser.hackaton.dbcbank.rest.tests.usuario;

import com.vemser.hackaton.dbcbank.rest.client.UsuarioClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.UsuarioDadosPessoaisDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.UsuarioDadosPessoaisProvider;
import com.vemser.hackaton.dbcbank.rest.model.UsuarioDadosPessoaisRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Usuário")
@Feature("Atualização de Dados Pessoais")
public class AtualizarUsuarioDadosPessoaisTest {
    UsuarioClient client = new UsuarioClient();

    @Test(dataProvider = "providerAtualizarDadosPessoais", dataProviderClass = UsuarioDadosPessoaisProvider.class)
    @Story("Usuário atualiza seus dados pessoais com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a API permite atualizar os dados pessoais do usuário corretamente")
    @Owner("Luiz Henrique")
    public void testDeveAtualizarUsuarioDadosPessoais(UsuarioDadosPessoaisRequest usuario, Integer statusCode, String auth) {

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(usuario.toString().getBytes()), "json");

        Response response = client.atualizarDadosPessoais(usuario, auth);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then().statusCode(statusCode);
    }

    @Test
    @Story("Validação do schema da resposta ao atualizar dados pessoais")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao atualizar os dados pessoais do usuário está correto")
    @Owner("Luiz Henrique")
    public void testDeveAtualizarUsuarioDadosPessoaisSchemaValidator() {
        UsuarioDadosPessoaisRequest usuario = UsuarioDadosPessoaisDataFactory.dadosPessoaisValidos();
        String auth = LoginDataFactory.fazerLoginValidoRetornandoToken();

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(usuario.toString().getBytes()), "json");

        Response response = client.atualizarDadosPessoais(usuario, auth);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/AtualizarDadosPessoaisUsuarioSchema.json"));
    }
}
