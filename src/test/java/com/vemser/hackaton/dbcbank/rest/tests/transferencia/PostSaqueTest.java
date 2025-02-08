package com.vemser.hackaton.dbcbank.rest.tests.transferencia;

import com.vemser.hackaton.dbcbank.rest.client.TransferenciaClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.TransferenciaDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.TransferenciaProvider;
import com.vemser.hackaton.dbcbank.rest.model.SaqueRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Transferência")
@Feature("Saque")
public class PostSaqueTest {
    private TransferenciaClient transferenciaClient = new TransferenciaClient();

    @Test(groups = "transfer", dataProvider = "providerSaque", dataProviderClass = TransferenciaProvider.class)
    @Story("Usuário realiza saque com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o saque é realizado corretamente com dados válidos")
    @Owner("Arley Souza")
    public void testDeveRealizarSaque(SaqueRequest saque, Integer statusCode) {

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(saque.toString().getBytes()), "json");
        Response response = transferenciaClient.realizarSaque(saque, saque.getToken());
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then().statusCode(statusCode);
    }

    @Test(groups = "transfer")
    @Story("Validação do schema da resposta ao realizar saque")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao realizar saque está correto")
    @Owner("Arley Souza")
    public void testDeveValidarSaqueSchema() {
        SaqueRequest saque = TransferenciaDataFactory.saqueValido();
        Response response = transferenciaClient.realizarSaque(saque, saque.getToken());
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/SaqueComSucessoSchema.json"));
    }
}