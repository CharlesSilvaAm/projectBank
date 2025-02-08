package com.vemser.hackaton.dbcbank.rest.client;

import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.utils.CadastroConstantes;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

public class CadastroClient extends BaseClient{

    public Response realizarCadastro(CadastroRequest usuario){
        return
                given()
                        .spec(super.set())
                        .body(usuario)
                .when()
                        .post(CadastroConstantes.CADASTRO);
    }
}
