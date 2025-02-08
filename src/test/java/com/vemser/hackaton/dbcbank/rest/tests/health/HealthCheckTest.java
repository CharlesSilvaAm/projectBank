package com.vemser.hackaton.dbcbank.rest.tests.health;

import com.vemser.hackaton.dbcbank.rest.client.HealthCheckClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;

@Epic("Health Check")
@Feature("Verificação de Saúde do Sistema")
public class HealthCheckTest {
    private final HealthCheckClient healthCheckClient = new HealthCheckClient();
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
    @Story("Validação do schema da resposta do Health Check")
    @Severity(SeverityLevel.MINOR)
    @Description("Verifica se o schema da resposta do Health Check está correto")
    @Owner("Cainan Machado")
    public void testDeveValidarHealthCheckSchema() {
        Response response = healthCheckClient.healthCheck(auth);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/HealthCheckSchema.json"));
    }

    @Test
    @Story("Verificação do status do Health Check")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Valida se o Health Check retorna o status 'UP' para todos os componentes")
    @Owner("Cainan Machado")
    public void testDeveVerHealthCheck() {
        Response response = healthCheckClient.healthCheck(auth);
        Allure.addAttachment("Response JSON", "application/json",
                new ByteArrayInputStream(response.getBody().asByteArray()), "json");

        response.then()
                .statusCode(200)
                .body("status", Matchers.equalTo("UP"))
                .body("components.db.status", Matchers.equalTo("UP"))
                .body("components.diskSpace.status", Matchers.equalTo("UP"))
                .body("components.livenessState.status", Matchers.equalTo("UP"))
                .body("components.mail.status", Matchers.equalTo("UP"))
                .body("components.ping.status", Matchers.equalTo("UP"))
                .body("components.readinessState.status", Matchers.equalTo("UP"));
    }
}