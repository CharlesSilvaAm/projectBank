package com.vemser.hackaton.dbcbank.rest.tests.limiteTransacaoTest;

import com.vemser.hackaton.dbcbank.rest.client.LimiteTransacaoClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LimiteTransacaoDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.LimiteTransacaoProvider;
import com.vemser.hackaton.dbcbank.rest.model.AlterarLimiteTransacaoRequest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Limite de Transação")
@Feature("Alteração de Limite de Transação")
public class PostLimiteTransacaoTest {
    private LimiteTransacaoClient client = new LimiteTransacaoClient();
    private AlterarLimiteTransacaoRequest dailyLimit;

    @BeforeMethod
    @Step("Preparar ambiente: Definir dados para alteração de limite de transação")
    private void definirDados() {
        dailyLimit = LimiteTransacaoDataFactory.novoLimiteDiarioValido();
        Allure.addAttachment("Token", "text/plain", dailyLimit.getAuthToken());
    }

    @Test(dataProvider = "maxMinDailyLimits", dataProviderClass = LimiteTransacaoProvider.class)
    @Story("Usuário altera limite de transação com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a alteração de limite de transação ocorre corretamente com dados válidos")
    @Owner("Lucas Larry")
    public void testDeveAlterarLimiteDeTransacaoComSucesso(Integer dailyLimitAmount, int httpCode) {
        dailyLimit.setDailyLimit(dailyLimitAmount);
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(dailyLimit.toString().getBytes()), "json");
        Response response = client.alterarLimiteDiario(dailyLimit, dailyLimit.getAuthToken());
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .statusCode(httpCode);
    }

    @Test(dataProvider = "invalidDailyLimits", dataProviderClass = LimiteTransacaoProvider.class)
    @Story("Usuário tenta alterar limite de transação com dados inválidos")
    @Severity(SeverityLevel.NORMAL)
    @Description("Valida se a API retorna erro ao tentar alterar limite de transação com dados inválidos")
    @Owner("Lucas Larry")
    public void testTentarAlterarLimiteDeTransacaoComDadosInvalidos(Integer dailyLimitAmount, int httpCode) {
        dailyLimit.setDailyLimit(dailyLimitAmount);
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(dailyLimit.toString().getBytes()), "json");
        Response response = client.alterarLimiteDiario(dailyLimit, dailyLimit.getAuthToken());
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .statusCode(httpCode);
    }

    @Test
    @Story("Usuário reseta limite de transação com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o reset do limite de transação ocorre corretamente")
    @Owner("Lucas Larry")
    public void testDeveResetarLimiteDeTransacaoComSucesso() {
        Response response = client.resetarLimiteDiario(dailyLimit.getAuthToken());
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .statusCode(200);
    }
}