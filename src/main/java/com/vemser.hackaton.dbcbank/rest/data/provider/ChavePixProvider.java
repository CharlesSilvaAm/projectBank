package com.vemser.hackaton.dbcbank.rest.data.provider;
import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.ChavePixDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.UsuarioDataFactory;
import com.vemser.hackaton.dbcbank.rest.model.UsuarioResponse;
import org.testng.annotations.DataProvider;
public class ChavePixProvider {

    static UsuarioResponse usuario = UsuarioDataFactory.pegarDadosUsuario(LoginDataFactory.loginUsuarioFixo());

    @DataProvider(name = "createPixKeyData")
    public static Object[][] getCreatePixKey() {
        return new Object[][] {
                {ChavePixDataFactory.pixKeyCpf(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 201, "key", usuario.getDocument()},
                {ChavePixDataFactory.pixKeyPhoneNumber(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 201, "key", usuario.getPhoneNumber()},
                {ChavePixDataFactory.pixKeyEmail(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 201, "key", usuario.getEmail()},
                {ChavePixDataFactory.pixKeyInvalid(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 400, "fieldErrors.type", "Tipo inválido. Tipos permitidos: 'cpf', 'telefone', 'email', 'chave-aleatória', "}
        };
    }

    @DataProvider(name = "deletePixKeyData")
    public static Object[][] getDeletePixKey() {
        return new Object[][] {
                {usuario.getDocument(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 204, "", ""},
                {usuario.getPhoneNumber(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 204, "", ""},
                {usuario.getEmail(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 204, "", ""},
                {usuario.getName(), LoginDataFactory.pegarAuthTokenUsuarioFixo(), 404, "message", "Chave pix não encontrada. Verifique a chave informada e tente novamente."},
        };
    }

}
