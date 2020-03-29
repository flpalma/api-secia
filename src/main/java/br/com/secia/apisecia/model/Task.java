package br.com.secia.apisecia.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name="TB_TASK")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String titulo;
    private Date data;
    private String prioridade;
    private Integer codigoCliente;
    private Integer codigoLocal;
    private String descricao;

}
