package br.edu.unisep.spotifree.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="roles")
public class Role {

    @Id
    @Column(name="id_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ds_role")
    private String name;

}