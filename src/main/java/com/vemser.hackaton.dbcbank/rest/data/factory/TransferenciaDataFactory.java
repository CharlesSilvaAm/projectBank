package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.*;
import com.vemser.hackaton.dbcbank.rest.utils.Credenciais;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;

import java.util.Properties;

public class TransferenciaDataFactory {

    private static TransferRequest criarNovaTranferenciaPix() {
        TransferRequest pixTransfer = new TransferRequest();
        pixTransfer.setDestinationKey(Credenciais.getDestinationKey());
        DadosDeUsuarioModel dados = DadosDeUsuarioDataFactory.gerarDadosDeUsuario();
        pixTransfer.setAmount(DataFakerGeneration.numeroAleatorioFaker(1, 10000));
        pixTransfer.setToken(dados.getAuth());
        pixTransfer.setTransactionPwd(dados.getSenhaCartao());
        realizarDepositoBancario(dados.getLoginRequest(), dados.getSenhaCartao(), dados.getAuth());
        return pixTransfer;
    }

    public static TransferRequest transferenciaPixValida() {
        return criarNovaTranferenciaPix();
    }

    public static TransferRequest pixTransferDestinationNull() {
        TransferRequest pixTransfer = criarNovaTranferenciaPix();
        pixTransfer.setDestinationKey(null);
        return pixTransfer;
    }

    public static TransferRequest pixTransferPwdNull() {
        TransferRequest pixTransfer = criarNovaTranferenciaPix();
        pixTransfer.setTransactionPwd(null);
        return pixTransfer;
    }

    public static TransferRequest pixTransferAmountNull() {
        TransferRequest pixTransfer = criarNovaTranferenciaPix();
        pixTransfer.setAmount(null);
        return pixTransfer;
    }

    public static TransferRequest pixTransferDestinationInvalid() {
        TransferRequest pixTransfer = criarNovaTranferenciaPix();
        pixTransfer.setDestinationKey(DataFakerGeneration.cpfValidoFaker());
        return pixTransfer;
    }

    public static DepositoModel depositoEmContaBancariaAutomatico() {
        return realizarDepositoBancarioAutomatico();
    }

    private static DepositoModel realizarDepositoBancario(LoginRequest loginRequest, SenhaCartaoModel[] senha, String auth) {
        DepositoModel depositoConta = new DepositoModel();
        depositoConta.setDocument(loginRequest.getUsername());
        String numeroConta = UsuarioDataFactory.pegarDadosUsuario(loginRequest).getBankAccount().getAccNumber();
        depositoConta.setAccNumber(numeroConta);
        depositoConta.setAmount(10000);
        depositoConta.setTransactionPwd(senha);
        depositoConta.setToken(auth);
        return depositoConta;
    }

    private static DepositoModel realizarDepositoBancarioAutomatico() {
        DepositoModel depositoConta = new DepositoModel();
        DadosDeUsuarioModel dados = DadosDeUsuarioDataFactory.gerarDadosDeUsuario();
        depositoConta.setDocument(dados.getLoginRequest().getUsername());
        String numeroConta = UsuarioDataFactory.pegarDadosUsuario(dados.getLoginRequest()).getBankAccount().getAccNumber();
        depositoConta.setAccNumber(numeroConta);
        depositoConta.setAmount(10000);
        depositoConta.setTransactionPwd(dados.getSenhaCartao());
        depositoConta.setToken(dados.getAuth());
        return depositoConta;
    }

    public static DepositoModel depositoEmContaDocumentoInvalido() {
        DepositoModel depositoConta = realizarDepositoBancarioAutomatico();
        depositoConta.setDocument("01");
        return depositoConta;
    }

    public static DepositoModel depositoEmContaNumeroDaContaInvalida() {
        DepositoModel depositoConta = realizarDepositoBancarioAutomatico();
        depositoConta.setAccNumber(DataFakerGeneration.cpfValidoFaker());
        return depositoConta;
    }

    public static DepositoModel depositoEmContaValorInvalido() {
        DepositoModel depositoConta = realizarDepositoBancarioAutomatico();
        depositoConta.setAmount(1000000000);
        return depositoConta;
    }

    public static DepositoModel depositoEmContaSenhaInvalida() {
        DepositoModel depositoConta = realizarDepositoBancarioAutomatico();
        depositoConta.setTransactionPwd(null);
        return depositoConta;
    }


    private static SaqueRequest criarNovoSaque() {
        SaqueRequest saque = new SaqueRequest();
        saque.setAmount(DataFakerGeneration.numeroAleatorioFaker(1, 1000));
        DadosDeUsuarioModel dados = DadosDeUsuarioDataFactory.gerarDadosDeUsuario();
        saque.setTransactionPwd(dados.getSenhaCartao());
        saque.setToken(dados.getAuth());
        return saque;
    }

    public static SaqueRequest saqueValido() {
        return criarNovoSaque();
    }

    public static SaqueRequest saqueValorInvalido() {
        SaqueRequest saque = criarNovoSaque();
        saque.setAmount(10000000);
        return saque;
    }

    public static SaqueRequest saqueSenhaInvalida() {
        SaqueRequest saque = criarNovoSaque();
        saque.setTransactionPwd(null);
        return saque;
    }



    public static TransferTEDRequestModel novaTransferTed(){
        UsuarioResponse usuarioSecundario = UsuarioDataFactory.pegarDadosUsuario(LoginDataFactory.loginUsuarioFixo());
        Properties props = Credenciais.getProp();
        String senhaCartao = props.getProperty("senhaCartao");

        TransferTEDRequestModel transferTed = new TransferTEDRequestModel();
        transferTed.setDestinationBranchId(usuarioSecundario.getBankAccount().getBranchId());
        transferTed.setAmount(String.valueOf(200));
        transferTed.setDestinationAccNumber(usuarioSecundario.getBankAccount().getAccNumber());
        transferTed.setRecipientDocument(usuarioSecundario.getDocument());
        transferTed.setTransactionPwd(ConversorDeSenhaDataFactory.converterSenhaParaFormatoValido(senhaCartao));
        return transferTed;
    }


}
