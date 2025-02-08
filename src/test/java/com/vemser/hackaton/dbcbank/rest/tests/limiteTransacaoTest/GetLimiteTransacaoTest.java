package com.vemser.hackaton.dbcbank.rest.tests.limiteTransacaoTest;

import com.vemser.hackaton.dbcbank.rest.client.LimiteTransacaoClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LimiteTransacaoDataFactory;
import com.vemser.hackaton.dbcbank.rest.model.AlterarLimiteTransacaoRequest;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Limite de Transação")
@Feature("Consulta de Limite de Transação")
public class GetLimiteTransacaoTest {
    private LimiteTransacaoClient client = new LimiteTransacaoClient();
    private AlterarLimiteTransacaoRequest dailyLimit;

    @BeforeMethod
    @Step("Preparar ambiente: Definir dados para consulta de limite de transação")
    private void definirDados() {
        dailyLimit = LimiteTransacaoDataFactory.novoLimiteDiarioValido();

        Allure.addAttachment("Token", "text/plain", dailyLimit.getAuthToken());
    }

    @Test
    @Story("Usuário consulta limite de transação com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a consulta de limite de transação retorna status code 200")
    @Owner("Lucas Larry")
    public void testDevePegarLimiteDeTransacaoComSucesso() {
        Response response = client.pegarLimiteDiario(dailyLimit.getAuthToken());

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200);
    }
}