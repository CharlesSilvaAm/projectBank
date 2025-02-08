package com.vemser.hackaton.dbcbank.rest.data.factory;

import com.vemser.hackaton.dbcbank.rest.model.EnderecoModel;
import com.vemser.hackaton.dbcbank.rest.utils.DataFakerGeneration;

public class EnderecoDataFactory {

    private static EnderecoModel criandoEndereco() {
        EnderecoModel endereco = new EnderecoModel();
        endereco.setAddress(DataFakerGeneration.enderecoFaker());
        endereco.setAddressNumber(DataFakerGeneration.numeroEnderecoFaker());
        endereco.setAddressDetails(DataFakerGeneration.detalhesEnderecoFaker());
        endereco.setZipCode(DataFakerGeneration.cepFaker());
        endereco.setDistrict(DataFakerGeneration.bairroFaker());
        endereco.setCity(DataFakerGeneration.cidadeFaker());
        endereco.setState(DataFakerGeneration.estadoFaker());
        endereco.setCountry(DataFakerGeneration.paisFaker());

        return endereco;
    }

    public static EnderecoModel enderecoValido() {
        return criandoEndereco();
    }
}
