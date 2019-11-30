package br.edu.unisep.spotifree.controller;

import br.edu.unisep.spotifree.domain.dto.login.LoginDto;
import br.edu.unisep.spotifree.domain.dto.login.LoginResultDto;
import br.edu.unisep.spotifree.domain.usecase.user.LoginUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/login")
public class LoginController {

    private LoginUseCase loginUseCase;

    @PostMapping
    public LoginResultDto login(@RequestBody LoginDto loginData) {
        return loginUseCase.execute(loginData);
    }

}
