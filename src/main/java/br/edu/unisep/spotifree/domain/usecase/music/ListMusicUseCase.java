package br.edu.unisep.spotifree.domain.usecase.music;

import br.edu.unisep.spotifree.domain.dto.music.MusicDto;
import br.edu.unisep.spotifree.model.entity.Music;
import br.edu.unisep.spotifree.model.repository.MusicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ListMusicUseCase {

    private MusicRepository musicRepository;

    public List<MusicDto> execute(String name) {
        var musics = musicRepository.findByName(name);

        return musics.stream()
                .map(this::musicDto)
                .collect(Collectors.toList());

    }

    private MusicDto musicDto(Music music){
        return MusicDto.builder()
                .name(music.getName())
                .build();
    }


}
