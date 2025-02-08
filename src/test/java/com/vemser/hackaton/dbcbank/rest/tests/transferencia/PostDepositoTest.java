package com.vemser.hackaton.dbcbank.rest.tests.transferencia;

import com.vemser.hackaton.dbcbank.rest.client.BaseClient;
import com.vemser.hackaton.dbcbank.rest.client.TransferenciaClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.TransferenciaProvider;
import com.vemser.hackaton.dbcbank.rest.model.DepositoModel;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Transferência")
@Feature("Depósito")
public class PostDepositoTest extends BaseClient {

    TransferenciaClient transferenciaClient = new TransferenciaClient();

    @Test(dataProvider = "providerDeposito", dataProviderClass = TransferenciaProvider.class)
    @Story("Usuário realiza um depósito com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se um depósito é realizado corretamente com dados válidos")
    @Owner("Arley Souza")
    public void testDeveRealizarUmDepositoComSucesso(DepositoModel deposito, Integer statusCode) {

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(deposito.toString().getBytes()), "json");

        Response response = transferenciaClient.realizarDeposito(deposito, deposito.getToken());

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then().statusCode(statusCode);
    }
}
