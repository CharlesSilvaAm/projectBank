package com.vemser.hackaton.dbcbank.rest.client;

import com.vemser.hackaton.dbcbank.rest.model.AlterarLimiteTransacaoRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LimiteTransacaoClient extends BaseClient {
    private final String LIMIT_TRANSACTION = "accounts/daily-limit";
    private final String RESET_LIMIT_TRANSACTION = "accounts/daily-limit/reset";

    public Response alterarLimiteDiario(AlterarLimiteTransacaoRequest alterarLimiteDiarioRequest, String token) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " +token)
                        .body(alterarLimiteDiarioRequest)
                .when()
                        .post(LIMIT_TRANSACTION)
                ;
    }

    public Response resetarLimiteDiario(String token) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                .when()
                        .post(RESET_LIMIT_TRANSACTION)
                ;
    }

    public Response pegarLimiteDiario(String token) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                .when()
                        .get(LIMIT_TRANSACTION)
                ;
    }
}
