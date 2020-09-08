package br.com.secia.apisecia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class PrioritiesDto {

    private Integer quantidadeUrgente;
    private Integer quantidadeAlta;
    private Integer quantidadeMedia;
    private Integer quantidadeBaixa;

}
