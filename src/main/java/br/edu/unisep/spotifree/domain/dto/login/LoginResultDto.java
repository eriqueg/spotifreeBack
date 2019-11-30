package br.edu.unisep.spotifree.domain.dto.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResultDto {

    private Integer userId;
    private String login;
    private String name;
    private String token;

}
