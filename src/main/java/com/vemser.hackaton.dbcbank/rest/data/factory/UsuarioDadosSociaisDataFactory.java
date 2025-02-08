package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.UsuarioDadosSociaisRequest;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;

public class UsuarioDadosSociaisDataFactory {

    public static UsuarioDadosSociaisRequest criandoUsuarioDadosSociais() {
        UsuarioDadosSociaisRequest userSocialData = new UsuarioDadosSociaisRequest();
        userSocialData.setGender(DataFakerGeneration.genderFaker());
        userSocialData.setSelfDeclaredRace(DataFakerGeneration.raceFaker());
        userSocialData.setPcd(DataFakerGeneration.pcdFaker());
        userSocialData.setPcdDescription(DataFakerGeneration.pdcDescriptionFaker(userSocialData.isPcd()));
        userSocialData.setEducationalLevel(DataFakerGeneration.educationLevelFaker());
        userSocialData.setOccupation(DataFakerGeneration.occupationFaker());
        userSocialData.setMonthlyIncome(DataFakerGeneration.monthlyIncomeFaker());
        userSocialData.setJobExperience(DataFakerGeneration.jobExperienceFaker());
        userSocialData.setWorkType(DataFakerGeneration.workTypeFaker());
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemGender() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setGender(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemRace() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setSelfDeclaredRace(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemPcd() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setPcd(true);
        userSocialData.setPcdDescription(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemEducationLevel() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setEducationalLevel(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemOccupation() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setOccupation(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemMonthlyIncome() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setMonthlyIncome(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemJobExperience() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setJobExperience(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioSemWorkType() {
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setWorkType(null);
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioComGenderInvalido(){
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setGender(DataFakerGeneration.nomeUsuarioFaker());
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioComRaceInvalido(){
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setSelfDeclaredRace(DataFakerGeneration.occupationFaker());
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioComWorkTypeInvalido(){
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setOccupation(DataFakerGeneration.nomeUsuarioFaker());
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioComJobExperienceInvalido(){
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setJobExperience(DataFakerGeneration.occupationFaker());
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioComEducationLevelInvalido(){
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setEducationalLevel(DataFakerGeneration.nomeUsuarioFaker());
        return userSocialData;
    }

    public static UsuarioDadosSociaisRequest usuarioComMonthlyIncomeInvalido(){
        UsuarioDadosSociaisRequest userSocialData = criandoUsuarioDadosSociais();
        userSocialData.setMonthlyIncome(DataFakerGeneration.emailInvalid());
        return userSocialData;
    }



}
