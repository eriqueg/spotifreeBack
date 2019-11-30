package br.edu.unisep.spotifree.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Builder
@Table(name = "playlist")
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "playlist", fetch = FetchType.EAGER)
    private List<Playlist> playlists;

    @Column(name="ds_playlist")
    private String name;


}
