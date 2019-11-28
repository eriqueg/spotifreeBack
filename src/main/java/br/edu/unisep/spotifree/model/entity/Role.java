package br.edu.unisep.spotifree.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name="roles")
public class Role {

    @Id
    @Column(name="id_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="ds_role")
    private String name;

}