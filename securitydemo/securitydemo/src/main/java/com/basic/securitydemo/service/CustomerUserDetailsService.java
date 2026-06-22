package com.basic.securitydemo.service;

import com.basic.securitydemo.entity.AppUser;
import com.basic.securitydemo.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    public CustomerUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public UserDetails loadUserByUsername(
            String username)
            throws UsernameNotFoundException {

        AppUser user =
                repository.findByUsername(username)
                        .orElseThrow(
                                () -> new UsernameNotFoundException(
                                        "User not found"));

        return User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }
}
