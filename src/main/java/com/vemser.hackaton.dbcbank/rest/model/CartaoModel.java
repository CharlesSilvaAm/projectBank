package com.vemser.hackaton.dbcbank.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartaoModel {
    private String nomeNoCartao;
    private String numeroCartao;
    private String bandeira;
    private String dataDeVencimento;
    private String CVC;
    private String tipoDeCartao;
    private boolean isInternacional;
    private boolean isBloqueado;

}
