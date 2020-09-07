package br.com.secia.apisecia.utils;

public enum StatusEnum {

    ABERTO("Aberta"),
    FECHADA("Fechada");


    private String valor;

    private StatusEnum(String valor) {
        this.valor = valor;
    }
}
