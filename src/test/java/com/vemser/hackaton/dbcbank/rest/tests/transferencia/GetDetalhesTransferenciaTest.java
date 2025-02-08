package com.vemser.hackaton.dbcbank.rest.tests.transferencia;
import com.vemser.hackaton.dbcbank.rest.client.TransferenciaClient;
import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetDetalhesTransferenciaTest {


    private TransferenciaClient transferenciaClient = new TransferenciaClient();
    private String auth;

    @BeforeMethod(groups = "transfer")
    @Owner("Arley Souza")
    private void beforeMethod() {
        CadastroRequest cadastro = CadastroDataFactory.cadastrarNovoUsuarioValido();
        LoginRequest login = new LoginRequest(cadastro.getDocument(),cadastro.getLoginPwd());
        auth = LoginDataFactory.pegarAuthToken(login);
    }

    @Test(groups = "transfer")
    public void testDetalhesDeTranferenciaComSucesso() {
        String accountNumber = "64438-2";
        String  branchId = "0001";
        Response historyResponse = transferenciaClient.buscarDetalhesDeTransferencias(auth, accountNumber, branchId);

        historyResponse.then().statusCode(200);

    }
}

