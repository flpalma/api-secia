package br.com.secia.apisecia.utils;

public enum PrioridadeEnum {

    URGENTE("Urgente"),
    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa");


    private String valor;

    private PrioridadeEnum (String valor) {
        this.valor = valor;
    }
}
