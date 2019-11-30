package br.edu.unisep.spotifree.domain.dto.playlist;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaylistDto {

    private Integer id;

    private String name;

}
