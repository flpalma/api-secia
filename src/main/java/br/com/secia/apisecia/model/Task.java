package br.com.secia.apisecia.model;

import br.com.secia.apisecia.utils.PrioridadeEnum;
import br.com.secia.apisecia.utils.StatusEnum;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "TB_TASK")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    private String titulo;

    private Date data;

    private Date dataPrevisaoAtendimento;

    @Enumerated(EnumType.STRING)
    private PrioridadeEnum prioridade;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    @ManyToOne(targetEntity = Client.class)
    private Client cliente;

    @ManyToOne(targetEntity = User.class)
    private User usuario;

    private Integer codigoLocal;

    private String descricao;

}
