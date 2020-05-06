package br.com.secia.apisecia.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="TB_USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String nome;
    private String login;
    private String senha;
    private Boolean ativo;

    @ManyToMany
    @JoinTable(name = "tb_user_permission",
            joinColumns = {@JoinColumn(name = "codigo_tb_user")},
            inverseJoinColumns = {@JoinColumn(name = "codigo_tb_permission")})
    private Set<Permission> permissoes;

    @ManyToMany
    @JoinTable(name = "tb_user_group",
            joinColumns = {@JoinColumn(name = "codigo_tb_user")},
            inverseJoinColumns = {@JoinColumn(name = "codigo_tb_group")})
    private Set<Group> grupos;

}
