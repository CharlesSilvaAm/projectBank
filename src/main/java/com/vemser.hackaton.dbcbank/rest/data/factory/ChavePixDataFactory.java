package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.client.ChavePixClient;
import com.vemser.hackaton.dbcbank.rest.model.*;
import com.vemser.hackaton.dbcbank.rest.model.enums.TiposChavePix;


import java.util.ArrayList;
import java.util.List;

public class ChavePixDataFactory {
    static UsuarioResponse usuario = UsuarioDataFactory.pegarDadosUsuario(LoginDataFactory.loginUsuarioFixo());
    static ChavePixClient pixClient = new ChavePixClient();

    public static ChavePixRequest pixKeyCpf(){
        ChavePixRequest pixModel = new ChavePixRequest();
        pixModel.setType(String.valueOf(TiposChavePix.CPF).toLowerCase());
        return pixModel;
    }

    public static ChavePixRequest pixKeyPhoneNumber(){
        ChavePixRequest pixModel = new ChavePixRequest();
        pixModel.setType(String.valueOf(TiposChavePix.TELEFONE).toLowerCase());
        return pixModel;
    }

    public static ChavePixRequest pixKeyRandom(){
        ChavePixRequest pixModel = new ChavePixRequest();
        pixModel.setType("chave-aleatória");
        return pixModel;
    }

    public static ChavePixRequest pixKeyEmail(){
        ChavePixRequest pixModel = new ChavePixRequest();
        pixModel.setType(String.valueOf(TiposChavePix.EMAIL).toLowerCase());
        return pixModel;
    }

    public static ChavePixRequest pixKeyInvalid(){
        ChavePixRequest pixModel = new ChavePixRequest();
        pixModel.setType(String.valueOf(TiposChavePix.INVALIDO).toLowerCase());
        return pixModel;
    }

    public static String getRandomPixKeyFromUser(){
        List<ChavePixRequest> pixKeys = usuario.getBankAccount().getPixKeys();

        if (pixKeys == null){
            return null;
        }

        for (ChavePixRequest pix : pixKeys){
            if(pix.getType().equalsIgnoreCase("chave-aleatória")){
                return pix.getType();
            }
        }
        return null;
    }

    public static List<ChavePixRequest> getPixKeysType() {
        List<ChavePixRequest> pixKeys = new ArrayList<>();

        pixKeys.add(pixKeyCpf());
        pixKeys.add(pixKeyEmail());
        pixKeys.add(pixKeyPhoneNumber());
        pixKeys.add(pixKeyRandom());

        return pixKeys;
    }

    public static List<String> getPixKeys() {
        List<String> pixKeys = new ArrayList<>();

        pixKeys.add(usuario.getEmail());
        pixKeys.add(usuario.getDocument());
        pixKeys.add(usuario.getPhoneNumber());
        pixKeys.add(getRandomPixKeyFromUser());

        return pixKeys;
    }

    public static void createPixKeys(){
        List<ChavePixRequest> listPix = getPixKeysType();

        for (ChavePixRequest pixTypeRequestModel : listPix){
            pixClient.createPixKey(pixTypeRequestModel, LoginDataFactory.pegarAuthTokenUsuarioFixo());
        }
    }

    public static void deletePixKeys(){
        List<String> listPix = getPixKeys();

        for (String pixKey : listPix){
            pixClient.deletePixKey(pixKey, LoginDataFactory.pegarAuthTokenUsuarioFixo());
        }
    }
}
