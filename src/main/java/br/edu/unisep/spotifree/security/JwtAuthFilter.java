package br.edu.unisep.spotifree.security;

import br.edu.unisep.spotifree.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private JwtProvider jwtProvider;
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = getToken(request);

        if (token != null && jwtProvider.isTokenValid(token)) {
            var userDetails = getUserAuthDetails(token);
            authenticateRequest(request, userDetails);
        }

        filterChain.doFilter(request, response);
    }

    private void authenticateRequest(HttpServletRequest request, UserAuthDetails userDetails) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authenticationToken.setDetails(new WebAuthenticationDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
    }

    private UserAuthDetails getUserAuthDetails(String token) {
        var login = jwtProvider.getUserFromToken(token);

        var user = userRepository.findByLogin(login);
        return UserAuthDetails.build(user);
    }

    private String getToken(HttpServletRequest request) {
        var token = request.getHeader("Authorization");

        if (token != null) {
            return token.replace("Bearer ", "");
        }

        return null;
    }


}
