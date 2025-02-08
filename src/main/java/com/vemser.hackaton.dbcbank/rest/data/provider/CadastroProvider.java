package com.vemser.hackaton.dbcbank.rest.data.provider;

import com.vemser.hackaton.dbcbank.rest.data.factory.CadastroDataFactory;
import com.vemser.hackaton.dbcbank.rest.utils.CadastroConstantes;
import org.testng.annotations.DataProvider;

public class CadastroProvider {

    @DataProvider(name = "providerCadastroUsuario")
    public static Object[][] providerCadastroUsuario() {
        return new Object[][]{
                {CadastroDataFactory.usuarioValido(), 201, "message", CadastroConstantes.MSG_CADASTRO_VALIDO},
                {CadastroDataFactory.usuarioSemNome(), 400, "fieldErrors.name", CadastroConstantes.MSG_CADASTRO_SEM_NAME},
                {CadastroDataFactory.usuarioSemDocumento(), 400, "fieldErrors.document", CadastroConstantes.MSG_CADASTRO_SEM_DOCUMENT},
                {CadastroDataFactory.usuarioSemPhone(), 400, "fieldErrors.phoneNumber", CadastroConstantes.MSG_CADASTRO_SEM_PHONE},
                {CadastroDataFactory.usuarioSemEmail(), 400, "fieldErrors.email", CadastroConstantes.MSG_CADASTRO_SEM_EMAIL},
                {CadastroDataFactory.usuarioSemEmailConfirmation(), 400, "fieldErrors.emailConfirmation", CadastroConstantes.MSG_CADASTRO_SEM_EMAIL_CONFIRMATION},
                {CadastroDataFactory.usuarioSemLoginPassword(), 400, "fieldErrors.loginPwdConfirmationValid", CadastroConstantes.MSG_CADASTRO_SEM_LOGIN_PASSWORD},
                {CadastroDataFactory.usuarioSemLoginPassWordConfirmation(), 400, "fieldErrors.loginPwdConfirmation", CadastroConstantes.MSG_CADASTRO_SEM_LOGIN_PASSWORD_CONFIRMATION},
                {CadastroDataFactory.usuarioSemTransactionPassword(), 400, "fieldErrors.transactionPwd", CadastroConstantes.MSG_CADASTRO_SEM_TRANSACTION_PASSWORD},
                {CadastroDataFactory.usuarioSemTransactionPwdConfirmation(), 400, "fieldErrors.transactionPwdConfirmation", CadastroConstantes.MSG_CADASTRO_SEM_TRANSACTION_PASSWORD_CONFIRMATION},
                {CadastroDataFactory.usuarioSemBirthDate(), 400, "fieldErrors.birthdate", CadastroConstantes.MSG_CADASTRO_SEM_DATEBIRTH},
                {CadastroDataFactory.usuarioComDocumentoInvalido(), 400, "fieldErrors.document", CadastroConstantes.MSG_CADASTRO_DOCUMENT_INVALID},
                {CadastroDataFactory.usuarioComPhoneNumberInvalido(), 400, "fieldErrors.phoneNumber", CadastroConstantes.MSG_CADASTRO_PHONE_INVALID},
                {CadastroDataFactory.usuarioComEmailInvalido(), 400, "fieldErrors.email", CadastroConstantes.MSG_CADASTRO_EMAIL_INVALID},
                {CadastroDataFactory.usuarioComEmailConfirmationInvalido(), 400, "fieldErrors.emailConfirmationValid", CadastroConstantes.MSG_CADASTRO_EMAIL_CONFIRMATION_INVALID},
                {CadastroDataFactory.usuarioComLoginPasswordInvalido(), 400, "fieldErrors.loginPwd", CadastroConstantes.MSG_CADASTRO_LOGIN_PASSWORD_INVALID},
                {CadastroDataFactory.usuarioComLoginPassWordConfirmationInvalido(), 400, "fieldErrors.loginPwdConfirmationValid", CadastroConstantes.MSG_CADASTRO_LOGIN_PASSWORD_CONFIRMATION_INVALID},
                {CadastroDataFactory.usuarioComTransactionPasswordInvalido(), 400, "fieldErrors.transactionPwd", CadastroConstantes.MSG_CADASTRO_TRANSACTION_PASSWORD_INVALID},
                {CadastroDataFactory.usuarioComTransactionPwdConfirmationInvalido(), 400, "fieldErrors.transactionPwdConfirmationValid", CadastroConstantes.MSG_CADASTRO_TRANSACION_PASSWORD_CONFIRMATION_INVALID},
                {CadastroDataFactory.usuarioComBirthDateInvalido(), 400, "fieldErrors.birthdate", CadastroConstantes.MSG_CADASTRO_DATEBIRTH_INVALID}
        };
    }
}
