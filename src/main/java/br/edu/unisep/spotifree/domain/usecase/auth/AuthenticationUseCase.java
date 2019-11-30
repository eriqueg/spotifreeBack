package br.edu.unisep.spotifree.domain.usecase.auth;

import br.edu.unisep.spotifree.model.repository.UserRepository;
import br.edu.unisep.spotifree.security.UserAuthDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationUseCase implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return UserAuthDetails.build(userRepository.findByLogin(login));
    }


}
