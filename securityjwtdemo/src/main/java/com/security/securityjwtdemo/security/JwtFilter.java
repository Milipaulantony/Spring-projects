package com.security.securityjwtdemo.security;

import com.security.securityjwtdemo.service.CustomerUserDetailsService;
import com.security.securityjwtdemo.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final CustomerUserDetailsService uds;

    private static final Logger logger = LoggerFactory.getLogger(JwtFilter.class);

    public JwtFilter(
            JwtService jwtService,
            CustomerUserDetailsService uds) {
        this.jwtService = jwtService;
        this.uds = uds;
    }
    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain)
            throws ServletException, IOException {

        logger.info("*****JWTINFO:::doFilterInternal started");
        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);
            String username = jwtService.extractUsername(token);
            UserDetails user = uds.loadUserByUsername(username);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        logger.info("*****JWTINFO:::doFilterInternal ended");

        chain.doFilter(request, response);
    }

    protected boolean shouldNotFilter(
            HttpServletRequest request) {
        return request.getServletPath()
                .equals("employee/auth/login");
    }
}
