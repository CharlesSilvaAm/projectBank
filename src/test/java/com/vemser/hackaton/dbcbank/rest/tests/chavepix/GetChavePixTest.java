package com.vemser.hackaton.dbcbank.rest.tests.chavepix;

import com.vemser.hackaton.dbcbank.rest.client.ChavePixClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Chave Pix")
@Feature("Consulta de Chave Pix")
public class GetChavePixTest {
    ChavePixClient pixClient = new ChavePixClient();

    @Test
    @Story("Usuário busca chave Pix com sucesso")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se a consulta de chave Pix retorna status code 200 e os dados esperados")
    @Owner("Cainan Machado")
    public void testDeveBuscarChavePix() {
        String authToken = LoginDataFactory.pegarAuthToken(LoginDataFactory.loginUsuarioFixo());
        Allure.addAttachment("Token", "text/plain", authToken);
        Response response = pixClient.buscarChavePix(authToken);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");
        response.then()
                .statusCode(200);
    }

    @Test
    @Story("Validação do schema da resposta ao buscar chave Pix")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta ao buscar chave Pix está correto")
    @Owner("Cainan Machado")
    public void testDeveValidarBuscarChavePixSchema() {
        String authToken = LoginDataFactory.pegarAuthToken(LoginDataFactory.loginUsuarioFixo());

        Allure.addAttachment("Token", "text/plain", authToken);

        Response response = pixClient.buscarChavePix(authToken);

        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/PegarChavePixSchema.json"));
    }
}