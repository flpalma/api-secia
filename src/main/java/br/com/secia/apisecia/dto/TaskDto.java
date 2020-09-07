package br.com.secia.apisecia.dto;

import br.com.secia.apisecia.utils.PrioridadeEnum;
import br.com.secia.apisecia.utils.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class TaskDto {

    private String titulo;
    private LocalDate data;
    private LocalDate dataPrevisaoAtendimento;
    private PrioridadeEnum prioridade;
    private StatusEnum status;
    private Long cliente;
    private String usuario;
    private Integer codigoLocal;
    private String descricao;




}
