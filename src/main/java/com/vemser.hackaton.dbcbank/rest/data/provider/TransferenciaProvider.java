package com.vemser.hackaton.dbcbank.rest.data.provider;

import com.vemser.hackaton.dbcbank.rest.data.factory.TransferenciaDataFactory;
import org.testng.annotations.DataProvider;

public class TransferenciaProvider {

    @DataProvider(name = "providerPixTransfer")
    public static Object[][] providerPixTransfer() {
        return new Object[][]{
                {TransferenciaDataFactory.transferenciaPixValida(), 200},
                {TransferenciaDataFactory.pixTransferAmountNull(), 400},
                {TransferenciaDataFactory.pixTransferDestinationInvalid(), 400},
                {TransferenciaDataFactory.pixTransferDestinationNull(), 400},
                {TransferenciaDataFactory.pixTransferPwdNull(), 400},
        };
    }
    @DataProvider(name = "providerDeposito")
    public static Object[][] providerDeposito() {
        return new Object[][]{
                {TransferenciaDataFactory.depositoEmContaBancariaAutomatico(), 200},
                {TransferenciaDataFactory.depositoEmContaDocumentoInvalido(), 400},
                {TransferenciaDataFactory.depositoEmContaNumeroDaContaInvalida(), 400},
                {TransferenciaDataFactory.depositoEmContaValorInvalido(), 400},
                {TransferenciaDataFactory.depositoEmContaSenhaInvalida(), 400},
        };
    }
    @DataProvider(name = "providerSaque")
    public static Object[][] providerSaque() {
        return new Object[][]{
                {TransferenciaDataFactory.saqueValido(), 200},
                {TransferenciaDataFactory.saqueValorInvalido(), 400},
                {TransferenciaDataFactory.saqueSenhaInvalida(), 400}

        };
    }
}
