package br.edu.unisep.spotifree.model.repository;


import br.edu.unisep.spotifree.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByLogin(String login);

}
