package com.vemser.hackaton.dbcbank.rest.client;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseClient {
    private static final String BASE_URI = "https://testathon-dbcbank-back-time1-vs2.onrender.com/dbc-bank/v1";

    public static RequestSpecification set(){

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .setConfig(RestAssured.config().logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .build();
    }
}
