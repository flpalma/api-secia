package br.com.secia.apisecia.utils;

import lombok.Getter;

public enum PrioridadeEnum {

    URGENTE("URGENTE"),
    ALTA("ALTA"),
    MEDIA("MÉDIA"),
    BAIXA("BAIXA");


    @Getter
    private String valor;

    private PrioridadeEnum (String valor) {
        this.valor = valor;
    }
}
