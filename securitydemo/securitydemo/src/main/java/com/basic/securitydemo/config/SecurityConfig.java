package com.basic.securitydemo.config;

import com.basic.securitydemo.security.CustomAuthenticationProvider;
import com.basic.securitydemo.security.LoggingFilter;
import com.basic.securitydemo.service.CustomerUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final LoggingFilter loggingFilter;
    //private final CustomAuthenticationProvider provider;

    public SecurityConfig(LoggingFilter loggingFilter) {
        this.loggingFilter = loggingFilter;
    }

    @Bean
    PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public CustomAuthenticationProvider authenticationProvider(
            CustomerUserDetailsService uds,
            PasswordEncoder encoder) {

        CustomAuthenticationProvider provider = new CustomAuthenticationProvider(uds, encoder);
        return provider;
    }

    @Bean
    SecurityFilterChain filterChain(
            HttpSecurity http,
            CustomAuthenticationProvider provider)
            throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authenticationProvider(provider)

                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers("/h2-console/**").permitAll()
                                .requestMatchers("/admin/**")
                                .hasRole("ADMIN")

                                .requestMatchers("/hr/**")
                                .hasAnyRole(
                                        "ADMIN",
                                        "HR")

                                .requestMatchers("/employee/**")
                                .authenticated()

                                .anyRequest()
                                .authenticated())

                .formLogin(Customizer.withDefaults());

        http.addFilterBefore(
                loggingFilter,
                UsernamePasswordAuthenticationFilter.class);
        http.headers(headers ->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        return http.build();
    }



}
