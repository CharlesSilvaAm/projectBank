package com.vemser.hackaton.dbcbank.rest.utils;

import net.datafaker.Faker;

import java.util.Locale;

public class DataFakerGeneration {

    static Faker faker = new Faker(new Locale("PT", "BR" ));

    public static String nomeUsuarioFaker() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }
    public static String cpfValidoFaker() {
        String cpfFormatado = faker.cpf().valid();
        return cpfFormatado.replaceAll("[.-]", "");}

    public static String cpfInvalidoFaker(){return faker.cpf().invalid();}

    public static String telefoneFaker() {return faker.phoneNumber().cellPhone();}

    public static String emailFaker() {return faker.internet().emailAddress();}

    public static String senhaFaker() {return faker.internet().password(8,10)+ "Ab1!";}

    public static String senhaCartaoFaker() {return faker.bothify("####");}

    public static String diaFaker() {return String.format("%02d", faker.number().numberBetween(1, 28));}

    public static String mesFaker() {return String.format("%02d", faker.number().numberBetween(1, 12));}

    public static String anoFaker() {return String.valueOf(faker.number().numberBetween(1906, 2006));}

    public static String dataFaker() { return diaFaker() + "/" + mesFaker() + "/" + anoFaker();}

    public static String emailInvalidoFaker(){return faker.name().name();}

    public static int numeroAleatorioFaker(int a, int b){
        return faker.number().numberBetween(a,b);
    }

    public static String emailInvalid(){return faker.name().name();}

    public static String genderFaker(){return faker.options().option("Homem Cis", "Mulher Cis", "Homem Trans", "Mulher Trans", "Outra identidade de gênero");}

    public static String raceFaker(){return faker.options().option( "Branca", "Preta", "Parda", "Amarela", "Indígena", "Prefiro não responder");}

    public static Boolean pcdFaker(){return faker.bool().bool();}

    public static String pdcDescriptionFaker(Boolean pcd){return pcd ? faker.medical().diseaseName() : null;}

    public static String educationLevelFaker(){return faker.options().option("Mestrado", "Pós Graduação Completa", "Pós Graduação Incompleta", "Ensino Superior Completo", "Ensino Superior Incompleto", "Ensino Médio Completo", "Ensino Médio Incompleto", "Ensino Fundamental Completo", "Ensino Fundamental Incompleto");}

    public static String occupationFaker() {return faker.job().title();}

    public static String monthlyIncomeFaker() {return faker.options().option("Até R$1.100,00", "Entre R$1.100,00 e R$2.200,00", "Entre R$2.200,00 e R$3.300,00", "Entre R$3.300,00 e R$5.500,00", "Acima de R$5.500,00");}

    public static String jobExperienceFaker() {return faker.options().option("Até 1 ano", "Entre 1 e 3 anos", "Entre 3 e 5 anos", "Acima de 5 anos");}

    public static String workTypeFaker() {return faker.options().option("Contrato por tempo determinado", "Contrato CLT", "Contrato de trabalho eventual", "Contrato de estágio", "Contrato de experiência", "Contrato de teletrabalho", "Contrato intermitente", "Contrato de trabalho autônomo");}

    public static String pronomeFaker() {return faker.options().option("ele/dele", "ela/dela", "elu/delu", "eles/deles");}

    public static String enderecoFaker() {
        String endereco = faker.address().streetName();
        return endereco.replaceAll("[.'-]", "");}

    public static String numeroEnderecoFaker() {return faker.address().streetAddressNumber();}

    public static String detalhesEnderecoFaker() {
        String detalhes = faker.address().streetAddress();
        return detalhes.replaceAll("[./'-]", "");}

    public static String cepFaker() {return faker.address().zipCode();}

    public static String bairroFaker() {
        String bairro = faker.address().cityName();
        return bairro.replaceAll("[.'-]", "");}

    public static String cidadeFaker() {
        String cidade = faker.address().city();
        return cidade.replaceAll("[.'-]", "");}

    public static String estadoFaker() {return faker.address().stateAbbr();}

    public static String paisFaker() {return faker.address().country();}
 }

