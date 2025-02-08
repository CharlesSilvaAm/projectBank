package com.vemser.hackaton.dbcbank.rest.client;

import com.vemser.hackaton.dbcbank.rest.model.ChavePixRequest;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ChavePixClient extends BaseClient{
    private String ENDPOINT_CRIAR_CHAVE_PIX = "accounts/pix/key";
    private String ENDPOINT_BUSCAR_CHAVE_PIX = "accounts/pix/keys";
    private String ENDPOINT_DELETAR_CHAVE_PIX = "accounts/pix/keys/{key}";

    public Response createPixKey(ChavePixRequest pixTypeRequestModel, String token){
        return
                given()
                        .spec(super.set())
                        .header("Authorization","Bearer " +  token)
                        .body(pixTypeRequestModel)
                .when()
                        .post(ENDPOINT_CRIAR_CHAVE_PIX)
                ;
    }

    public Response buscarChavePix(String token){
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                .when()
                        .get(ENDPOINT_BUSCAR_CHAVE_PIX)
                ;
    }

    public Response deletePixKey(String chave, String token){
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                        .pathParam("key", chave)
                .when()
                        .delete(ENDPOINT_DELETAR_CHAVE_PIX)
                ;
    }

}
