package com.vemser.hackaton.dbcbank.rest.tests.transferencia;

import com.vemser.hackaton.dbcbank.rest.client.TransferenciaClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.TransactionMethodSelector;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Transferência")
@Feature("Histórico de Transferências")
public class GetHistoricoTranferenciaTest {
    private TransferenciaClient transferClient = new TransferenciaClient();
    private String auth;

    @BeforeMethod
    @Step("Preparar ambiente: Cadastrar usuário e obter token de autenticação")
    private void beforeMethod() {
        CadastroRequest cadastro = CadastroDataFactory.cadastrarNovoUsuarioValido();
        LoginRequest login = new LoginRequest(cadastro.getDocument(), cadastro.getLoginPwd());
        auth = LoginDataFactory.pegarAuthToken(login);
        Allure.addAttachment("Token", "text/plain", auth);
    }

    @Test
    @Story("Usuário consulta histórico de transferências por dia com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a consulta do histórico de transferências por dia retorna status code 200")
    @Owner("Luan Prudente")
    public void testDeveMostrarDiasHistoricoTranferenciaComSucesso() {
        String transactionMethod = TransactionMethodSelector.getRandomTransactionMethod();
        Allure.addAttachment("Método de Transação", "text/plain", transactionMethod);
        Response historyResponse = transferClient.pegarHistoricoDiaDeTransacoes(auth, transactionMethod);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(historyResponse.getBody().asByteArray()), "json");
        historyResponse.then().statusCode(200);
    }

    @Test
    @Story("Usuário consulta histórico de transferências com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a consulta do histórico de transferências retorna status code 200")
    @Owner("Luan Prudente")
    public void testDeveMostrarHistoricoTranferenciaComSucesso() {
        int page = 1;
        int size = 10;
        Allure.addAttachment("Página", "text/plain", String.valueOf(page));
        Allure.addAttachment("Tamanho", "text/plain", String.valueOf(size));
        Response historyResponse = transferClient.pegarHistoricoDeTransacoes(auth, page, size);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(historyResponse.getBody().asByteArray()), "json");
        historyResponse.then().statusCode(200);
    }
}