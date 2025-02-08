package com.vemser.hackaton.dbcbank.rest.client;


import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import com.vemser.hackaton.dbcbank.rest.utils.LoginConstants;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class LoginClient extends BaseClient {

    public Response realizarLogin(LoginRequest loginRequest) {

        return
                given()
                        .spec(set())
                        .body(loginRequest)
                .when()
                        .post(LoginConstants.ENDPOINT_LOGIN)
                ;
    }
}