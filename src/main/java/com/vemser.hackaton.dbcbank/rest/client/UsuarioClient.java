package com.vemser.hackaton.dbcbank.rest.client;

import com.vemser.hackaton.dbcbank.rest.model.UsuarioDadosPessoaisRequest;
import com.vemser.hackaton.dbcbank.rest.model.UsuarioDadosSociaisRequest;
import com.vemser.hackaton.dbcbank.rest.utils.UsuarioConstantes;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsuarioClient extends BaseClient{
    public Response buscarDadosUsuarioPorId(String token){
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                .when()
                        .get(UsuarioConstantes.ENDPOINT_BUSCAR_DADOS_CLIENTE_POR_ID)
                ;
    }

    public Response atualizarDadosSociais(UsuarioDadosSociaisRequest usuarioDadosSociaisRequest, String auth) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + auth)
                        .body(usuarioDadosSociaisRequest)
                .when()
                        .put(UsuarioConstantes.PUT_USUARIO_DADOS_SOCIAIS);
    }

    public Response atualizarDadosPessoais(UsuarioDadosPessoaisRequest usuario, String auth) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + auth)
                        .body(usuario)
                .when()
                        .put(UsuarioConstantes.PUT_USUARIO_DADOS_PESSOAIS);
    }

}
