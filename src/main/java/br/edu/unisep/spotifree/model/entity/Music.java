package br.edu.unisep.spotifree.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@Table(name = "music")
@NoArgsConstructor
@AllArgsConstructor
public class Music {

    @Column(name="ds_music")
    private String name;

}
