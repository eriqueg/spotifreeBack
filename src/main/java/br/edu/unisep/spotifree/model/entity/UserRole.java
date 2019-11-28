package br.edu.unisep.spotifree.model.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "user_roles")
public class UserRole {

    @Id
    @Column(name = "id_user_role")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserRole;

    @ManyToOne
    @Column(name = "id_user")
    private User idUser;

    @OneToOne
    @Column(name = "id_role")
    private Role idRole;
}
