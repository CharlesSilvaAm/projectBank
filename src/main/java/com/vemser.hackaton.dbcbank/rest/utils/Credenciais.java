package com.vemser.hackaton.dbcbank.rest.utils;

import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Credenciais {

    public static String getUsername() {
        return getProp().getProperty("username");
    }

    public static String getPassword() {
        return getProp().getProperty("password");
    }

    public static String getDestinationKey(){
        return getProp().getProperty("transferDestinationKey");
    }

    public static Properties getProp() {
        try (InputStream inputStream = LoginDataFactory.class.getClassLoader().getResourceAsStream("dados-teste.properties")){
            if (inputStream == null){
                throw new FileNotFoundException("Arquivo não encontrado");
            }
            Properties props = new Properties();
            props.load(inputStream);
            return props;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}