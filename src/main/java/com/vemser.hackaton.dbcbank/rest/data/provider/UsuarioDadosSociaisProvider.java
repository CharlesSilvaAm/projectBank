package com.vemser.hackaton.dbcbank.rest.data.provider;

import com.vemser.hackaton.dbcbank.rest.data.factory.LoginDataFactory;
import com.vemser.hackaton.dbcbank.rest.data.factory.UsuarioDadosSociaisDataFactory;
import org.testng.annotations.DataProvider;

public class UsuarioDadosSociaisProvider {

    @DataProvider(name = "providerAtualizarDadosSociais")
    public static Object[][] providerAtualizarDadosSociais() {
        return new Object[][]{
                {UsuarioDadosSociaisDataFactory.criandoUsuarioDadosSociais(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemGender(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemRace(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemOccupation(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemEducationLevel(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemJobExperience(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemMonthlyIncome(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemWorkType(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioSemPcd(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioComJobExperienceInvalido(), 400, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioComGenderInvalido(), 400, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioComMonthlyIncomeInvalido(), 400, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioComRaceInvalido(), 400, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioComWorkTypeInvalido(), 200, LoginDataFactory.fazerLoginValidoRetornandoToken()},
                {UsuarioDadosSociaisDataFactory.usuarioComEducationLevelInvalido(), 400, LoginDataFactory.fazerLoginValidoRetornandoToken()}
        };
    }

}
