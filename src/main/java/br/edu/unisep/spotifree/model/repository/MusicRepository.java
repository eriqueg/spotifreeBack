package br.edu.unisep.spotifree.model.repository;

import br.edu.unisep.spotifree.model.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, Integer> {

    List<Music> findByName(String name);

}
