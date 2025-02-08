package com.vemser.hackaton.dbcbank.rest.data.provider;

import com.vemser.hackaton.dbcbank.rest.data.factory.AlterarSenhaDataFactory;
import com.vemser.hackaton.dbcbank.rest.utils.AlterarSenhaConstants;
import org.testng.annotations.DataProvider;

public class AlterarSenhaProvider {
    @DataProvider(name = "providerAlterarSenhaValida")
    public static Object[][] providerAlterarSenhaValida() {
        return new Object[][]{
                {AlterarSenhaDataFactory.alterarSenhaValida(), 200 },
        };
    }

    @DataProvider(name = "providerAlterarSenhaInvalida")
    public static Object[][] providerAlterarSenhaInvalida() {
        return new Object[][]{
                {AlterarSenhaDataFactory.alteraSenhaComOldPasswordVazio(), 400, "fieldErrors.oldPassword", AlterarSenhaConstants.MSG_OLD_PASSWORD_VAZIO},
                {AlterarSenhaDataFactory.alteraSenhaConfirmPasswordDiferent(), 400, "fieldErrors.passwordConfirmationValid", AlterarSenhaConstants.MSG_CONFIRM_PASSWORD_DIFERENT},
                {AlterarSenhaDataFactory.alteraSenhaComOldPasswordErrado(), 401, "message", AlterarSenhaConstants.MSG_OLD_PASSORD_ERRADO},
        };
    }
}
