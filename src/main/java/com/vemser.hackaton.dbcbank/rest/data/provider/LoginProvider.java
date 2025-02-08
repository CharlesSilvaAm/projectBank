package com.vemser.hackaton.dbcbank.rest.data.provider;

import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.utils.LoginConstants;

import org.testng.annotations.DataProvider;

public class LoginProvider {

    @DataProvider(name = "providerLoginUsuarioInvalido")
    public static Object[][] providerLoginUsuarioInvalido() {
        return new Object[][]{
                {LoginDataFactory.loginComSenhaInvalida(), 401, "message", LoginConstants.MSG_PASSWORD_INVALIDO},
                {LoginDataFactory.loginComUsernameInvalido(), 400,"fieldErrors.username", LoginConstants.MSG_USERNAME_INVALIDO},
        };
    }
    @DataProvider(name = "providerLoginUsuarioValido")
    public static Object[][] providerLoginUsuarioValido() {
        return new Object[][]{
                {LoginDataFactory.loginValido(), 200 },
        };
    }

}