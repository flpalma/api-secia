package br.com.secia.apisecia.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="TB_GROUP")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String nome;
    @ManyToMany(mappedBy = "grupos")
    private Set<User> usuarios;
    @ManyToMany
    @JoinTable(name = "tb_group_permission",
            joinColumns = {@JoinColumn(name = "codigo_tb_group")},
            inverseJoinColumns = {@JoinColumn(name = "codigo_tb_permission")})
    private Set<Permission> permissoes;

}
