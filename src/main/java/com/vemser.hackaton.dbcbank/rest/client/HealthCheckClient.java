package com.vemser.hackaton.dbcbank.rest.client;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class HealthCheckClient extends BaseClient{

    private String ENDPOINT_HEALTH_CHECK = "actuator/health";

    public Response healthCheck(String token){
        return
        given()
                .spec(super.set())
                .auth().oauth2(token)
        .when()
                .get(ENDPOINT_HEALTH_CHECK);
    }

}
