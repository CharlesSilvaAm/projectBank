package com.vemser.hackaton.dbcbank.rest.model.enums;

public enum TiposChavePix {
    CPF(1),
    TELEFONE(2),
    EMAIL(3),
    INVALIDO(4);

    private final int valor;

    TiposChavePix(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static TiposChavePix fromValor(int valor) {
        for (TiposChavePix tipo : TiposChavePix.values()) {
            if (tipo.getValor() == valor) {
                return tipo;
            }
        }
        return null;
    }
}