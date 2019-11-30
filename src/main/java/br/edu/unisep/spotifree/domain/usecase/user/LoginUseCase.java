package br.edu.unisep.spotifree.domain.usecase.user;

import br.edu.unisep.spotifree.domain.dto.login.LoginDto;
import br.edu.unisep.spotifree.domain.dto.login.LoginResultDto;
import br.edu.unisep.spotifree.security.JwtProvider;
import br.edu.unisep.spotifree.security.UserAuthDetails;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginUseCase {

    private JwtProvider jwtProvider;
    private AuthenticationManager authManager;

    public LoginResultDto execute(LoginDto loginData) {
        var auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginData.getLogin(), loginData.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(auth);
        var token = jwtProvider.generateToken(auth);

        var userAuthDetails = (UserAuthDetails) auth.getPrincipal();

        return LoginResultDto.builder()
                .name(userAuthDetails.getName())
                .login(userAuthDetails.getUsername())
                .token(token)
                .userId(userAuthDetails.getUserId())
                .build();
    }

}
