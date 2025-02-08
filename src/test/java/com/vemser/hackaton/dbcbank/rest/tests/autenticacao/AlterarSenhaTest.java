package com.vemser.hackaton.dbcbank.rest.tests.autenticacao;

import com.vemser.hackaton.dbcbank.rest.client.AlterarSenhaClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.AlterarSenhaDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.AlterarSenhaProvider;
import com.vemser.hackaton.dbcbank.rest.model.AlterarSenhaRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import jdk.jfr.Label;
import org.testng.annotations.Test;
import java.io.ByteArrayInputStream;

import static org.hamcrest.Matchers.equalTo;

@Epic("Autenticação")
@Feature("Alteração de Senha")
public class AlterarSenhaTest {
    AlterarSenhaClient alterarClient = new AlterarSenhaClient();

    @Test(dataProvider = "providerAlterarSenhaValida", dataProviderClass = AlterarSenhaProvider.class)
    @Story("Usuário altera senha com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a alteração de senha ocorre corretamente com dados válidos")
    @Label("regressao")
    @Owner("Isabele Torres")
    public void testTeveAlterarSenhaComSucesso(AlterarSenhaRequest alterar, Integer statusCode){
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(alterar.toString().getBytes()), "json");

        Response response = alterarClient.alterarSenha(alterar, alterar.getToken());

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then().statusCode(statusCode);
    }

    @Test(dataProvider = "providerAlterarSenhaInvalida", dataProviderClass = AlterarSenhaProvider.class)
    @Story("Usuário tenta alterar senha com dados inválidos")
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida se a API retorna erro ao tentar alterar senha com dados inválidos")
    @Label("regressao")
    @Owner("Isabele Torres")
    public void testTentarAlterarSenha(AlterarSenhaRequest alterar, Integer statusCode, String campo, String message){
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(alterar.toString().getBytes()), "json");

        Response response = alterarClient.alterarSenha(alterar, alterar.getToken());

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(statusCode)
                .body(campo, equalTo(message));
    }

    @Test
    @Story("Validação do schema da resposta ao alterar senha")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao alterar senha está correto")
    @Label("schema")
    @Owner("Isabele Torres")
    public void testDeveAlterarSenhaComSucessoSchema(){
        AlterarSenhaRequest alterarSenhaRequest = AlterarSenhaDataFactory.alterarSenhaValida();

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(alterarSenhaRequest.toString().getBytes()), "json");

        Response response = alterarClient.alterarSenha(alterarSenhaRequest, alterarSenhaRequest.getToken());

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/AlterarSenhaSchema.json"));
    }
}