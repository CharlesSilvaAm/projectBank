package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.AlterarSenhaRequest;
import com.vemser.hackaton.dbcbank.rest.model.CadastroRequest;
import com.vemser.hackaton.dbcbank.rest.model.DadosDeUsuarioModel;
import com.vemser.hackaton.dbcbank.rest.model.LoginRequest;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;

public class AlterarSenhaDataFactory {
    private static AlterarSenhaRequest alterarSenha(){
        AlterarSenhaRequest alterar = new AlterarSenhaRequest();
        DadosDeUsuarioModel dados = DadosDeUsuarioDataFactory.gerarDadosDeUsuario();
        alterar.setOldPassword(dados.getCadastroRequest().getLoginPwd());
        String novaSenha = DataFakerGeneration.senhaFaker();
        alterar.setNewPassword(novaSenha);
        alterar.setNewPasswordConfirmation(novaSenha);
        alterar.setToken(dados.getAuth());
        return alterar;
    }
    public static AlterarSenhaRequest alterarSenhaValida() {return alterarSenha();}

    public static AlterarSenhaRequest alteraSenhaComOldPasswordVazio(){
        AlterarSenhaRequest alterar = alterarSenha();
        alterar.setOldPassword("");
        return alterar;
    }
    public static AlterarSenhaRequest alteraSenhaComOldPasswordErrado(){
        AlterarSenhaRequest alterar = alterarSenha();
        alterar.setOldPassword(DataFakerGeneration.senhaFaker());
        return alterar;
    }
    public static AlterarSenhaRequest alteraSenhaConfirmPasswordDiferent(){
        AlterarSenhaRequest alterar = alterarSenha();
        alterar.setNewPassword(DataFakerGeneration.senhaFaker());
        alterar.setNewPasswordConfirmation(DataFakerGeneration.senhaFaker());
        return alterar;
    }

}
