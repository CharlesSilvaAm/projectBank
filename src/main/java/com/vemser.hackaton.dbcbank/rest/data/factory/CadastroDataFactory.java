package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.client.CadastroClient;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;
import org.apache.commons.lang3.StringUtils;

public class CadastroDataFactory {
    static CadastroClient client = new CadastroClient();

    private static CadastroRequest criarNovoCadastro() {
        CadastroRequest usuario = new CadastroRequest();
        usuario.setName(DataFakerGeneration.nomeUsuarioFaker());
        usuario.setDocument(DataFakerGeneration.cpfValidoFaker());
        usuario.setPhoneNumber(DataFakerGeneration.telefoneFaker());
        usuario.setEmail(DataFakerGeneration.emailFaker());
        usuario.setEmailConfirmation(usuario.getEmail());
        usuario.setLoginPwd(DataFakerGeneration.senhaFaker());
        usuario.setLoginPwdConfirmation(usuario.getLoginPwd());
        usuario.setTransactionPwd(DataFakerGeneration.senhaCartaoFaker());
        usuario.setTransactionPwdConfirmation(usuario.getTransactionPwd());
        usuario.setConsentOpt(true);
        usuario.setBirthdate(DataFakerGeneration.dataFaker());
        return usuario;
    }

    public static CadastroRequest usuarioValido() {
        return criarNovoCadastro();
    }

    public static CadastroRequest usuarioSemNome(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setName(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemDocumento(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setDocument(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemPhone(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setPhoneNumber(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemEmail(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setEmail(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemEmailConfirmation(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setEmailConfirmation(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemLoginPassword(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setLoginPwd(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemLoginPassWordConfirmation(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setLoginPwdConfirmation(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemTransactionPassword(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setTransactionPwd(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemTransactionPwdConfirmation(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setTransactionPwdConfirmation(null);
        return usuario;
    }

    public static CadastroRequest usuarioSemBirthDate(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setBirthdate(null);
        return usuario;
    }

    public static CadastroRequest usuarioComDocumentoInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setDocument(DataFakerGeneration.cpfInvalidoFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComPhoneNumberInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setPhoneNumber(DataFakerGeneration.nomeUsuarioFaker());
        return usuario;
    }
    public static CadastroRequest usuarioComEmailInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setEmail(DataFakerGeneration.emailInvalidoFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComEmailConfirmationInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setEmailConfirmation(DataFakerGeneration.emailInvalidoFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComLoginPasswordInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setLoginPwd(DataFakerGeneration.cpfValidoFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComLoginPassWordConfirmationInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setLoginPwdConfirmation(DataFakerGeneration.senhaFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComTransactionPasswordInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setTransactionPwd(DataFakerGeneration.nomeUsuarioFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComTransactionPwdConfirmationInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setTransactionPwdConfirmation(DataFakerGeneration.senhaFaker());
        return usuario;
    }

    public static CadastroRequest usuarioComBirthDateInvalido(){
        CadastroRequest usuario = criarNovoCadastro();
        usuario.setBirthdate(DataFakerGeneration.nomeUsuarioFaker());
        return usuario;
    }

    public static CadastroRequest cadastrarNovoUsuarioValido(){
        CadastroRequest usuario = CadastroDataFactory.criarNovoCadastro();
        client.realizarCadastro(usuario);
        return usuario;
    }

}
