package com.vemser.hackaton.dbcbank.rest.client;

import com.vemser.hackaton.dbcbank.rest.model.AlterarSenhaRequest;
import com.vemser.hackaton.dbcbank.rest.utils.AlterarSenhaConstants;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AlterarSenhaClient extends BaseClient{
    public Response alterarSenha(AlterarSenhaRequest alterar, String token){
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                        .body(alterar)
                .when()
                        .post(AlterarSenhaConstants.ENDEPOINT_ALTERAR_SENHA)
                ;
    }
}
