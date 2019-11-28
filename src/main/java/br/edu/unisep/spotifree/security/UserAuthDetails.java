package br.edu.unisep.spotifree.security;



import br.edu.unisep.spotifree.model.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
public class UserAuthDetails implements UserDetails {

    private String username;
    private String password;

    private Integer userId;
    private String name;

    private Collection<GrantedAuthority> authorities;

    private boolean credentialsNonExpired = true;
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean enabled = true;

    public static UserAuthDetails build(User user) {
        var details = new UserAuthDetails();
        details.userId = user.getId();
        details.username = user.getLogin();
        details.password = user.getPassword();
        details.name = user.getName();

        details.authorities = user.getRoles().stream().map(
                r -> new SimpleGrantedAuthority(r.getIdRole().getId())
        ).collect(Collectors.toList());

        return details;
    }
}
