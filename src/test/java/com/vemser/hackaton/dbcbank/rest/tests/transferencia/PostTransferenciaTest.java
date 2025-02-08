package com.vemser.hackaton.dbcbank.rest.tests.transferencia;

import com.vemser.hackaton.dbcbank.rest.client.TransferenciaClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.TransferenciaDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.TransferenciaProvider;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import com.vemser.hackaton.dbcbank.rest.model.TransferRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Transferência")
@Feature("Transferências PIX e TED")
public class PostTransferenciaTest {
    private TransferenciaClient transferenciaClient = new TransferenciaClient();
    private String auth;

    @BeforeGroups(groups = "Transfer")
    @Step("Cadastrando e autenticando usuário para transferências")
    private void beforeMethod() {
        CadastroRequest cadastro = CadastroDataFactory.cadastrarNovoUsuarioValido();
        LoginRequest login = new LoginRequest(cadastro.getDocument(), cadastro.getLoginPwd());
        auth = LoginDataFactory.pegarAuthToken(login);
    }

    @Test(dataProvider = "providerPixTransfer", dataProviderClass = TransferenciaProvider.class, groups = "Transfer")
    @Story("Usuário realiza transferência via PIX com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a API permite realizar uma transferência PIX com sucesso")
    @Owner("Luan Prudente")
    public void testDeveRealizarTransferenciaPixComSucesso(TransferRequest transfer, Integer statusCode) {

        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(transfer.toString().getBytes()), "json");

        Response transferResponse = transferenciaClient.realizarTransferenciaPix(transfer, auth);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(transferResponse.getBody().asByteArray()), "json");

        transferResponse.then().statusCode(statusCode);
    }

    @Test
    @Story("Validação do schema da resposta da transferência TED")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta de uma transferência TED está correto")
    @Owner("Cainan Machado")
    public void testDeveValidarTransferenciaTedSchema() {
        Response response = transferenciaClient.transferenciaTed(TransferenciaDataFactory.novaTransferTed(),
                LoginDataFactory.pegarAuthToken(LoginDataFactory.loginUsuarioFixo()));

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/TransferenciaTedSchema.json"));
    }

    @Test
    @Story("Usuário realiza transferência via TED com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a API permite realizar uma transferência TED com sucesso")
    @Owner("Cainan Machado")
    public void testDeveRealizarTransferenciaTedComSucesso() {
        Response response = transferenciaClient.transferenciaTed(TransferenciaDataFactory.novaTransferTed(),
                LoginDataFactory.pegarAuthToken(LoginDataFactory.loginUsuarioFixo()));

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then().statusCode(200);
    }
}
