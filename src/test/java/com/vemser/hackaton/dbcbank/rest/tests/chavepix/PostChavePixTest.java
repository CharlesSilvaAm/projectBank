package com.vemser.hackaton.dbcbank.rest.tests.chavepix;

import com.vemser.hackaton.dbcbank.rest.client.ChavePixClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.ChavePixDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.provider.ChavePixProvider;
import com.vemser.hackaton.dbcbank.rest.model.ChavePixRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Chave Pix")
@Feature("Criação de Chave Pix")
public class PostChavePixTest {
    private ChavePixClient pixClient = new ChavePixClient();

    @BeforeMethod
    @Step("Excluir chaves Pix existentes antes da criação")
    public void deletePixKeys() {
        ChavePixDataFactory.deletePixKeys();
    }

    @Test
    @Story("Validação do schema da resposta ao criar chave Pix")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao criar chave Pix está correto")
    @Owner("Cainan Machado")
    public void testDeveValidarCriarChavePixSchema() {
        String authToken = LoginDataFactory.pegarAuthToken(LoginDataFactory.loginUsuarioFixo());

        Allure.addAttachment("Token", "text/plain", authToken);

        Response response = pixClient.createPixKey(ChavePixDataFactory.pixKeyCpf(), authToken);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/CriarChavePixSchema.json"));
    }

    @Test(dataProvider = "createPixKeyData", dataProviderClass = ChavePixProvider.class)
    @Story("Usuário cria chave Pix com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a criação de chave Pix ocorre corretamente com dados válidos")
    @Owner("Cainan Machado")
    public void testDeveCriarChavePix(ChavePixRequest pixTypeRequestModel, String token, Integer statusCode, String expectedBodyKey, String expectedResponse) {
        Allure.addAttachment("Token", "text/plain", token);
        Allure.addAttachment("Request JSON", "application/json",
                new ByteArrayInputStream(pixTypeRequestModel.toString().getBytes()), "json");

        Response response = pixClient.createPixKey(pixTypeRequestModel, token);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .statusCode(statusCode)
                .body(expectedBodyKey, Matchers.containsStringIgnoringCase(expectedResponse));
    }
}