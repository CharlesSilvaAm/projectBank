package com.vemser.hackaton.dbcbank.rest.client;

import com.vemser.hackaton.dbcbank.rest.model.DepositoModel;
import com.vemser.hackaton.dbcbank.rest.model.SaqueRequest;
import com.vemser.hackaton.dbcbank.rest.model.TransferRequest;
import com.vemser.hackaton.dbcbank.rest.model.TransferTEDRequestModel;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TransferenciaClient extends BaseClient {
    private static final String TRANSFERPIX = "/transactions/transfers/pix";
    private static final String DEPOSITO = "/transactions/deposit";
    private static final String HISTORICO_DE_TRANSACOES = "/transactions/history";
    private static final String ENDPOINT_TRANSFER_TED = "/transactions/transfers/eft";
    private static final String HISTORICO_DE_TRANSACOES_DIA = "/transactions/history/transactions-in-a-day";
    private static final String ENDPOINT_TRANSFER_DETAILS = "/transactions/transfers/details";
    private static final String ENDPOINT_TRANSFER_WITHDRAW = "/transactions/withdraw";

    public Response realizarTransferenciaPix(TransferRequest transferenciaRequest, String token) {
        return
            given()
                .spec(set())
                .header("Authorization", "Bearer " + token)
                .body(transferenciaRequest)
            .when()
                .post(TRANSFERPIX)
        ;
    }

    public Response realizarDeposito(DepositoModel deposito, String token) {
        System.out.println("Token obtido: " + token);
        return given()
                .spec(super.set())
                .auth().oauth2(token)
                .body(deposito)
        .when()
                .post(DEPOSITO)
        ;
    }

    public Response pegarHistoricoDeTransacoes(String token, int pagina, int tamanho) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                        .queryParam("page", pagina)
                        .queryParam("size", tamanho)
                .when()
                        .get(HISTORICO_DE_TRANSACOES)
                ;
    }

    public Response pegarHistoricoDiaDeTransacoes(String token, String transactionMethod) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                        .queryParam("transactionMethod", transactionMethod)
                .when()
                        .get(HISTORICO_DE_TRANSACOES_DIA)
                ;
    }

    public Response transferenciaTed(TransferTEDRequestModel transfer, String token){
        return
        given()
                .spec(super.set())
                .header("Authorization", "Bearer " + token)
                .body(transfer)
        .when()
                .post(ENDPOINT_TRANSFER_TED)
        ;
    }

    public Response buscarDetalhesDeTransferencias(String token, String accountNumber, String branchId) {
        return
                given()
                        .spec(super.set())
                        .header("Authorization", "Bearer " + token)
                        .queryParam("accountNumber", accountNumber)
                        .queryParam("branchId", branchId)
                        .when()
                        .get(ENDPOINT_TRANSFER_DETAILS)
                ;
    }

    public static Response realizarSaque(SaqueRequest saque, String token) {
        return
                given()
                        .spec(set())
                        .header("Authorization", "Bearer " + token)
                        .log().all()
                        .body(saque)
                        .when()
                        .post(ENDPOINT_TRANSFER_WITHDRAW)
                ;
    }

}
