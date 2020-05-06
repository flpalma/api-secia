package br.com.secia.apisecia.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name="TB_PERMISSION")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;
    private String nome;
    @ManyToMany(mappedBy = "permissoes")
    private Set<User> usuarios;
    @ManyToMany(mappedBy = "permissoes")
    private Set<Group> grupos;

}
