package com.basic.securitydemo.security;

import com.basic.securitydemo.service.UserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserDetailsService uds;
    private final PasswordEncoder encoder;

    public CustomAuthenticationProvider(
            UserDetailsService uds,
            PasswordEncoder encoder) {

        this.uds = uds;
        this.encoder = encoder;
    }
    @Override
    public  Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username =
                authentication.getName();

        String password =
                authentication.getCredentials()
                        .toString();

        UserDetails user =
                uds.loadUserByUsername(username);

        if (!encoder.matches(
                password,
                user.getPassword())) {

            throw new BadCredentialsException(
                    "Invalid Password");
        }

        return new UsernamePasswordAuthenticationToken(
                user,
                password,
                user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
