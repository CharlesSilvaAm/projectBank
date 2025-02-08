package com.vemser.hackaton.dbcbank.rest.tests.chavepix;

import com.vemser.hackaton.dbcbank.rest.client.ChavePixClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.ChavePixDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.ChavePixProvider;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Chave Pix")
@Feature("Exclusão de Chave Pix")
public class DeleteChavePixTest {
    ChavePixClient pixClient = new ChavePixClient();

    @BeforeGroups("delete")
    @Step("Criar chaves Pix para exclusão")
    public void createKeysToDelete() {
        ChavePixDataFactory.createPixKeys();
    }

    @Test(dataProvider = "deletePixKeyData", dataProviderClass = ChavePixProvider.class, groups = "delete")
    @Story("Usuário deleta chave Pix com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a exclusão de uma chave Pix ocorre corretamente com dados válidos")
    @Owner("Cainan Machado")
    public void testDeveDeletarChavePix(String key, String token, Integer statusCode, String expectedBodyKey, String expectedResponse) {
        Allure.addAttachment("Token", "text/plain", token);
        Allure.addAttachment("Chave Pix", "text/plain", key);

        Response response = pixClient.deletePixKey(key, token);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(statusCode);

        if (!expectedBodyKey.isEmpty()) {
            Assert.assertTrue(response.getBody().asString().toLowerCase().contains(expectedResponse.toLowerCase()),
                    "O corpo da resposta não contém a mensagem esperada: " + expectedResponse);
        }
    }
}