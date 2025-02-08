package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.UsuarioDadosPessoaisRequest;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;

public class UsuarioDadosPessoaisDataFactory {

    private static UsuarioDadosPessoaisRequest criandoUsuarioDadosPessoaisRequest() {
        UsuarioDadosPessoaisRequest usuario = new UsuarioDadosPessoaisRequest();
        usuario.setName(DataFakerGeneration.nomeUsuarioFaker());
        usuario.setBirthdate(DataFakerGeneration.dataFaker());
        usuario.setPhoneNumber(DataFakerGeneration.telefoneFaker());
        usuario.setPronoun(DataFakerGeneration.pronomeFaker());
        usuario.setAddress(EnderecoDataFactory.enderecoValido());

        return usuario;
    }

    public static UsuarioDadosPessoaisRequest dadosPessoaisValidos() {
        return criandoUsuarioDadosPessoaisRequest();
    }

    public static UsuarioDadosPessoaisRequest usuarioSemNome() {
        UsuarioDadosPessoaisRequest usuario = criandoUsuarioDadosPessoaisRequest();
        usuario.setName(null);

        return usuario;
    }

    public static UsuarioDadosPessoaisRequest usuarioSemDataNascimento() {
        UsuarioDadosPessoaisRequest usuario = dadosPessoaisValidos();
        usuario.setBirthdate(null);
        return usuario;
    }

    public static UsuarioDadosPessoaisRequest usuarioSemTelefone() {
        UsuarioDadosPessoaisRequest usuario = dadosPessoaisValidos();
        usuario.setPhoneNumber(null);
        return usuario;
    }

    public static UsuarioDadosPessoaisRequest usuarioSemPronome() {
        UsuarioDadosPessoaisRequest usuario = dadosPessoaisValidos();
        usuario.setPronoun(null);
        return usuario;
    }

    public static UsuarioDadosPessoaisRequest usuarioSemEndereco() {
        UsuarioDadosPessoaisRequest usuario = dadosPessoaisValidos();
        usuario.setAddress(null);
        return usuario;
    }

}
