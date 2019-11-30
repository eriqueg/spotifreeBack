package br.edu.unisep.spotifree.domain.usecase.playlist;

import br.edu.unisep.spotifree.domain.dto.playlist.PlaylistDto;
import br.edu.unisep.spotifree.model.entity.Playlist;
import br.edu.unisep.spotifree.model.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListPlaylistUseCase {

    private PlaylistRepository playlistRepository;

    public List<PlaylistDto> execute(String name) {
        var playlists = playlistRepository.findByName(name);

        return playlists.stream()
                .map(this::playlistDto)
                .collect(Collectors.toList());

    }

        private PlaylistDto playlistDto(Playlist playlist){
            return PlaylistDto.builder()
                    .id(playlist.getId())
                    .name(playlist.getName())
                    .build();
        }

}
